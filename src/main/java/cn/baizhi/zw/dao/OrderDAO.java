package cn.baizhi.zw.dao;

import java.util.List;

import cn.baizhi.zw.entity.Order;

public interface OrderDAO {
	// 后台:查询所有的订单
	List<Order> queryAllOrders();

	// 前台:添加订单
	void insertOrder(Order order);

	// 后台:通过订单id查询订单
	Order queryOrderByOrderId(Order order);
}
