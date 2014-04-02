package com.kglory.tms.bean.account;

public class AccountBean {
	
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String regdate;
	private boolean successYn;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isSuccessYn() {
		return successYn;
	}

	public void setSuccessYn(boolean successYn) {
		this.successYn = successYn;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "AccountBean [id=" + id + ", pwd=" + pwd + ", name=" + name
				+ ", email=" + email + ", regdate=" + regdate + ", successYn="
				+ successYn + "]";
	}

}
