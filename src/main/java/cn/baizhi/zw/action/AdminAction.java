package cn.baizhi.zw.action;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.baizhi.zw.entity.Admin;
import cn.baizhi.zw.service.AdminService;
import cn.baizhi.zw.serviceimp.AdminServiceImp;
import cn.baizhi.zw.util.VerifyCodeUtil;

import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport {
	// 后台:管理员登录所接受的数据
	private Admin admin;
	private String code;
	private String message;

	// 后台:管理员登录的方法
	public String login() {
		// 获得业务层对象
		AdminService adminService = new AdminServiceImp();
		message = adminService.adminLogin(admin, code);
		System.out.println(message);
		// 判断登录信息
		if (message.equals("登录成功")) {
			// 登录成功
			return "loginSucccess";
		} else {
			// 登陆失败
			return "loginError";
		}
	}

	// 后台:管理员安全注销的方法
	public String logout() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		// 删除session对象中的登录标志位数据
		session.removeAttribute("adminLogin");
		return "logoutSuccess";
	}

	// 后台:获得验证码的方法
	public String getCode() {

		// 获得验证码并设置验证码的位数
		String verifyCode = VerifyCodeUtil.generateVerifyCode(4);

		// 将获得的验证码存入session
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("verifyCode", verifyCode);

		// 设置验证码的样式
		BufferedImage image = VerifyCodeUtil.getImage(255, 80, verifyCode);

		// 获得response对象
		HttpServletResponse response = ServletActionContext.getResponse();

		// 通过输出流输出验证码
		try {
			ServletOutputStream outputStream = response.getOutputStream();
			ImageIO.write(image, "png", outputStream);
			// 关闭资源并刷新资源
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
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

}
