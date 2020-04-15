package cn.baizhi.zw.action;

import cn.baizhi.zw.entity.Item;
import cn.baizhi.zw.entity.Order;
import cn.baizhi.zw.service.ItemService;
import cn.baizhi.zw.serviceimp.ItemServiceImp;

import com.opensymphony.xwork2.ActionSupport;

public class ItemAction extends ActionSupport {
	private Item item;
	private Order order;

	// 前台:添加订单项的方法
	public String insertItem() {
		ItemService itemService = new ItemServiceImp();
		Item item = new Item();
		itemService.insertItem(item);
		return "insertItemSuccess";
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
