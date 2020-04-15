package cn.baizhi.zw.serviceimp;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;

import cn.baizhi.zw.dao.ItemDAO;
import cn.baizhi.zw.entity.Book;
import cn.baizhi.zw.entity.Item;
import cn.baizhi.zw.entity.Order;
import cn.baizhi.zw.service.BookService;
import cn.baizhi.zw.service.ItemService;
import cn.baizhi.zw.util.MyBatisUtil;
import cn.baizhi.zw.vo.ShopCart;

public class ItemServiceImp implements ItemService {

	// 前台:添加订单项
	@Override
	public void insertItem(Item item) {
		SqlSession sqlSession = null;
		try {

			// 获取session对象
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			// 获取购物车对象shopMap
			HashMap<String, ShopCart> shopMap = (HashMap<String, ShopCart>) session
					.getAttribute("shopMap");
			// 遍历shopMap集合
			Set<Entry<String, ShopCart>> entrySet = shopMap.entrySet();
			for (Entry<String, ShopCart> entry : entrySet) {
				// 判断订单项的状态
				if (entry.getValue().getStatus() == true) {
					sqlSession = MyBatisUtil.getSqlSession();
					ItemDAO itemDAO = sqlSession.getMapper(ItemDAO.class);
					// 获取uuid
					String uuid = UUID.randomUUID().toString();
					// 设置订单项id
					item.setId(uuid);
					// 设置订单项图书id
					item.setBook_id(entry.getValue().getBook().getId());
					// 设置订单项图书名
					item.setBook_name(entry.getValue().getBook().getBook_name());
					// 设置订单项图书封面
					item.setBook_src(entry.getValue().getBook().getSrc());
					// 设置订单项价格
					item.setPrice(entry.getValue().getBook().getPrice());
					// 设置订单项dd价格
					item.setDd_price(entry.getValue().getBook().getDd_price());
					// 设置订单项数量
					item.setCount(entry.getValue().getCount());
					// 设置订单项小计
					item.setAmount(entry.getValue().getSubtotal());
					// 获取订单对象
					Order order = (Order) session.getAttribute("order");
					// 设置订单项订单id
					item.setOrder_id(order.getId());
					// 调用添加方法
					itemDAO.insertItem(item);
					// 手动提交事务
					MyBatisUtil.commit(sqlSession);
					// 修改图书的库存和销量
					BookService bookService = new BookServiceImp();
					Book book = new Book();
					// 获取要修改的图书id
					book.setId(entry.getValue().getBook().getId());
					// 通过图书id查询图书信息
					List<Book> showAll = bookService.showAll(book);
					for (Book book2 : showAll) {
						// 获取图书的库存和销量
						Integer sale_count = book2.getSale_count();
						Integer stock_count = book2.getStock_count();

						book.setSale_count(sale_count + item.getCount());
						book.setStock_count(stock_count + item.getCount());
						// 掉用修改方法修改库存和销量
						bookService.updateBook(book);
					}
				}
				// 销毁购物车信息
				session.removeAttribute("shopMap");
			}

		} catch (Exception e) {
			MyBatisUtil.rollback(sqlSession);
			e.printStackTrace();
		}
	}
}
