package com.tes1.evaluate.domain;

import java.util.List;

public class scaleAction {
    private Integer id;

    private Integer scaleId;

    private Integer actionId;

    private List<scaleAction> scaleactionsList;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScaleId() {
        return scaleId;
    }

    public void setScaleId(Integer scaleId) {
        this.scaleId = scaleId;
    }

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

	public List<scaleAction> getScaleactionsList() {
		return scaleactionsList;
	}

	public void setScaleactionsList(List<scaleAction> scaleactionsList) {
		this.scaleactionsList = scaleactionsList;
	}
    
}