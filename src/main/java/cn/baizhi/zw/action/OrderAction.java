package cn.baizhi.zw.action;

import java.util.List;

import cn.baizhi.zw.entity.Address;
import cn.baizhi.zw.entity.Order;
import cn.baizhi.zw.service.OrderService;
import cn.baizhi.zw.serviceimp.OrderServiceImp;

import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport {
	// 后台:展示所有订单接受的数据
	private List<Order> orders;
	// 添加订单接收到的数据
	private Address address;

	// 通过订单id查询订单接受的数据
	private Order order;

	// 后台:展示所有订单的方法
	public String showAll() {
		OrderService orderService = new OrderServiceImp();
		orders = orderService.showAllOrders();
		return "showAllSuccess";
	}

	// 前台:添加订单
	public String insertOrder() {
		OrderService orderService = new OrderServiceImp();
		Order order = new Order();
		orderService.insertOrder(order);
		return "insertOrderSuccess";
	}

	// 前台:通过订单id查询订单的方法
	public String showByOrderId() {
		OrderService orderService = new OrderServiceImp();
		order = orderService.queryOrderByOrderId(order);
		return "showByOrderIdSuccess";
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
