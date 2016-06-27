package com.demon.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户实体
 * 
 * @author wangjunbiao
 */
@Entity
@Table(name = "user")
public class User implements Serializable {
	private static final long serialVersionUID = 7083578729389376232L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String username;

	@Column
	private String password;

	@Column
	private String contact;

	@Column
	private String phone;

	@Column
	private String mailbox;

	@Column
	private String fixedPhone;

	@Column
	private String qq;

	@Column
	private String comShort;

	@Column
	private String comFull;

	@Column
	private String comAddress;

	@Column
	private String comHomepage;

	@Column
	private String comMicroblog;

	@Column
	private String comDesc;

	@Column
	private Date createTime;

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

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMailbox() {
		return mailbox;
	}

	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}

	public String getFixedPhone() {
		return fixedPhone;
	}

	public void setFixedPhone(String fixedPhone) {
		this.fixedPhone = fixedPhone;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getComShort() {
		return comShort;
	}

	public void setComShort(String comShort) {
		this.comShort = comShort;
	}

	public String getComFull() {
		return comFull;
	}

	public void setComFull(String comFull) {
		this.comFull = comFull;
	}

	public String getComAddress() {
		return comAddress;
	}

	public void setComAddress(String comAddress) {
		this.comAddress = comAddress;
	}

	public String getComHomepage() {
		return comHomepage;
	}

	public void setComHomepage(String comHomepage) {
		this.comHomepage = comHomepage;
	}

	public String getComMicroblog() {
		return comMicroblog;
	}

	public void setComMicroblog(String comMicroblog) {
		this.comMicroblog = comMicroblog;
	}

	public String getComDesc() {
		return comDesc;
	}

	public void setComDesc(String comDesc) {
		this.comDesc = comDesc;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", contact=" + contact
				+ ", phone=" + phone + ", mailbox=" + mailbox + ", fixedPhone=" + fixedPhone + ", qq=" + qq
				+ ", comShort=" + comShort + ", comFull=" + comFull + ", comAddress=" + comAddress + ", comHomepage="
				+ comHomepage + ", comMicroblog=" + comMicroblog + ", comDesc=" + comDesc + ", createTime=" + createTime
				+ "]";
	}

}
