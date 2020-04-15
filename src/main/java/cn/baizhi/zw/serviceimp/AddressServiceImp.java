package cn.baizhi.zw.serviceimp;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;

import cn.baizhi.zw.dao.AddressDAO;
import cn.baizhi.zw.entity.Address;
import cn.baizhi.zw.entity.User;
import cn.baizhi.zw.service.AddressService;
import cn.baizhi.zw.util.MyBatisUtil;

public class AddressServiceImp implements AddressService {
	// 前台:添加地址
	@Override
	public void insertAddress(Address address) {
		SqlSession sqlSession = null;
		try {
			System.out.println("接受的地址为" + address);
			// 获取session
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			// 获取用户登录标记
			User user = (User) session.getAttribute("login");

			// 判断地址id是否为空
			if (address.getId().equals("")) {
				// 地址id为空,添加新的地址
				sqlSession = MyBatisUtil.getSqlSession();
				AddressDAO addressDAO = sqlSession.getMapper(AddressDAO.class);
				// 获取UUID
				String uuid = UUID.randomUUID().toString();
				// 将UUID设置为地址id
				address.setId(uuid);
				// 设置地址中的用户id
				address.setUser_id(user.getId());
				// 添加地址
				addressDAO.insertAddress(address);
				System.out.println("地址添加成功" + address);
				// 将添加成功后的地址存入session对象
				session.setAttribute("address", address);
				// 关闭资源
				MyBatisUtil.commit(sqlSession);
			} else {
				// 地址id不为空,通过地址id查询地址
				AddressService addressService = new AddressServiceImp();
				Address addre = addressService
						.queryAddressByid(address.getId());
				// 判断地址是否被修改
				address.setUser_id(user.getId());
				if (addre.equals(address)) {
					session.setAttribute("address", addre);
					System.out.println("地址一样，不进行修改");
				} else {
					// 不相同，修改地址
					addressService.updateAddress(address);
					System.out.println("地址修改成功");
					Address addr = addressService.queryAddressByid(address
							.getId());
					session.setAttribute("address", addr);
				}
			}

		} catch (Exception e) {
			MyBatisUtil.rollback(sqlSession);
			e.printStackTrace();
		}
	}

	// 前台: 通过地址id查询地址
	@Override
	public Address queryAddressByid(String id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		AddressDAO addressDAO = sqlSession.getMapper(AddressDAO.class);
		Address address = addressDAO.queryAddressByid(id);
		MyBatisUtil.close(sqlSession);
		return address;
	}

	// 前台: 通过用户id查询地址
	@Override
	public List<Address> queryAddressesByUserId(String userId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		AddressDAO addressDAO = sqlSession.getMapper(AddressDAO.class);
		List<Address> addresses = addressDAO.queryAddressesByUserId(userId);
		MyBatisUtil.close(sqlSession);
		return addresses;
	}

	// 前台:修改地址
	@Override
	public void updateAddress(Address address) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			AddressDAO addressDAO = sqlSession.getMapper(AddressDAO.class);
			addressDAO.updateAddress(address);
			MyBatisUtil.commit(sqlSession);
		} catch (Exception e) {
			MyBatisUtil.rollback(sqlSession);
			e.printStackTrace();
		}
	}
}
