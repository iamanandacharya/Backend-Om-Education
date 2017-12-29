package com.bean;

public class CategoryBean {
	
	private int sr_no;
	private String category_name;
	private String description;
	
	
	
	public CategoryBean() {
		super();
	}

	public CategoryBean(int sr_no, String category_name, String description) {
		super();
		this.sr_no = sr_no;
		this.category_name = category_name;
		this.description = description;
	}

	public int getSr_no() {
		return sr_no;
	}

	public void setSr_no(int sr_no) {
		this.sr_no = sr_no;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
