package com.tes1.evaluate.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tes1.evaluate.domain.userScale;
import com.tes1.evaluate.mapper.userScaleMapper;

@Service
public class userScaleService {
	@Autowired
	private userScaleMapper userscaleMapper;
		public List<userScale> finduserScaleId(userScale userscale) {
			List<userScale> userscales=new ArrayList<userScale>();
			userscales = userscaleMapper.finduserScaleId(userscale);
				return userscales;
		}
public int adduserScale(List<userScale> userscalesList) {
			return userscaleMapper.adduserScale(userscalesList); 
		}
public List<userScale> finduserScaleById(userScale userscale) {
	return userscaleMapper.finduserScaleById(userscale);
}
public boolean deleteuserScaleById(userScale userscale) {
	return userscaleMapper.deleteuserScaleById(userscale); 
	}
public int adduserScaleSecond(List<userScale> listuserscales) {
	return userscaleMapper.adduserScaleSecond(listuserscales);
}
}
