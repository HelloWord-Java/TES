package com.tes1.evaluate.domain;

public class ScoreSearch {
	private Integer Id;
	private Integer courseId;
    private Integer teacherId;
	private String courseName;
	private Float avgscore;
	public Float getAvgscore() {
		return avgscore;
	}
	public void setAvgscore(Float avgscore) {
		this.avgscore = avgscore;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
}
