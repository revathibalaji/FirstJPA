package com.vam.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StuCourseKey implements Serializable {

	@Column(name = "stu_id", length = 10)
	private String stuId;

	@Column(name = "course_id", length = 10)
	private String courseId;

	public StuCourseKey() {

	}


	public StuCourseKey(String stuId, String courseId) {
		super();
		this.stuId = stuId;
		this.courseId = courseId;
	}



	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

}
