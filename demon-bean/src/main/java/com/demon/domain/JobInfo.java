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
import javax.validation.constraints.Size;

/**
 * 招聘岗位实体
 * 
 * @author wangjunbiao
 */
@Entity
@Table(name = "job_info")
public class JobInfo implements Serializable {
	private static final long serialVersionUID = -9159292738054153260L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private Integer typeId;

	@Column
	private String jobName;

	@Column
	private String experience;

	@Column
	private String degree;

	@Column
	private String address;

	@Lob
	@Column
	private String detail;

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

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
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
		return "JobInfo [id=" + id + ", typeId=" + typeId + ", jobName="
				+ jobName + ", experience=" + experience + ", degree=" + degree
				+ ", address=" + address + ", detail=" + detail
				+ ", createTime=" + createTime + ", modifyTime=" + modifyTime
				+ "]";
	}

}
