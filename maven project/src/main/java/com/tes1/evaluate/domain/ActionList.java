package com.tes1.evaluate.domain;

import java.util.List;

public class ActionList {
	private Integer total;
	private List<Action> rows;
	
	public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
    public List<Action> getRows() {
        return rows;
    }

    public void setRows(List<Action> rows) {
        this.rows = rows;
    }
}
