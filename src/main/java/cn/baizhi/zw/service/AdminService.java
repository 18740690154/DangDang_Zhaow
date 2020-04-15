package cn.baizhi.zw.service;

import cn.baizhi.zw.entity.Admin;

public interface AdminService {
	// 后台: 管理员登录
	String adminLogin(Admin admin, String code);
}
