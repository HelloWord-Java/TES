package com.tes1.evaluate.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tes1.evaluate.domain.scaleAction;
import com.tes1.evaluate.mapper.scaleActionMapper;


@Service
public class scaleActionService {
	@Autowired
	private scaleActionMapper scaleactionMapper;
	public List<scaleAction> findscaleActionId(List scalesids) {
		List<scaleAction> scaleactions=new ArrayList<scaleAction>();
		scaleactions= scaleactionMapper.findActionId(scalesids);
		return scaleactions;
	}
	public int addscaleAction(List<scaleAction> scaleactionsLists) {
		return scaleactionMapper.addscaleAction(scaleactionsLists);
	}
	public List<scaleAction> findscaleActionById(scaleAction scaleaction){
		return scaleactionMapper.findscaleActionById(scaleaction);
	}
	public boolean deletescaleActionById(scaleAction scaleaction){
		return scaleactionMapper.deletescaleActionById(scaleaction);
	}
	public int addscaleActionSecond(List<scaleAction> listscaleactions) {
		return scaleactionMapper.addscaleActionSecond(listscaleactions);
	}
	public List<scaleAction> findscaleActionsById(scaleAction scaleaction){
		return scaleactionMapper.findscaleActionsById(scaleaction);
	}
	
}
