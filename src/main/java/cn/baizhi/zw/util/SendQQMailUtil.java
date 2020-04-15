package cn.baizhi.zw.util;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.RandomStringUtils;

public class SendQQMailUtil {
	// 测试
	public static void main(String[] args) {

		String code = randow(6);
		check("2578858073@qq.com", code);

	}

	public static String randow() {
		return RandomStringUtils.randomAlphabetic(6).toUpperCase();
	}

	public static void getMail(String email) {
		String code = randow();
		check(email, code);
	}

	// 获取随机数
	public static String randow(int n) {
		char[] code = "0123456789".toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(code[new Random().nextInt(code.length)]);
		}
		return sb.toString();
	}

	public static void check(String accountmail, String vcode) {
		Properties properties = new Properties();
		properties.put("mail.transport.protocol", "smtp");// 连接协议
		properties.put("mail.smtp.host", "smtp.qq.com");// 主机名
		properties.put("mail.smtp.port", 465);// 端口号
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.ssl.enable", "true");// 设置是否使用ssl安全连接 ---一般都使用
		properties.put("mail.debug", "true");// 设置是否显示debug信息 true 会在控制台显示相关信息
		// 得到会话对象
		Session session = Session.getInstance(properties);
		// 获取邮件对象
		Message message = new MimeMessage(session);
		try {
			// 设置发件人邮箱地址
			message.setFrom(new InternetAddress("2578858073@qq.com"));

			// 设置收件人邮箱地址
			message.setRecipients(Message.RecipientType.TO,
					new InternetAddress[] { new InternetAddress(accountmail) });
			// message.setRecipient(Message.RecipientType.TO, new
			// InternetAddress("xxx@qq.com"));//一个收件人
			// 设置邮件标题
			message.setSubject("来自小当当的验证消息");
			// 设置邮件内容
			message.setContent(
					"<!DOCTYPE html>"
							+ "<html>"
							+ "<head>"
							+ "<meta charset='utf-8'>"
							+ "<title></title>"
							+ "</head>"
							+ "<body>"
							+ "<table>"
							+ "<tr><h1 style='color: blueviolet;'>安全代码</h1></tr>"
							+ "<br />"
							+ "<tr>您正在尝试注册小当当网，请使用下面的安全代码</tr>"
							+ "<br />"
							+ "<tr ><h1 style='border: 1px;color: darkblue;'>"
							+ vcode
							+ "</h2></tr>"
							+ "<br />"
							+ "<tr ><span style='color: red;'>如果这不是您正在尝试注册请忽略此邮件</span></tr>"
							+ "<br />" + "<tr> <h3>小当当团队<h3></tr>" + "</table>"
							+ "</body>" + "</html>", "text/html;charset=UTF-8");

			// 得到邮差对象
			Transport transport = session.getTransport();
			// 连接自己的邮箱账户
			transport.connect("2578858073@qq.com", "gpiclhokqtvkecah");// 密码为QQ邮箱开通的stmp服务后得到的客户端授权码
			// 发送邮件
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
