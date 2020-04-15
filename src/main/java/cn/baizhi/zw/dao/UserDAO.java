package cn.baizhi.zw.dao;

import java.util.List;

import cn.baizhi.zw.entity.User;

public interface UserDAO {
	// 后台:查询所有用户
	List<User> queryAllUser();

	// 后台:通过用户id查询用户
	User queryById(User user);

	// 后台: 修改用户状态
	void updateUser(User user);

	// 前台: 通过邮箱和密码查询用户
	User queryUser(User user);

	// 前台: 添加用户
	void insertUser(User user);

}
