package com.tes1.evaluate.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tes1.evaluate.domain.Batch;
import com.tes1.evaluate.domain.Classinfo;


public interface ClassinfoMapper {
	//���Ӱ༶
	boolean addClassinfo(Classinfo classinfo);
	//ͨ����ѯid �޸İ༶
	Classinfo findallclassinfoById(Integer id);
	
	
	
	//获取所有数据总条数
	int getClassinfoListTotal(String filter);
	//获取所有数据行数和页数
	List<Classinfo> findclassinfolist(Classinfo classinfo);
	List<Classinfo> getClassinfoList(@Param("page")int page, @Param("rows")int rows, @Param("filter")String filter);
	//修改班级信息
	List<Classinfo> findClassinfo(Classinfo classinfo);
	boolean updateClassinfo(Classinfo classinfo);
	
	List<Classinfo> findclassid(Integer Id);
	
	int deleteClassinfoById(List<Integer> list);
	List<Classinfo> findclasslist();
}