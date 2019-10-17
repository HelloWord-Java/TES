package com.tes1.evaluate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tes1.evaluate.domain.ScoreSearch;
import com.tes1.evaluate.mapper.AvgscoresMapper;

@Service
public class AvgscoresServive {
@Autowired
private AvgscoresMapper avgscoresMapper;
public boolean AddAvgscores(Integer batchid) {
	if(avgscoresMapper.addavgscore(batchid)>0) {
		return true;
	}else {
		return false;
	}
}
    public int getScoreListTotal(int userId) {
	
	   return avgscoresMapper.getScoreListTotal(userId);
}
    public List<ScoreSearch> getScoreList(int uid, int page, int rows) {
	
	   return avgscoresMapper.getScoreList(uid,page,rows);
}
    //按条件查找成绩列表
	public int getsearchScoreListTotal(int uid,String coursename) {
		return avgscoresMapper.getsearchScoreListTotal(uid,coursename);
	}
	 public List<ScoreSearch> getsearchScoreList(int uid, String coursename, int page, int rows) {
		
		 return avgscoresMapper.getsearchScoreList(uid,coursename,page,rows);
	}
}
