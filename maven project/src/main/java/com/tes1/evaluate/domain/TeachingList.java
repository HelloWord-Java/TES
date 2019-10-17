package com.tes1.evaluate.domain;

import java.util.List;

public class TeachingList {
	private Integer total;
	private List<TeachingInfo> rows;
	
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<TeachingInfo> getRows() {
		return rows;
	}
	public void setRows(List<TeachingInfo> rows) {
		this.rows = rows;
	}
}
