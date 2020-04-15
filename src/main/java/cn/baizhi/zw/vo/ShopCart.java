package cn.baizhi.zw.vo;

import java.io.Serializable;

import cn.baizhi.zw.entity.Book;

public class ShopCart implements Serializable {
	private Book book;
	private Integer count;
	private Boolean status;
	private Double subtotal;

	public ShopCart() {
		super();
	}

	public ShopCart(Book book, Integer count, Boolean status, Double subtotal) {
		super();
		this.book = book;
		this.count = count;
		this.status = status;
		this.subtotal = subtotal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((subtotal == null) ? 0 : subtotal.hashCode());
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
		ShopCart other = (ShopCart) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (subtotal == null) {
			if (other.subtotal != null)
				return false;
		} else if (!subtotal.equals(other.subtotal))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ShopCart [book=" + book + ", count=" + count + ", status="
				+ status + ", subtotal=" + subtotal + "]";
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

}
