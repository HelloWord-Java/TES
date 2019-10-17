package com.tes1.evaluate.mapper;

import java.util.List;

import com.tes1.evaluate.domain.Quota;
import com.tes1.evaluate.domain.Quotaid;
import com.tes1.evaluate.domain.User;

public interface QuotaMapper {
	List<Quota> selectByParentId(Integer id);
	List<Quota> findquotaName (String quotaName);
	List<Quota> findvalue (String quotaName);
    int deleteByPrimaryKey(Integer id);
    
    int insert(Quota record);

    int insertSelective(Quota record);

    Quota selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Quota record);

    int updateByPrimaryKey(Quota record);

	List<Quota> findQuotaList();

	int AddQuota(Quota quota);

	int updateQuotaById(Quotaid quotaid);

    int addQuotaByExcel(Quota record);

    Quota findIdByName(Quota quota);

}