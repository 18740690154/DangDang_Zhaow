package cn.baizhi.zw.dao;

import cn.baizhi.zw.entity.Item;

public interface ItemDAO {

	// 前台:添加订单项
	void insertItem(Item item);
}
