package com.tes1.evaluate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tes1.evaluate.domain.Teaching;
import com.tes1.evaluate.domain.TeachingInfo;
import com.tes1.evaluate.mapper.TeachingMapper;

@Service
public class TeachingService {
	@Autowired
	private TeachingMapper teachingMapper;

	public List<Teaching> findAllTeachings(Teaching teaching) {
		return teachingMapper.findAllTeachings(teaching);
	}

	public int deleteteachingBycourseId(Integer id) {
		return teachingMapper.deleteByCourseId(id);
	}

	// 获取所有数据总条数
	public int getTeachingListTotal(String filter) {
		return teachingMapper.getTeachingListTotal(filter);
	}

	// 获取所有数据行数和页数
	public List<TeachingInfo> getTeachingList(int page, int rows) {
		return teachingMapper.getTeachingList(page, rows);
	}

	public List<TeachingInfo> get(int page, int rows, int classid, int batchid, int teacherid) {
		return teachingMapper.getTeachingidList(page, rows, classid, batchid, teacherid);
	}

	public List<TeachingInfo> getgb(int page, int rows, int classid, int batchid, int teacherid) {
		return teachingMapper.groupbyTeachingidList(page, rows, classid, batchid, teacherid);
	}

	// 删除授课关系
	public int deleteTeachinginfoByIds(List<Integer> list) {
		return teachingMapper.deleteTeachinginfoByIds(list);
	}

	public int addTeaching(Teaching teaching) {

		return teachingMapper.addTeaching(teaching);
	}

	public Teaching findteachingbyId(Teaching teaching) {

		return teachingMapper.findteachingbyId(teaching);
	}

	public Teaching findteachingDetailbyId(int rowId) {

		return teachingMapper.findteachingDetailbyId(rowId);
	}

	public int updateTeaching(Teaching teaching) {
		return teachingMapper.updateTeaching(teaching);
	}

	// 获取按条件查询所有数据总条数
	public int getTeachingSearchListTotal(String filter) {
		return teachingMapper.getTeachingSearchListTotal(filter);
	}

	public List<TeachingInfo> getTeachingSearchList(int page, int rows) {
		return teachingMapper.getTeachingSearchList(page, rows);
	}

}
