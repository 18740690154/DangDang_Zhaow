package cn.baizhi.zw.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.baizhi.zw.entity.Book;
import cn.baizhi.zw.service.BookService;
import cn.baizhi.zw.serviceimp.BookServiceImp;
import cn.baizhi.zw.vo.ShopCart;

import com.opensymphony.xwork2.ActionSupport;

public class ShopCartAction extends ActionSupport {
	// 购物车添加图书接受的数据
	private Book book;
	private Integer countBook;
	private String message;

	// 购物车添加图书的方法
	public String add() {
		System.out.println("接受的book" + book);
		BookService bookService = new BookServiceImp();
		// 通过图书id查询图书的详细信息
		List<Book> showAll = bookService.showAll(book);
		System.out.println("通过id查询的图书信息" + showAll);
		Book b = null;
		for (Book book : showAll) {
			b = book;
			System.out.println("通过id查询的图书信息" + book);
		}
		// 获取session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		// 获取Map集合
		HashMap<String, ShopCart> shopMap = (HashMap<String, ShopCart>) session
				.getAttribute("shopMap");
		// 判断图书的库存
		if (b.getStock_count() > 0) {
			// 判断获取的map集合是否为空
			if (shopMap == null) {
				// 集合为空，创建map集合
				shopMap = new HashMap<String, ShopCart>();
				// 创建购物车(ShopCart)对象
				System.out.println("通过id查询的图书信息" + b);
				ShopCart shopCart = new ShopCart(b, 1, true, b.getDd_price());

				shopMap.put(b.getId(), shopCart);
			} else {
				// 集合不为空，判断集合中是否存在当前购买的商品
				if (shopMap.containsKey(book.getId())) {
					// 商品存在，通过键获取值来获取购物项对象
					ShopCart shopCart = shopMap.get(book.getId());
					// 判断购物项的状态
					Integer count = 0;
					if (shopCart.getStatus() == true) {
						// 数量加一
						count = shopCart.getCount() + 1;
						// 重新为数量(count)赋值
						shopCart.setCount(count);
					} else {
						shopCart.setStatus(true);
						shopCart.setCount(1);
					}
					// 重新为小计赋值(数量*单价)
					shopCart.setSubtotal(count * b.getDd_price());
				} else {
					// 商品不存在，创建购物车对象,并赋值
					ShopCart shopCart = new ShopCart(b, 1, true,
							b.getDd_price());
					shopMap.put(b.getId(), shopCart);
				}
			}
			// 将map集合存入session对象
			session.setAttribute("shopMap", shopMap);
			getPrice(shopMap);
			return "addSuccess";
		} else {
			message = b.getBook_name() + "的库存不足，无法购买";
			return "addError";
		}

	}

	// 修改购物项的数量
	public String update() {
		// 获取session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		// 获取map集合
		HashMap<String, ShopCart> shopMap = (HashMap<String, ShopCart>) session
				.getAttribute("shopMap");

		// 通过id查询图书
		BookService bookService = new BookServiceImp();
		List<Book> showAll = bookService.showAll(book);
		Book b = null;
		for (Book b1 : showAll) {
			b = b1;
		}
		System.out.println("book:" + book);
		System.out.println("showAll:" + showAll);
		System.out.println("shopMap:" + shopMap);
		System.out.println(b);
		// 通过键(图书id)获取值(购物项对象)
		ShopCart shopCart = shopMap.get(book.getId());
		System.out.println("shopCart:" + shopCart);

		if (b.getStock_count() >= countBook) {
			// 将接受的数量赋值给购物项的数量
			shopCart.setCount(countBook);
			// 改变购物项中的小计
			shopCart.setSubtotal(countBook * b.getDd_price());
			// 将map集合存入session对象
			session.setAttribute("shopMap", shopMap);
			getPrice(shopMap);
			return "updateSuccess";
		} else {
			message = b.getBook_name() + "的库存不足，无法购买";
			return "updateError";
		}

	}

	// 删除：修改购物项的状态
	public String delete() {
		// 获取session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		// 获取map集合
		HashMap<String, ShopCart> shopMap = (HashMap<String, ShopCart>) session
				.getAttribute("shopMap");
		// 通过键(图书id)获取值(购物项对象)
		ShopCart shopCart = shopMap.get(book.getId());
		// 修改购物项的状态
		shopCart.setStatus(false);
		// 将map集合存入session对象
		session.setAttribute("shopMap", shopMap);
		getPrice(shopMap);
		return "deleteSuccess";
	}

	// 恢复：修改购物项的状态
	public String regain() {
		// 获取session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		// 获取map集合
		HashMap<String, ShopCart> shopMap = (HashMap<String, ShopCart>) session
				.getAttribute("shopMap");
		// 通过键(图书id)获取值(购物项对象)
		ShopCart shopCart = shopMap.get(book.getId());
		// 修改购物项的状态
		shopCart.setStatus(true);
		// 将map集合存入session对象
		session.setAttribute("shopMap", shopMap);

		getPrice(shopMap);

		return "regainSuccess";
	}

	private String getPrice(HashMap<String, ShopCart> shopMap) {
		double savePrice = 0.0;
		double totalPrice = 0.0;
		Set<Entry<String, ShopCart>> entrySet = shopMap.entrySet();
		for (Entry<String, ShopCart> entry : entrySet) {
			if (entry.getValue().getStatus() == true) {
				// 总价格
				totalPrice += entry.getValue().getSubtotal();
				// 图书原价
				double price = entry.getValue().getBook().getPrice();
				// 图书dd_price
				double dd_price = entry.getValue().getBook().getDd_price();
				// 图书数量
				Integer count = entry.getValue().getCount();
				// 节省的总价格
				savePrice += count * (price - dd_price);

			}
		}
		// 获取session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		// 将savePrice，totalPrice存入session对象中
		session.setAttribute("totalPrice", totalPrice);
		session.setAttribute("savePrice", savePrice);
		return null;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Integer getCountBook() {
		return countBook;
	}

	public void setCountBook(Integer countBook) {
		this.countBook = countBook;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
