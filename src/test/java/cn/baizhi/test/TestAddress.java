package cn.baizhi.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.baizhi.zw.dao.AddressDAO;
import cn.baizhi.zw.entity.Address;
import cn.baizhi.zw.util.MyBatisUtil;

public class TestAddress {
	@Test
	public void testUpdate() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		AddressDAO addressDAO = sqlSession.getMapper(AddressDAO.class);
		Address address = new Address("29aa3d79-5b43-4aad-b54e-fbadca05874e",
				"name", "detail", "zip_code1", "phone1", null);
		addressDAO.updateAddress(address);
		MyBatisUtil.commit(sqlSession);
	}
}
