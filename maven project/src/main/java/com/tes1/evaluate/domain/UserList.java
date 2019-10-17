package com.tes1.evaluate.domain;

import java.util.List;

public class UserList {
	private Integer total;
	private List<User> rows;
	
	public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
    public List<User> getRows() {
        return rows;
    }

    public void setRows(List<User> rows) {
        this.rows = rows;
    }
}
