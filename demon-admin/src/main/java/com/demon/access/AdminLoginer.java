package com.demon.access;

/**
 * 
* <p></p>
* @author ningzhong.zeng
*
 */
public class AdminLoginer {
	public static final String ADMIN_IN_REQUEST = "ADMIN";
	
	private Long id;
	private String loginUsername;
	private String role;
	
	public AdminLoginer(Long id, String loginUsername, String role) {
		super();
		this.id = id;
		this.loginUsername = loginUsername;
		this.role = role;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "AdminLoginValue [id=" + id + ", loginUsername=" + loginUsername + ", role=" + role + "]";
	}
}
