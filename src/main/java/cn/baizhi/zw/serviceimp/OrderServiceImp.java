package cn.baizhi.zw.serviceimp;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;

import cn.baizhi.zw.dao.OrderDAO;
import cn.baizhi.zw.entity.Address;
import cn.baizhi.zw.entity.Order;
import cn.baizhi.zw.entity.User;
import cn.baizhi.zw.service.OrderService;
import cn.baizhi.zw.util.MyBatisUtil;
import cn.baizhi.zw.util.SnowflakeIdWorker;

public class OrderServiceImp implements OrderService {
	// 后台:展示所有订单
	@Override
	public List<Order> showAllOrders() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		OrderDAO orderDAO = sqlSession.getMapper(OrderDAO.class);
		List<Order> orders = orderDAO.queryAllOrders();
		MyBatisUtil.close(sqlSession);
		return orders;
	}

	// 前台:添加订单
	@Override
	public void insertOrder(Order order) {

		SqlSession sqlSession = null;
		try {
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			Address address = (Address) session.getAttribute("address");
			System.out.println("接受的地址信息为:" + address);
			sqlSession = MyBatisUtil.getSqlSession();
			OrderDAO orderDAO = sqlSession.getMapper(OrderDAO.class);

			// 获取uuid
			String uuid = UUID.randomUUID().toString();
			// 设置订单id
			order.setId(uuid);
			// 设置订单编号
			order.setOrder_number(SnowflakeIdWorker.getOrderNumber());
			// 设置订单时间
			order.setOrder_times(new Date());
			// 设置订单状态
			order.setOrder_state("未支付");
			// 获取session对象

			double totalPrice = (double) session.getAttribute("totalPrice");
			// 设置订单总价
			order.setTotal_price(totalPrice);
			// 设置订单地址id
			order.setAddr_id(address.getId());
			// 设置订单收货人
			order.setAddr_user(address.getName());
			// 设置订单收货地址
			order.setAddr_name(address.getDetail());
			User user = (User) session.getAttribute("login");
			// 设置订单用户id
			order.setUser_id(user.getId());
			// 添加订单
			orderDAO.insertOrder(order);
			MyBatisUtil.commit(sqlSession);
			// 将订单存入session对象
			session.setAttribute("order", order);
		} catch (Exception e) {
			MyBatisUtil.rollback(sqlSession);
			e.printStackTrace();

		}
	}

	// 后台:通过订单id查询订单
	@Override
	public Order queryOrderByOrderId(Order order) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		OrderDAO orderDAO = sqlSession.getMapper(OrderDAO.class);
		Order order1 = orderDAO.queryOrderByOrderId(order);
		MyBatisUtil.close(sqlSession);
		return order1;
	}

}
