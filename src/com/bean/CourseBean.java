package com.bean;

public class CourseBean {
	
	private int sr_no;
	private String course_name;
	private String description;
	
	public CourseBean(int sr_no, String course_name, String description) {
		super();
		this.sr_no = sr_no;
		this.course_name = course_name;
		this.description = description;
	}

	public CourseBean() {
		super();
	}

	public int getSr_no() {
		return sr_no;
	}

	public void setSr_no(int sr_no) {
		this.sr_no = sr_no;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
