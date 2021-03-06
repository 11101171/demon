package com.demon.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.demon.domain.enums.AdminRole;

/**   
* <p></p>
* @author ningzong.zeng
*/
@Entity
@Table(name="user_platform")
public class UserPlatform implements Serializable {
	private static final long serialVersionUID = 1344107240473958021L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	@Size(min=1, max=10, message="长度不能小于1大于10")
	private String loginUsername;
	
	@Column(nullable = false)
	@Size(min=1, max=200, message="长度不能小于1大于200")
	private String loginPassword;
	
	@Enumerated(EnumType.STRING)
	private AdminRole role;
	
	@Column(nullable = false)
	private Date gmtCreate;
	
	@Column(nullable = false)
	private Date gmtMotify;
	
	public UserPlatform() {}
	public UserPlatform(Long id) { this.id = id; }
	
	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtMotify() {
		return gmtMotify;
	}

	public void setGmtMotify(Date gmtMotify) {
		this.gmtMotify = gmtMotify;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginUsername() {
		return loginUsername;
	}

	public void setLoginUsername(String loginUsername) {
		this.loginUsername = loginUsername;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public AdminRole getRole() {
		return role;
	}

	public void setRole(AdminRole role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserPlatform [id=" + id + ", loginUsername=" + loginUsername + ", loginPassword=" + loginPassword
				+ ", role=" + role + ", gmtCreate=" + gmtCreate + ", gmtMotify=" + gmtMotify + "]";
	}

	
}
