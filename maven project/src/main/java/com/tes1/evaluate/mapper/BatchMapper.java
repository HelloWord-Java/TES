package com.tes1.evaluate.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tes1.evaluate.domain.Batch;

public interface BatchMapper {
	List <Batch> findbatchid (Integer Id);
	
    int insert(Batch record);

    int insertSelective(Batch record);

    List<Batch> selectByPrimaryKey(Batch batch);

    int updateByPrimaryKeySelective(Batch record);

    int updateByPrimaryKey(Batch record);
    
    List<Batch> getBatchList(@Param("page")int page, @Param("rows")int rows, @Param("filter")String filter);
    
    int getBatchListTotal(String filter);

	List<Batch> findbatchNameList(Batch batch);

	int deleteByPrimaryKey(List<Integer> list);

	
}