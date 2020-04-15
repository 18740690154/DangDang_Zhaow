package cn.baizhi.zw.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {
	private String id;
	private String order_number; // 订单编号
	private Date order_times; // 订单创建时间
	private String order_state; // 订单状态
	private String addr_user; // 收货人
	private String addr_name; // 收货地址
	private Double total_price; // 总价
	private String addr_id; // 地址id
	private String user_id; // 用户id

	private User user; // 用户
	private List<Address> addresses; // 地址
	private List<Item> items;

	public Order() {
		super();
	}

	public Order(String id, String order_number, Date order_times,
			String order_state, String addr_user, String addr_name,
			Double total_price, String addr_id, String user_id, User user,
			List<Address> addresses, List<Item> items) {
		super();
		this.id = id;
		this.order_number = order_number;
		this.order_times = order_times;
		this.order_state = order_state;
		this.addr_user = addr_user;
		this.addr_name = addr_name;
		this.total_price = total_price;
		this.addr_id = addr_id;
		this.user_id = user_id;
		this.user = user;
		this.addresses = addresses;
		this.items = items;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addr_id == null) ? 0 : addr_id.hashCode());
		result = prime * result
				+ ((addr_name == null) ? 0 : addr_name.hashCode());
		result = prime * result
				+ ((addr_user == null) ? 0 : addr_user.hashCode());
		result = prime * result
				+ ((addresses == null) ? 0 : addresses.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result
				+ ((order_number == null) ? 0 : order_number.hashCode());
		result = prime * result
				+ ((order_state == null) ? 0 : order_state.hashCode());
		result = prime * result
				+ ((order_times == null) ? 0 : order_times.hashCode());
		result = prime * result
				+ ((total_price == null) ? 0 : total_price.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (addr_id == null) {
			if (other.addr_id != null)
				return false;
		} else if (!addr_id.equals(other.addr_id))
			return false;
		if (addr_name == null) {
			if (other.addr_name != null)
				return false;
		} else if (!addr_name.equals(other.addr_name))
			return false;
		if (addr_user == null) {
			if (other.addr_user != null)
				return false;
		} else if (!addr_user.equals(other.addr_user))
			return false;
		if (addresses == null) {
			if (other.addresses != null)
				return false;
		} else if (!addresses.equals(other.addresses))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (order_number == null) {
			if (other.order_number != null)
				return false;
		} else if (!order_number.equals(other.order_number))
			return false;
		if (order_state == null) {
			if (other.order_state != null)
				return false;
		} else if (!order_state.equals(other.order_state))
			return false;
		if (order_times == null) {
			if (other.order_times != null)
				return false;
		} else if (!order_times.equals(other.order_times))
			return false;
		if (total_price == null) {
			if (other.total_price != null)
				return false;
		} else if (!total_price.equals(other.total_price))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", order_number=" + order_number
				+ ", order_times=" + order_times + ", order_state="
				+ order_state + ", addr_user=" + addr_user + ", addr_name="
				+ addr_name + ", total_price=" + total_price + ", addr_id="
				+ addr_id + ", user_id=" + user_id + ", user=" + user
				+ ", addresses=" + addresses + ", items=" + items + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrder_number() {
		return order_number;
	}

	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}

	public Date getOrder_times() {
		return order_times;
	}

	public void setOrder_times(Date order_times) {
		this.order_times = order_times;
	}

	public String getOrder_state() {
		return order_state;
	}

	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}

	public String getAddr_user() {
		return addr_user;
	}

	public void setAddr_user(String addr_user) {
		this.addr_user = addr_user;
	}

	public String getAddr_name() {
		return addr_name;
	}

	public void setAddr_name(String addr_name) {
		this.addr_name = addr_name;
	}

	public Double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(Double total_price) {
		this.total_price = total_price;
	}

	public String getAddr_id() {
		return addr_id;
	}

	public void setAddr_id(String addr_id) {
		this.addr_id = addr_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}
