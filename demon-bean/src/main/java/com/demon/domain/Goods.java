package com.demon.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * 商品实体(自媒体)
 * 
 * @author wangjunbiao
 */
@Entity
@Table(name = "goods")
public class Goods implements Serializable {
	private static final long serialVersionUID = 1880825564619805663L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private Long mediaId;

	@Column
	private String nickname;

	@Column
	private String account;

	@Column
	private String headImgUrl;

	@Column
	private String summary;

	@Column
	private String isv;

	@Column
	private Integer industryId;

	@Column
	private Integer fansNum;

	@Column
	private float price;

	@Column
	private String wbUrl;

	@Lob
	@Column
	private String detail;

	@Column
	private String wxSimpleImagetext;

	@Column
	private String wxMoreImagetextOne;

	@Column
	private String wxSimpleImagetextTwo;

	@Column
	private String wxSimpleImagetextN;

	@Column
	private Integer showInIndex;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMediaId() {
		return mediaId;
	}

	public void setMediaId(Long mediaId) {
		this.mediaId = mediaId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getHeadImgUrl() {
		return headImgUrl;
	}

	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getIsv() {
		return isv;
	}

	public void setIsv(String isv) {
		this.isv = isv;
	}

	public Integer getIndustryId() {
		return industryId;
	}

	public void setIndustryId(Integer industryId) {
		this.industryId = industryId;
	}

	public Integer getFansNum() {
		return fansNum;
	}

	public void setFansNum(Integer fansNum) {
		this.fansNum = fansNum;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getWbUrl() {
		return wbUrl;
	}

	public void setWbUrl(String wbUrl) {
		this.wbUrl = wbUrl;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getWxSimpleImagetext() {
		return wxSimpleImagetext;
	}

	public void setWxSimpleImagetext(String wxSimpleImagetext) {
		this.wxSimpleImagetext = wxSimpleImagetext;
	}

	public String getWxMoreImagetextOne() {
		return wxMoreImagetextOne;
	}

	public void setWxMoreImagetextOne(String wxMoreImagetextOne) {
		this.wxMoreImagetextOne = wxMoreImagetextOne;
	}

	public String getWxSimpleImagetextTwo() {
		return wxSimpleImagetextTwo;
	}

	public void setWxSimpleImagetextTwo(String wxSimpleImagetextTwo) {
		this.wxSimpleImagetextTwo = wxSimpleImagetextTwo;
	}

	public String getWxSimpleImagetextN() {
		return wxSimpleImagetextN;
	}

	public void setWxSimpleImagetextN(String wxSimpleImagetextN) {
		this.wxSimpleImagetextN = wxSimpleImagetextN;
	}

	public Integer getShowInIndex() {
		return showInIndex;
	}

	public void setShowInIndex(Integer showInIndex) {
		this.showInIndex = showInIndex;
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", mediaId=" + mediaId + ", nickname="
				+ nickname + ", account=" + account + ", headImgUrl="
				+ headImgUrl + ", summary=" + summary + ", isv=" + isv
				+ ", industryId=" + industryId + ", fansNum=" + fansNum
				+ ", price=" + price + ", wbUrl=" + wbUrl + ", detail="
				+ detail + ", wxSimpleImagetext=" + wxSimpleImagetext
				+ ", wxMoreImagetextOne=" + wxMoreImagetextOne
				+ ", wxSimpleImagetextTwo=" + wxSimpleImagetextTwo
				+ ", wxSimpleImagetextN=" + wxSimpleImagetextN
				+ ", showInIndex=" + showInIndex + "]";
	}

}
