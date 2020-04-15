package cn.baizhi.zw.serviceimp;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;

import cn.baizhi.zw.dao.AdminDAO;
import cn.baizhi.zw.entity.Admin;
import cn.baizhi.zw.service.AdminService;
import cn.baizhi.zw.util.MyBatisUtil;

public class AdminServiceImp implements AdminService {
	// 后台:管理员登录
	@Override
	public String adminLogin(Admin admin, String code) {
		// TODO Auto-generated method stub
		// 获取session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		String verifyCode = (String) session.getAttribute("verifyCode");
		String message = null;
		// 判断验证码
		if (verifyCode.equals(code)) {
			// 通过工具类获取sqlSession对象
			SqlSession sqlSession = MyBatisUtil.getSqlSession();
			// 获取dao层实现类对象
			AdminDAO adminDAO = sqlSession.getMapper(AdminDAO.class);
			Admin adminLogin = adminDAO.queryAdmin(admin);
			// 关闭连接对象
			MyBatisUtil.close(sqlSession);
			// 判断管理员是否存在
			if (adminLogin != null) {
				// 判断密码是否正确
				if (adminLogin.getPassword().equals(admin.getPassword())) {
					message = "登录成功";
					// 将对象传入session对象中
					session.setAttribute("adminLogin", adminLogin);
				} else {
					message = "密码错误";
				}
			} else {
				message = "用户名不存在";
			}
		} else {
			message = "验证码错误";
		}

		return message;
	}
}
