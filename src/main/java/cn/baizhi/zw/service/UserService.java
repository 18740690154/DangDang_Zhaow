package cn.baizhi.zw.service;

import java.util.List;

import cn.baizhi.zw.entity.User;

public interface UserService {
	// 后台:展示所有用户
	List<User> showAllUser();

	// 后台:通过用户id查询用户
	User queryById(User user);

	// 后台:修改用户状态
	void updateUser(User user);

	// 前台:用户注册
	String registUser(User user, String imgCode);

	// 前台:用户登录
	String loginUser(User user);

	// 前台:通过邮箱获取用户信息
	User queryByEmail(String email);

	// 前台:修改用户信息
	void update(User user);
}
