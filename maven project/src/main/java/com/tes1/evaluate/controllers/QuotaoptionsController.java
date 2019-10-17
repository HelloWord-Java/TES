package com.tes1.evaluate.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tes1.evaluate.domain.Quotaoptions;
import com.tes1.evaluate.service.QuotaoptionsService;

import net.sf.json.JSONArray;

@Controller
public class QuotaoptionsController {
	@Autowired
	private QuotaoptionsService quotaoptionsService;

	/**
	 * 根据用户ID获取指标选项
	 */
	@RequestMapping(value="/selectOptions",method={RequestMethod.POST},produces="application/json;charset=UTF-8")
	@ResponseBody
	public String findQuotaoptionsListByUserId(int quotaId, HttpServletRequest request) {
		Map<String,Object> map = new HashMap<String,Object>(); 
		List<Quotaoptions> quotaoptionsList = quotaoptionsService.findQuotaoptionsListByUserId(quotaId);
		for(int i=0;i<quotaoptionsList.size();i++){
			System.out.println(quotaoptionsList.get(i).getOptionsName());
			map.put("s", quotaoptionsList.get(i).getOptionsName());
		}
		JSONArray jsonArray = JSONArray.fromObject(quotaoptionsList);
		return jsonArray.toString();
	}
}
