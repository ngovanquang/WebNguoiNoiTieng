package com.project1.model;

public class NewModel extends AbstractModel<NewModel> {

	private String title;
	private String thumbnail;
	private String shortdescription;
	private String content;
	private Long celebrityid;
	private Long categoryid;
	private String categorycode;
	private String celebritycode;
	private String headimg;
	private long view;

	public long getView() {
		return view;
	}

	public void setView(long view) {
		this.view = view;
	}

	public String getHeadimg() {
		return headimg;
	}

	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}

	public String getCelebritycode() {
		return celebritycode;
	}

	public void setCelebritycode(String celebritycode) {
		this.celebritycode = celebritycode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getShortdescription() {
		return shortdescription;
	}

	public void setShortdescription(String shortdescription) {
		this.shortdescription = shortdescription;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getCelebrityid() {
		return celebrityid;
	}

	public void setCelebrityid(Long celebrityid) {
		this.celebrityid = celebrityid;
	}

	public Long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategorycode() {
		return categorycode;
	}

	public void setCategorycode(String categorycode) {
		this.categorycode = categorycode;
	}
}