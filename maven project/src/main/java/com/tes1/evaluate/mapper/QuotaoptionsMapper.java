package com.tes1.evaluate.mapper;

import java.util.List;

import com.tes1.evaluate.domain.Quotaoptions;

public interface QuotaoptionsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Quotaoptions record);

    int insertSelective(Quotaoptions record);

    Quotaoptions selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Quotaoptions record);

    int updateByPrimaryKey(Quotaoptions record);
    List<Quotaoptions> selectqutaoptions(Integer id);
	List<Quotaoptions> findQuotaoptionsListByUserId(int quotaId);
    int addQuotaOptionsByExcel(Quotaoptions quotaoptions);

   int insertoptions(int quotaId);
}