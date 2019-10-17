package com.tes1.evaluate.domain;

import java.util.List;

public class DepartmentList {
	private Integer total;
	private List<Department> rows;
	
	public List<Department> getRows() {
		return rows;
	}

	public void setRows(List<Department> rows) {
		this.rows = rows;
	}

	public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
 
}
