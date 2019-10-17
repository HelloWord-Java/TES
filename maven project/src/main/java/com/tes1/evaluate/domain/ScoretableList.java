package com.tes1.evaluate.domain;

import java.util.List;

public class ScoretableList {
    private Integer total;
    private List<Scoretable> rows;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Scoretable> getRows() {
        return rows;
    }

    public void setRows(List<Scoretable> rows) {
        this.rows = rows;
    }
}
