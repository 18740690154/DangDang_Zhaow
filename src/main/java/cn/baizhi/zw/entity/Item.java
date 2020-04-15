package cn.baizhi.zw.entity;

import java.io.Serializable;

public class Item implements Serializable {
	private String id; // 订单项id
	private String book_name; // 图书名
	private String book_src; // 图书封面路径
	private Double price; // 图书价格
	private Double dd_price;
	private Integer count; // 数量
	private Double amount; // 小计
	private String book_id; // 图书id
	private String order_id; // 订单id

	private Book book;
	private Order order;

	public Item() {
		super();
	}

	public Item(String id, String book_name, String book_src, Double price,
			Double dd_price, Integer count, Double amount, String book_id,
			String order_id) {
		super();
		this.id = id;
		this.book_name = book_name;
		this.book_src = book_src;
		this.price = price;
		this.dd_price = dd_price;
		this.count = count;
		this.amount = amount;
		this.book_id = book_id;
		this.order_id = order_id;
	}

	public Item(String id, String book_name, String book_src, Double price,
			Double dd_price, Integer count, Double amount, String book_id,
			String order_id, Book book, Order order) {
		super();
		this.id = id;
		this.book_name = book_name;
		this.book_src = book_src;
		this.price = price;
		this.dd_price = dd_price;
		this.count = count;
		this.amount = amount;
		this.book_id = book_id;
		this.order_id = order_id;
		this.book = book;
		this.order = order;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((book_id == null) ? 0 : book_id.hashCode());
		result = prime * result
				+ ((book_name == null) ? 0 : book_name.hashCode());
		result = prime * result
				+ ((book_src == null) ? 0 : book_src.hashCode());
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result
				+ ((dd_price == null) ? 0 : dd_price.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result
				+ ((order_id == null) ? 0 : order_id.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
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
		Item other = (Item) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (book_id == null) {
			if (other.book_id != null)
				return false;
		} else if (!book_id.equals(other.book_id))
			return false;
		if (book_name == null) {
			if (other.book_name != null)
				return false;
		} else if (!book_name.equals(other.book_name))
			return false;
		if (book_src == null) {
			if (other.book_src != null)
				return false;
		} else if (!book_src.equals(other.book_src))
			return false;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (dd_price == null) {
			if (other.dd_price != null)
				return false;
		} else if (!dd_price.equals(other.dd_price))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (order_id == null) {
			if (other.order_id != null)
				return false;
		} else if (!order_id.equals(other.order_id))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", book_name=" + book_name + ", book_src="
				+ book_src + ", price=" + price + ", dd_price=" + dd_price
				+ ", count=" + count + ", amount=" + amount + ", book_id="
				+ book_id + ", order_id=" + order_id + ", book=" + book
				+ ", order=" + order + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getBook_src() {
		return book_src;
	}

	public void setBook_src(String book_src) {
		this.book_src = book_src;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDd_price() {
		return dd_price;
	}

	public void setDd_price(Double dd_price) {
		this.dd_price = dd_price;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
