package com.vam.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="stu_course")
public class StuCourseEntity {

	@EmbeddedId
	private StuCourseKey key;
	
	@Column(name="marks")
	private int marks;
	
	public StuCourseKey getKey() {
		return key;
	}
	public void setKey(StuCourseKey key) {
		this.key = key;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	
}
