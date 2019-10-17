package com.tes1.evaluate.domain;

import java.util.List;

public class userScale {
    private Integer id;

    private Integer userId;

    private Integer scaleId;
    private List<userScale> userscalesList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getScaleId() {
        return scaleId;
    }

    public void setScaleId(Integer scaleId) {
        this.scaleId = scaleId;
    }

	public List<userScale> getUserscalesList() {
		return userscalesList;
	}

	public void setUserscalesList(List<userScale> userscalesList) {
		this.userscalesList = userscalesList;
	}
    
}