package com.tes1.evaluate.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tes1.evaluate.domain.Scale;
import com.tes1.evaluate.domain.userScale;

public interface ScaleMapper {
	  int deleteByPrimaryKey(Integer id);
	    int insert(Scale record);
	    int insertSelective(Scale record);
	    Scale selectByPrimaryKey(Integer id);
	    int updateByPrimaryKeySelective(Scale record);
	    int updateByPrimaryKey(Scale record);   
	    
	    List<Scale> findScaleId(Scale scale);
	    List<Scale> findScale(Scale scale);
	    List<Scale> AAfindScale(List<userScale> sclesidLists);
	 // 获取用户列表总数
	    int getScaleListTotal(String filter);
	 // 获取用户列表
	    List<Scale> getScaleList(@Param("page")int page, @Param("rows")int rows, @Param("filter")String filter);
	    Scale findScaleById(Scale scale);
	    int addScale(Scale scale);
	    int deleteScaleInfoByIds(List<Integer> list);
	    int updateScaleById(Scale scale);
		
}