package cn.baizhi.zw.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.baizhi.zw.entity.Address;
import cn.baizhi.zw.entity.User;
import cn.baizhi.zw.service.AddressService;
import cn.baizhi.zw.serviceimp.AddressServiceImp;

import com.opensymphony.xwork2.ActionSupport;

public class AddressAction extends ActionSupport {
	// 添加地址接受的数据
	// 通过地址id查询地址接受的数据
	private Address address;

	// 通过地址id查询地址接受的数据
	private String id;

	// 通过用户id查询地址接受的数据
	private User user;
	private String userId;
	private List<Address> addresses;

	// 添加地址的方法
	public String insertAddress() {

		AddressService addressService = new AddressServiceImp();
		addressService.insertAddress(address);
		return "insertAddressSuccess";
	}

	// 通过地址id查询地址的方法
	public String queryAddressByid() {
		AddressService addressService = new AddressServiceImp();
		// 通过地址id查询地址
		address = addressService.queryAddressByid(id);
		System.out.println("通过地址id查询的地址" + address);

		// 获取session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		// 获得登录标志
		User user = (User) session.getAttribute("login");
		System.out.println(user);
		userId = user.getId();

		addresses = addressService.queryAddressesByUserId(userId);
		return "queryAddressByidSuccess";
	}

	// 通过用户id查询地址的方法
	public String queryAddressesByUserId() {
		AddressService addressService = new AddressServiceImp();
		// 获取session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User) session.getAttribute("login");
		System.out.println(user);
		userId = user.getId();
		addresses = addressService.queryAddressesByUserId(userId);
		System.out.println("通过用户ID查询到的地址:" + addresses);
		return "queryAddressesByUserIdSuccess";
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
