package cn.baizhi.test;

import org.junit.Test;

import cn.baizhi.zw.dao.AdminDAO;
import cn.baizhi.zw.entity.Admin;
import cn.baizhi.zw.util.MyBatisUtil;

public class TestAdminDAO {
	@Test
	public void testQueryAdmin(){
		AdminDAO adminDAO = MyBatisUtil.getSqlSession().getMapper(AdminDAO.class);
		Admin admin = new Admin("admin","admin");
		Admin admin1 = adminDAO.queryAdmin(admin);
		System.out.println(admin1);
	}
}
