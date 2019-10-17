package com.tes1.evaluate.domain;

public class Scale {
    private Integer id;

    private String scaleName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getScaleName() {
        return scaleName;
    }

    public void setScaleName(String scaleName) {
        this.scaleName = scaleName == null ? null : scaleName.trim();
    }
}