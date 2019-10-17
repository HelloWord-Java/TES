package com.tes1.evaluate.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tes1.evaluate.domain.Batch;
import com.tes1.evaluate.domain.Teaching;
import com.tes1.evaluate.domain.TeachingInfo;

public interface TeachingMapper {
  List<Teaching> findAllTeachings(Teaching teaching);
  
  int deleteByCourseId(Integer id);
  //所有数据分页，行、页、总数
  int getTeachingListTotal(String filter);

  List<TeachingInfo> getTeachingList(@Param("page")int page, @Param("rows")int rows);
  //删除授课关系
  int deleteTeachinginfoByIds(List<Integer> list);

  int addTeachinginfo(TeachingInfo teachinginfo);
  //增加授课关系

   int addTeaching(Teaching teaching);

   Teaching findteachingbyId(Teaching teaching);
   Teaching findteachingDetailbyId(Integer rowId);
   
// 修改授课关系
  int updateTeaching(Teaching teaching);
  //所有按条件查询所有数据分页，行、页、总数
  int getTeachingSearchListTotal(String filter);
  List<TeachingInfo> getTeachingSearchList(@Param("page")int page, @Param("rows")int rows);
  


  List<TeachingInfo> getTeachingidList(@Param("page")int page, @Param("rows")int rows,@Param("classid")int classid, @Param("batchid")int batchid,@Param("teacherid")int teacherid);
  List<TeachingInfo> groupbyTeachingidList(@Param("page")int page, @Param("rows")int rows,@Param("classid")int classid, @Param("batchid")int batchid,@Param("teacherid")int teacherid);
}
