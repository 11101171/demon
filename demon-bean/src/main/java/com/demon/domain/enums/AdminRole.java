package com.demon.domain.enums;

/**   
* <p></p>
* @author ningzong.zeng
*/
public enum AdminRole {
	SUPER_ADMIN("超级管理员"),
	ADMIN("普通管理员");
	
	String info;
	AdminRole(String info) {
		this.info = info;
	}
	public String getInfo() {
		return info;
	}
}
