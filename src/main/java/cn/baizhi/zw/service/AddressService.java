package cn.baizhi.zw.service;

import java.util.List;

import cn.baizhi.zw.entity.Address;

public interface AddressService {
	// 前台:添加地址
	void insertAddress(Address address);

	// 前台:通过地址id查询地址
	Address queryAddressByid(String id);

	// 前台: 通过用户id查询地址
	List<Address> queryAddressesByUserId(String userId);

	// 前台:修改地址
	void updateAddress(Address address);
}
