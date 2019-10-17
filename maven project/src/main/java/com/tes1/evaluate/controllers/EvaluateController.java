package com.tes1.evaluate.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tes1.evaluate.domain.Quota;
import com.tes1.evaluate.domain.Quotaoptions;
import com.tes1.evaluate.service.QuotaService;
import com.tes1.evaluate.service.QuotaoptionsService;

@Controller
public class EvaluateController {
@Autowired
private QuotaService quotaService;
@Autowired
private QuotaoptionsService quotaoptionsService;
@RequestMapping("/findstdevaluate")
public String findQuota(String quotaName,Model model) {
	List <Quota> quotas=quotaService.findquotaName(quotaName);
	List <Quota> quotasvalue=quotaService.findvalue(quotaName);
	for(int i=0;i<quotas.size();i++) {
		List<Quotaoptions> quotaoptions=quotaoptionsService.findQuotaoptionsListByUserId(quotas.get(i).getId());
		for(int k=0;k<quotaoptions.size();k++) {
			quotaoptions.get(k).setScore(quotaoptions.get(k).getScore()*quotas.get(i).getWeight());
		}
		quotas.get(i).setQuotaoptions(quotaoptions);
		System.out.println(quotas.get(i).getQuotaName());
		for(int j=0;j<=3;j++) {
			System.out.println(quotaoptions.get(j).getOptionsName());
		}
		model.addAttribute("quotas", quotas);
		model.addAttribute("quotasvalue", quotasvalue);
	}
	return "forward:/moduls/evaluate/OnlineEvaluate.jsp";
}
@RequestMapping("/CreateQuestionnaire")
public String CreateQuestionnaire(Quota quota,Model model){
	List<Quota> quotas=quotaService.getQuestions(quota);
	model.addAttribute("quotas", quotas);
	return "forward:/moduls/evaluate/teacheva.jsp";
}
}
