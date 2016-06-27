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
 * 订单实体
 * 
 * @author wangjunbiao
 */
@Entity
@Table(name = "order")
public class Order implements Serializable {
	private static final long serialVersionUID = 3158644560662808255L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private Long userId;

	@Column
	private String mediaName;

	@Column
	private String sendMethod;

	@Column
	private String adType;

	@Column
	private String activityName;

	@Column
	private String title;

	@Column
	private String author;

	@Column
	private Date activityTime;

	@Column
	private String forwardLink;

	@Column
	private String forwardTitle;

	@Column
	private String directImgUrl;

	@Column
	private String coverImgUrl;

	@Column
	private Long goodsId;

	@Column
	private float price;

	@Column
	private Integer payStatus;

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

	public String getMediaName() {
		return mediaName;
	}

	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}

	public String getSendMethod() {
		return sendMethod;
	}

	public void setSendMethod(String sendMethod) {
		this.sendMethod = sendMethod;
	}

	public String getAdType() {
		return adType;
	}

	public void setAdType(String adType) {
		this.adType = adType;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getActivityTime() {
		return activityTime;
	}

	public void setActivityTime(Date activityTime) {
		this.activityTime = activityTime;
	}

	public String getForwardLink() {
		return forwardLink;
	}

	public void setForwardLink(String forwardLink) {
		this.forwardLink = forwardLink;
	}

	public String getForwardTitle() {
		return forwardTitle;
	}

	public void setForwardTitle(String forwardTitle) {
		this.forwardTitle = forwardTitle;
	}

	public String getDirectImgUrl() {
		return directImgUrl;
	}

	public void setDirectImgUrl(String directImgUrl) {
		this.directImgUrl = directImgUrl;
	}

	public String getCoverImgUrl() {
		return coverImgUrl;
	}

	public void setCoverImgUrl(String coverImgUrl) {
		this.coverImgUrl = coverImgUrl;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
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
		return "Order [id=" + id + ", userId=" + userId + ", mediaName=" + mediaName + ", sendMethod=" + sendMethod
				+ ", adType=" + adType + ", activityName=" + activityName + ", title=" + title + ", author=" + author
				+ ", activityTime=" + activityTime + ", forwardLink=" + forwardLink + ", forwardTitle=" + forwardTitle
				+ ", directImgUrl=" + directImgUrl + ", coverImgUrl=" + coverImgUrl + ", goodsId=" + goodsId
				+ ", price=" + price + ", payStatus=" + payStatus + ", createTime=" + createTime + ", modifyTime="
				+ modifyTime + "]";
	}

}
