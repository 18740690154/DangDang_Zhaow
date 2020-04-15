package cn.baizhi.zw.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.baizhi.zw.entity.User;
import cn.baizhi.zw.service.UserService;
import cn.baizhi.zw.serviceimp.UserServiceImp;
import cn.baizhi.zw.util.SendQQMailUtil;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	// 后台:修改用户状态接受的数据
	// 前台:用户登录接受的数据
	// 前台:用户注册接受的数据
	private User user;

	// 前台:用户注册接受的数据
	private String message;
	private String imgCode;
	// 后台:展示所有用户接受的数据
	private List<User> users;

	// 前台:获取随机数(邮箱激活码)接受的数据
	private String cdkey;
	private String email;

	// 前台:检查用户输入的激活码所接受的数据
	private String code;

	// 前台:用户登录的方法
	public String login() {
		// 获取session对象
		UserService userService = new UserServiceImp();
		// 通过邮箱查询用户信息
		message = userService.loginUser(user);
		user = userService.queryByEmail(user.getEmail());
		System.out.println("查询出的用户" + user);
		if (message.equals("跳转到地址页面")) {
			return "loginforce";
		} else if (message.equals("登陆成功")) {
			return "loginSuccess";
		} else {
			if (message.equals("邮箱未验证")) {
				return "loginVerify";
			} else {
				return "loginError";
			}
		}

	}

	// 前台:用户注册的方法
	public String regist() {
		UserService userService = new UserServiceImp();
		message = userService.registUser(user, imgCode);
		System.out.println(message);
		if (message.equals("注册成功")) {
			return "registSuccess";
		} else {
			return "registError";
		}
	}

	// 前台:获取随机数(邮箱激活码)的方法
	public String random() {
		// 获取随机数
		cdkey = SendQQMailUtil.randow();
		// 获取用户的邮箱信息
		email = user.getEmail();
		// SendQQMailUtil.getMail(email);
		return "randomSuccess";
	}

	// 前台:检查用户输入的邮箱激活码的方法
	public String check() {
		// 通过用户id查询用户信息
		UserService userService = new UserServiceImp();
		User u1 = userService.queryById(user);
		if (cdkey.equals(code)) {

			u1.setCdkey(cdkey);
			userService.update(u1);

			return "checkSuccess";
		} else {
			return "checkError";
		}
	}

	// 前台:登录标记验证的方法
	public String loginFlag() {
		// 获取session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		// 取出登陆用户
		User user = (User) session.getAttribute("login");
		// 判断登录用户是否为空
		if (user != null) {
			// 不为空，直接跳转到通过用户id查询地址的acion;
			return "loginFlagSuccess";
		} else {
			// 为空，在session对象中存入一个标志位，跳转到登录页面
			session.setAttribute("flag", "flag");
			return "loginFlagError";
		}
	}

	// 后台:修改用户状态的方法
	public String update() {
		System.out.println("修改用户接受的数据:" + user);
		UserService userService = new UserServiceImp();
		userService.updateUser(user);
		return "updateSuccess";
	}

	// 后台:展示所有用户的方法
	public String showAll() {
		UserService userService = new UserServiceImp();
		users = userService.showAllUser();
		System.out.println(users);
		return "showAllSuccess";
	}

	// 前台:用户登出
	public String logout() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.removeAttribute("login");
		session.removeAttribute("flag");

		return "logoutSuccess";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getCdkey() {
		return cdkey;
	}

	public void setCdkey(String cdkey) {
		this.cdkey = cdkey;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getImgCode() {
		return imgCode;
	}

	public void setImgCode(String imgCode) {
		this.imgCode = imgCode;
	}

}
