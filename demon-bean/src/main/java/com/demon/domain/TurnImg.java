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
 * 轮播图实体
 * 
 * @author wangjunbiao
 */
@Entity
@Table(name = "turn_img")
public class TurnImg implements Serializable {
	private static final long serialVersionUID = 7083578729389376232L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String imgUrl;// 图片地址

	@Column
	private String imgText;

	@Column
	private String imgLink;// 图片链接

	@Column
	private Integer showStatus;

	@Column
	private Integer showOrder;

	@Column
	private Integer type;// 1：首页轮播图 2：公司荣誉

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getImgLink() {
		return imgLink;
	}

	public void setImgLink(String imgLink) {
		this.imgLink = imgLink;
	}

	public String getImgText() {
		return imgText;
	}

	public void setImgText(String imgText) {
		this.imgText = imgText;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "TurnImg [id=" + id + ", imgUrl=" + imgUrl + ", imgText="
				+ imgText + ", imgLink=" + imgLink + ", showStatus="
				+ showStatus + ", showOrder=" + showOrder + ", type=" + type
				+ "]";
	}

}
