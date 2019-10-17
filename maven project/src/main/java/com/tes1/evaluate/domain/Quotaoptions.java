package com.tes1.evaluate.domain;

public class Quotaoptions {
    private Integer id;

    private Integer quotaId;

    private String optionsName;

    private float score;
    
    private Float optionScore;

    public Float getOptionScore() {
		return optionScore;
	}

	public void setOptionScore(Float optionScore) {
		this.optionScore = optionScore;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuotaId() {
        return quotaId;
    }

    public void setQuotaId(Integer quotaId) {
        this.quotaId = quotaId;
    }

    public String getOptionsName() {
        return optionsName;
    }

    public void setOptionsName(String optionsName) {
        this.optionsName = optionsName == null ? null : optionsName.trim();
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}