package com.tes1.evaluate.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tes1.evaluate.domain.Course;
import com.tes1.evaluate.mapper.CourseMapper;

@Service
public class CourseService {
	@Autowired
	private CourseMapper coursemapper;
	//增加课程
	public int insertSelective(Course course) {
		return coursemapper.insert(course);
	}
	
	//修改查找id
//	public List<Course> selectByPrimaryKey(Integer rowId) {
//		return coursemapper.findCourseById(rowId);
//	}
	//修改
	public List<Course> selectByPrimaryKey(Integer id) {
		return coursemapper.findCourseById(id);
	}
	//删除

	public int deleteByPrimaryKey(List<Integer> list) {
		return coursemapper.deleteByPrimaryKey(list);
	}
	public List<Course> findcourselist(Course course) {
		return coursemapper.findcourselist(course);
	}
	//查找所有课程信息
	public int getcourseListTotal(String filter) {
		return coursemapper.getcourselistTotal(filter);
	}
	public List<Course> getcourseList(int page, int rows, String filter) {
		return coursemapper.getcourseList(page,rows,filter);
	}

	public boolean updateByPrimaryKeySelective(Course course) {
		return coursemapper.updateByPrimaryKey(course);
	}

	public List<Course> findCourse(Course course) {
		return coursemapper.findCourse(course);
	}

	
	
}
