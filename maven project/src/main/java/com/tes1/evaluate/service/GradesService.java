package com.tes1.evaluate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tes1.evaluate.domain.Grades;
import com.tes1.evaluate.mapper.GradesMapper;

@Service
public class GradesService {
	@Autowired
private GradesMapper gradesmapper;
public boolean AddGrade(Grades grades ) {
	if(gradesmapper.insertSelective(grades)>0) {
		return true;
	}else{
		return false;
	}
	
}

}
