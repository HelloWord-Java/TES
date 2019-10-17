package com.tes1.evaluate.domain;

import java.util.List;

public class CourseList {
	private Integer total;
	private List<Course> rows;
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<Course> getRows() {
		return rows;
	}
	public void setRows(List<Course> rows) {
		this.rows = rows;
	}

}
