package com.tes1.evaluate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tes1.evaluate.domain.Action;
import com.tes1.evaluate.domain.scaleAction;
import com.tes1.evaluate.mapper.ActionMapper;

@Service
public class ActionService {
	@Autowired
	private ActionMapper actionMapper;
	/**
	 * 根据用户ID获取菜单列表
	 * @param userId
	 * @return
	 */
	public List<Action> findActionListByUserId(int userId){
		return actionMapper.findActionListByUserId(userId);
	}
	public List<Action> findAction(Action action) {
		return actionMapper.findAction(action);
	}

	public List<Action> AAfindAction(List<scaleAction> actionsidLists) {
		return actionMapper.AAfindAction(actionsidLists);
	}

	public int getActionListTotal(String filter) {
		return actionMapper.getActionListTotal(filter);
	}

	public List<Action> getActionList(int page, int rows, String filter) {
		return actionMapper.getActionList(page,rows,filter);
	}

	public int addAction(Action action) {
		return actionMapper.addAction(action);
	}

	public Action findActionById(Action action) {
		return actionMapper.findActionById(action);
	}

	public int removeActionInfoByIds(List<Integer> list) {
		return actionMapper.deleteActionInfoByIds(list);  
	}

	public int updateActionById(Action action) {
		return actionMapper.updateActionById(action);
	}
	
	
}
