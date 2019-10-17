package com.tes1.evaluate.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tes1.evaluate.domain.Course;

public interface CourseMapper {
	 //查找所有课程
	List<Course> findallcourses(Course course);
	
	//删除
	int deleteByPrimaryKey(List<Integer> list);
	
    int insert(Course record);
    
    //增加
    int insertSelective(Course record);
    
    //查找  
 
    
    //修改

	List<Course> findcourselist(Course course);
   //查询所有课程列表
	int getcourselistTotal(String filter);

	List<Course> getcourseList(@Param("page")int page,@Param("rows") int rows,@Param("filter")String filter);

	List<Course> findCourse(Course course);

	boolean updateByPrimaryKey(Course course);

	List<Course> findCourseById(Integer id);

	

	

}