package com.tes1.evaluate.domain;

import java.util.List;

public class ScoreSearchList {
	private Integer total;
	private List<ScoreSearch> rows;
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<ScoreSearch> getRows() {
		return rows;
	}
	public void setRows(List<ScoreSearch> rows) {
		this.rows = rows;
	}
}
