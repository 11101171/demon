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
 * 行业分类实体
 * 
 * @author wangjunbiao
 */
@Entity
@Table(name = "industry_type")
public class IndustryType implements Serializable {
	private static final long serialVersionUID = -7697738526266348274L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long industryId;

	@Column
	private String industryName;

	@Column
	private Integer showStatus;

	@Column
	private Integer showOrder;

	@Column
	private Date createTime;

	@Column
	private Date modifyTime;

	public Long getIndustryId() {
		return industryId;
	}

	public void setIndustryId(Long industryId) {
		this.industryId = industryId;
	}

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public Integer getShowStatus() {
		return showStatus;
	}

	public void setShowStatus(Integer showStatus) {
		this.showStatus = showStatus;
	}

	public Integer getShowOrder() {
		return showOrder;
	}

	public void setShowOrder(Integer showOrder) {
		this.showOrder = showOrder;
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
		return "IndustryType [industryId=" + industryId + ", industryName=" + industryName + ", showStatus="
				+ showStatus + ", showOrder=" + showOrder + ", createTime=" + createTime + ", modifyTime=" + modifyTime
				+ "]";
	}

}
