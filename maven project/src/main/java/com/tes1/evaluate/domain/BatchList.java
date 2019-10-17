package com.tes1.evaluate.domain;

import java.util.List;

public class BatchList {
	private Integer total;
	private List<Batch> rows;
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<Batch> getRows() {
		return rows;
	}
	public void setRows(List<Batch> rows) {
		this.rows = rows;
	}
}
