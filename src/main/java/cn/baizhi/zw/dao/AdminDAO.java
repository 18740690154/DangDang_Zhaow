package cn.baizhi.zw.dao;

import cn.baizhi.zw.entity.Admin;

public interface AdminDAO {
	// 后台:通过管理员名和密码登录
	Admin queryAdmin(Admin admin);
}
