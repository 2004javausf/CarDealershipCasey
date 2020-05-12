package com.cardealer.beans;

public class UserCreds {
	private Integer id;
	private String username;
	private String password;
	private Integer customer;
	
	public UserCreds(Integer id, String username, String password, Integer customer) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.setCustomer(customer);
	}

	public UserCreds() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getCustomer() {
		return customer;
	}

	public void setCustomer(Integer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "UserCreds [id=" + id + ", username=" + username + ", password=" + password + ", customer=" + customer
				+ "]";
	}


	
}
