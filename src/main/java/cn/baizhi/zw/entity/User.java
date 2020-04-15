package cn.baizhi.zw.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	private String id; // id
	private String nick_name; // 昵称
	private String email; // 邮箱
	private String password; // 密码
	private Integer status; // 状态
	private Date regist_time; // 注册时间
	private String salt; // 盐
	private String cdkey;

	public User() {
		super();
	}

	public User(String id, String nick_name, String email, String password,
			Integer status, Date regist_time, String salt, String cdkey) {
		super();
		this.id = id;
		this.nick_name = nick_name;
		this.email = email;
		this.password = password;
		this.status = status;
		this.regist_time = regist_time;
		this.salt = salt;
		this.cdkey = cdkey;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdkey == null) ? 0 : cdkey.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((nick_name == null) ? 0 : nick_name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((regist_time == null) ? 0 : regist_time.hashCode());
		result = prime * result + ((salt == null) ? 0 : salt.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		User other = (User) obj;
		if (cdkey == null) {
			if (other.cdkey != null)
				return false;
		} else if (!cdkey.equals(other.cdkey))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nick_name == null) {
			if (other.nick_name != null)
				return false;
		} else if (!nick_name.equals(other.nick_name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (regist_time == null) {
			if (other.regist_time != null)
				return false;
		} else if (!regist_time.equals(other.regist_time))
			return false;
		if (salt == null) {
			if (other.salt != null)
				return false;
		} else if (!salt.equals(other.salt))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nick_name=" + nick_name + ", email="
				+ email + ", password=" + password + ", status=" + status
				+ ", regist_time=" + regist_time + ", salt=" + salt
				+ ", cdkey=" + cdkey + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getRegist_time() {
		return regist_time;
	}

	public void setRegist_time(Date regist_time) {
		this.regist_time = regist_time;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getCdkey() {
		return cdkey;
	}

	public void setCdkey(String cdkey) {
		this.cdkey = cdkey;
	}

}
