package cn.baizhi.zw.service;

import java.util.List;

import cn.baizhi.zw.entity.Order;

public interface OrderService {
	// 后台:展示所有订单
	List<Order> showAllOrders();

	// 前台:添加订单
	void insertOrder(Order order);

	// 后台:通过订单id查询订单项
	Order queryOrderByOrderId(Order order);
}
