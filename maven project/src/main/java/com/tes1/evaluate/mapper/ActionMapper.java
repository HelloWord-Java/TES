package com.tes1.evaluate.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tes1.evaluate.domain.Action;
import com.tes1.evaluate.domain.scaleAction;

public interface ActionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Action record);

    int insertSelective(Action record);

    Action selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Action record);

    int updateByPrimaryKey(Action record);

	List<Action> findActionListByUserId(int userId);
	
	////

	    List<Action> findAction(Action action);
	    List<Action> AAfindAction(List<scaleAction> actionsidLists);
	    int getActionListTotal(String filter);
	    // 获取功能列表
	    List<Action> getActionList(@Param("page")int page, @Param("rows")int rows, @Param("filter")String filter);
	    int addAction(Action action);
	    Action findActionById(Action action);
	    int deleteActionInfoByIds(List<Integer> list);
	    int updateActionById(Action action);
}