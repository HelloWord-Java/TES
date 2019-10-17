package com.tes1.evaluate.mapper;

import java.util.List;

import com.tes1.evaluate.domain.userScale;

public interface userScaleMapper {
 
    int deleteByPrimaryKey(Integer id);
    int insert(userScale record);
    int insertSelective(userScale record);
    userScale selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(userScale record);
    int updateByPrimaryKey(userScale record);
    
    
    List<userScale> finduserScaleId(userScale userscale);
    
    int adduserScale(List<userScale> userscalesList);
    
    List<userScale> finduserScaleById(userScale userscale);
    
    boolean deleteuserScaleById(userScale userscale);
    
    int adduserScaleSecond(List<userScale> listuserscales);
}