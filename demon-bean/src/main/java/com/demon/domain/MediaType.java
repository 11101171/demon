package com.demon.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * 媒体分类实体
 * 
 * @author wangjunbiao
 */
@Entity
@Table(name = "media_type")
public class MediaType implements Serializable {
	private static final long serialVersionUID = -9159292738054153260L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long mediaId;

	@Column
	@Size(min = 1, max = 50, message = "长度不能小于1大于50")
	private String mediaName;

	@Column
	private String iconUrl;

	@Column
	private Integer showIndex;

	@Column
	private Integer showStatus;

	@Column
	private Integer showOrder;

	@Column
	private Date createTime;

	@Column
	private Date modifyTime;

	public Long getMediaId() {
		return mediaId;
	}

	public void setMediaId(Long mediaId) {
		this.mediaId = mediaId;
	}

	public String getMediaName() {
		return mediaName;
	}

	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public Integer getShowIndex() {
		return showIndex;
	}

	public void setShowIndex(Integer showIndex) {
		this.showIndex = showIndex;
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
		return "MediaType [mediaId=" + mediaId + ", mediaName=" + mediaName
				+ ", iconUrl=" + iconUrl + ", showStatus=" + showStatus
				+ ", showOrder=" + showOrder + ", createTime=" + createTime
				+ ", modifyTime=" + modifyTime + "]";
	}

}
