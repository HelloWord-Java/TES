package com.tes1.evaluate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tes1.evaluate.domain.Quotaoptions;
import com.tes1.evaluate.mapper.QuotaoptionsMapper;

@Service
public class QuotaoptionsService {
	@Autowired
	private QuotaoptionsMapper quotaoptionsMapper;
	/**
	 * 根据用户ID获取菜单列表
	 * @param
	 * @return
	 */
	public List<Quotaoptions> findQuotaoptionsListByUserId(int quotaId){
		return quotaoptionsMapper.findQuotaoptionsListByUserId(quotaId);
	}

	public int addQuotaOptionsByExcel(Quotaoptions quotaoptions){
		return quotaoptionsMapper.addQuotaOptionsByExcel(quotaoptions);
	}
	public int insertoptions(int quotaId){
		return  quotaoptionsMapper.insertoptions(quotaId);
	}
}
