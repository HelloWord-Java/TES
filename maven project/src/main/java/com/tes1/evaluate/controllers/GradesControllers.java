package com.tes1.evaluate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tes1.evaluate.domain.Grades;
import com.tes1.evaluate.service.GradesService;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GradesControllers {
@Autowired
private GradesService gradesservice;
@RequestMapping("/addgrade")
@ResponseBody
public String addgrade(Grades grades) {
	if(gradesservice.AddGrade(grades)) {
		return "1";
	}
	return "forward:error.jsp";
}
}
