package com.tes1.evaluate.domain;

import java.util.List;

public class ScaleList {
	private Integer total;
	private List<Scale> rows;
	
	public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
    public List<Scale> getRows() {
        return rows;
    }

    public void setRows(List<Scale> rows) {
        this.rows = rows;
    }
}
