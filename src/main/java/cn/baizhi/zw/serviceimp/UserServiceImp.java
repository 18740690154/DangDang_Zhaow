package cn.baizhi.zw.serviceimp;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;

import cn.baizhi.zw.dao.UserDAO;
import cn.baizhi.zw.entity.User;
import cn.baizhi.zw.service.UserService;
import cn.baizhi.zw.util.Md5Utils;
import cn.baizhi.zw.util.MyBatisUtil;

public class UserServiceImp implements UserService {
	// 后台:展示所有用户
	@Override
	public List<User> showAllUser() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
		List<User> users = userDAO.queryAllUser();
		MyBatisUtil.close(sqlSession);
		return users;
	}

	// 后台:通过用户id查询用户
	@Override
	public User queryById(User user) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
		User user1 = userDAO.queryById(user);
		MyBatisUtil.close(sqlSession);
		return user1;
	}

	// 后台:修改用户状态
	@Override
	public void updateUser(User user) {

		UserService userService = new UserServiceImp();
		// 通过id查询用户信息
		User u1 = userService.queryById(user);
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
			// 判断用户的状态
			if (u1.getStatus() == 1) {
				u1.setStatus(0);
				userDAO.updateUser(u1);
				MyBatisUtil.commit(sqlSession);
			} else {
				u1.setStatus(1);
				userDAO.updateUser(u1);
				MyBatisUtil.commit(sqlSession);
			}

		} catch (Exception e) {
			e.printStackTrace();
			MyBatisUtil.rollback(sqlSession);
		}
	}

	// 前台：注册用户
	@Override
	public String registUser(User user, String imgCode) {

		SqlSession sqlSession = null;
		String message = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
			// 获取session对象
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			// 获取验证码
			String verifyCode = (String) session.getAttribute("verifyCode");
			// 判断验证码是否相同
			if (verifyCode.equals(imgCode)) {
				// 通过邮箱查询用户信息
				User u1 = userDAO.queryUser(user);
				// 判断用户是否存在
				if (u1 == null) {
					// 获取uuid
					String uuid = UUID.randomUUID().toString();
					// 设置用户id为uuid
					user.setId(uuid);
					// 设置用户状态
					user.setStatus(1);
					// 将当前系统时间设置为用户注册时间
					user.setRegist_time(new Date());
					// 获取用户输入的密码
					String password = user.getPassword();
					// 获取盐
					String salt = Md5Utils.getSalt(10);
					user.setSalt(salt);
					// 进行加密
					String pass = Md5Utils.getMd5Code(password + salt);
					// 将加密后的密码重新赋值
					user.setPassword(pass);
					// 调用添加方法
					userDAO.insertUser(user);
					message = "注册成功";
					MyBatisUtil.commit(sqlSession);

				} else {
					message = "该用户已存在,请您换个邮箱";
				}
			} else {
				message = "验证码错误";
			}
			return message;
		} catch (Exception e) {
			e.printStackTrace();
			MyBatisUtil.rollback(sqlSession);
			return message;
		}

	}

	// 前台:用户登录
	@Override
	public String loginUser(User user) {
		String message = null;

		// 获取session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		// 获取sqlSqssion对象
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		// 通过sqlSession对象获取DAO实现类对象
		UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
		// 通过邮箱查询用户信息
		User login = userDAO.queryUser(user);
		System.out.println("通过邮箱查询的用户" + login);
		// 关闭资源
		MyBatisUtil.close(sqlSession);

		// 判断用户是否为空
		if (login != null) {
			// 获取用户输入的密码
			String pass = user.getPassword();
			// 获取查询到用户的盐
			String salt = login.getSalt();
			System.out.println("获取用户的盐" + salt);
			// 对用户输入的密码进行加密
			String password = Md5Utils.getMd5Code(pass + salt);
			System.out.println("对用户输入的密码进行加密" + password);
			// 判断用户密码是否正确
			if (login.getPassword().equals(password)) {
				// 判断用户是否验证邮箱
				if (login.getCdkey() != null) {
					// 判断用户状态
					if (login.getStatus() == 1) {
						// 将用户对象存入session中
						session.setAttribute("login", login);
						String flag = (String) session.getAttribute("flag");
						// 判断登录标记是否为空
						if (flag != null) {
							// 登陆标记不为空，跳转到地址页面
							message = "跳转到地址页面";
						} else {
							// 登录标记为空，跳转到首页
							message = "登陆成功";
						}
					} else {
						message = "该用户已经被冻结,详情请联系客服";
					}
				} else {
					message = "邮箱未验证";
				}
			} else {
				message = "密码错误";
			}
		} else {
			message = "邮箱输入错误或用户不存在";
		}

		return message;
	}

	// 前台:通过邮箱获取用户信息
	@Override
	public User queryByEmail(String email) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
		User user = new User();
		user.setEmail(email);
		User queryUser = userDAO.queryUser(user);
		MyBatisUtil.close(sqlSession);
		return queryUser;
	}

	// 修改用户信息
	public void update(User user) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
		userDAO.updateUser(user);
		MyBatisUtil.commit(sqlSession);
	}
}
