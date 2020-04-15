package cn.baizhi.zw.dao;

import java.util.List;

import cn.baizhi.zw.entity.Address;

public interface AddressDAO {
	// 添加地址
	void insertAddress(Address address);

	// 通过地址id查询地址
	Address queryAddressByid(String id);

	// 通过用户id查询地址
	List<Address> queryAddressesByUserId(String userId);

	// 修改地址
	void updateAddress(Address address);

}
