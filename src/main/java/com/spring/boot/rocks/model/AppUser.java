package com.spring.boot.rocks.model;

import java.io.Serializable;

import com.opencsv.bean.CsvBindByName;

public class AppUser implements Serializable {

	private static final long serialVersionUID = 1L;
	@CsvBindByName
	private Long id;
	@CsvBindByName
	private String username;
	@CsvBindByName
	private String password;
	@CsvBindByName
	private String useremail;
	@CsvBindByName
	private String userfirstname;
	@CsvBindByName
	private String userlastname;
	@CsvBindByName
	private String useraddress;

	public AppUser() {
	}

	public AppUser(Long id) {
		this.id = id;
	}

	public AppUser(Long id, String username, String password, String useremail, String userfirstname,
			String userlastname, String useraddress) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.useremail = useremail;
		this.userfirstname = userfirstname;
		this.userlastname = userlastname;
		this.useraddress = useraddress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getUserfirstname() {
		return userfirstname;
	}
	public void setUserfirstname(String userfirstname) {
		this.userfirstname = userfirstname;
	}

	public String getUserlastname() {
		return userlastname;
	}
	public void setUserlastname(String userlastname) {
		this.userlastname = userlastname;
	}

	public String getUseraddress() {
		return useraddress;
	}
	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof AppUser)) {
			return false;
		}
		AppUser other = (AppUser) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "AppUser [id=" + id + ", username=" + username + ", password=" + password + ", useremail=" + useremail + ", userfirstname=" + userfirstname + ", userlastname="
				+ userlastname + ", useraddress=" + useraddress + "]";
	}

	

}
