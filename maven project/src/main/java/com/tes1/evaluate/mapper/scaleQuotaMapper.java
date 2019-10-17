package com.tes1.evaluate.mapper;

import com.tes1.evaluate.domain.scaleQuota;

public interface scaleQuotaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(scaleQuota record);

    int insertSelective(scaleQuota record);

    scaleQuota selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(scaleQuota record);

    int updateByPrimaryKey(scaleQuota record);
}