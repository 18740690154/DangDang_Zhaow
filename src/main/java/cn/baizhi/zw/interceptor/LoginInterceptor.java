package cn.baizhi.zw.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.baizhi.zw.entity.Admin;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation ai) throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Admin admin = (Admin) session.getAttribute("adminLogin");
		if (admin != null) {
			ai.invoke();
			return null;
		} else {
			return "interceptor";
		}
	}
}
