package com.tes1.evaluate.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tes1.evaluate.domain.Avgscores;
import com.tes1.evaluate.domain.ScoreSearch;

public interface AvgscoresMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(Avgscores record);

    int insertSelective(Avgscores record);

    Avgscores selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Avgscores record);

    int updateByPrimaryKey(Avgscores record);
    //增加批次
    int addavgscore(Integer batchid);
    //查看成绩列表
	int getScoreListTotal(Integer userId);
	
    List<ScoreSearch> getScoreList(@Param("uid") int uid, @Param("page")int page, @Param("rows")int rows);
  //按条件查找成绩列表
	int getsearchScoreListTotal(int uid,String coursename);

	List<ScoreSearch> getsearchScoreList(@Param("uid")int uid,  @Param("coursename")String coursename,  @Param("page")int page, @Param("rows") int rows);

}