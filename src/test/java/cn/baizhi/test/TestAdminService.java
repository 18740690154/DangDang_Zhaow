package cn.baizhi.test;

import org.junit.Test;

import cn.baizhi.zw.entity.Admin;
import cn.baizhi.zw.service.AdminService;
import cn.baizhi.zw.serviceimp.AdminServiceImp;

public class TestAdminService {
	@Test
	public void testAdminLogin() {
		AdminService adminService = new AdminServiceImp();
		Admin admin = new Admin("admin", "admin");

		String adminLogin = adminService.adminLogin(admin, "code");
		System.out.println(adminLogin);

	}
}
