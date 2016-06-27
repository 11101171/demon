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
 * 文章实体—行业动态、推广技巧
 * 
 * @author wangjunbiao
 */
@Entity
@Table(name = "article")
public class Article implements Serializable {
	private static final long serialVersionUID = 1880825564619805663L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String title;

	@Lob
	@Column
	private String detail;

	@Column
	private Integer type;// 1:行业动态 2：推广技巧

	@Column
	private Integer showOrder;//显示顺序

	@Column
	private Integer showInIndex;//是否在首页显示

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getShowOrder() {
		return showOrder;
	}

	public void setShowOrder(Integer showOrder) {
		this.showOrder = showOrder;
	}

	public Integer getShowInIndex() {
		return showInIndex;
	}

	public void setShowInIndex(Integer showInIndex) {
		this.showInIndex = showInIndex;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", detail=" + detail
				+ ", type=" + type + ", showOrder=" + showOrder
				+ ", showInIndex=" + showInIndex + "]";
	}

}
