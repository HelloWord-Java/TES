package com.tes1.evaluate.mapper;

import java.util.List;

import com.tes1.evaluate.domain.scaleAction;

public interface scaleActionMapper {
	 int deleteByPrimaryKey(Integer id);

	    int insert(scaleAction record);

	    int insertSelective(scaleAction record);

	    scaleAction selectByPrimaryKey(Integer id);

	    int updateByPrimaryKeySelective(scaleAction record);

	    int updateByPrimaryKey(scaleAction record);
	    
	    
	    List<scaleAction> findActionId(List sclesids);
	    int addscaleAction(List<scaleAction> scaleactionsLists);
	    List<scaleAction> findscaleActionById(scaleAction scaleaction);
	    boolean deletescaleActionById(scaleAction scaleaction);
	    int addscaleActionSecond(List<scaleAction> listscaleactions);
	    List<scaleAction> findscaleActionsById(scaleAction scaleaction);
}