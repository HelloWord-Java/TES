package com.tes1.evaluate.domain;

import java.util.List;

public class Quota {
	private List<Quotaoptions> quotaoptions;
	
	private String number;
	
	private Integer id;

    private String quotaName;

    private Integer type;

    private Float weight;

    private Integer parentId;

    private Boolean isLeaf;

    private String formula;

    private String remark;

    private Boolean isDelete;
    
    private Integer sort;
    
    private Float levelWeight;
    
    public Float getLevelWeight() {
		return levelWeight;
	}

	public void setLevelWeight(Float levelWeight) {
		this.levelWeight = levelWeight;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuotaName() {
        return quotaName;
    }

    public void setQuotaName(String quotaName) {
        this.quotaName = quotaName == null ? null : quotaName.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Boolean getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula == null ? null : formula.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
    public List<Quotaoptions> getQuotaoptions() {
		return quotaoptions;
	}

	public void setQuotaoptions(List<Quotaoptions> quotaoptions) {
		this.quotaoptions = quotaoptions;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}