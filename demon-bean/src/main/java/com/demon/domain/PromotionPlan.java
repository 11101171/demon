package com.demon.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * 推广计划实体
 * 
 * @author wangjunbiao
 */
@Entity
@Table(name = "promotion_plan")
public class PromotionPlan implements Serializable {
	private static final long serialVersionUID = 8173882915892640619L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private Long userId;

	@Lob
	@Column
	private String demand;

	@Column
	private Date date;

	@Column
	private float price;

	@Column
	private Integer status;

	@Column
	private Date createTime;

	@Column
	private Date modifyTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getDemand() {
		return demand;
	}

	public void setDemand(String demand) {
		this.demand = demand;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	@Override
	public String toString() {
		return "PromotionPlan [id=" + id + ", userId=" + userId + ", demand="
				+ demand + ", date=" + date + ", price=" + price + ", status="
				+ status + ", createTime=" + createTime + ", modifyTime="
				+ modifyTime + "]";
	}

}
