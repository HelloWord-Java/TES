package com.tes1.evaluate.domain;

import java.util.List;

public class ClassinfoList {
	private Integer total;
	private List<Classinfo> rows;
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<Classinfo> getRows() {
		return rows;
	}
	public void setRows(List<Classinfo> rows) {
		this.rows = rows;
	}

}
