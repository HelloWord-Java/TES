package com.tes1.evaluate.mapper;

import com.tes1.evaluate.domain.Grades;

public interface GradesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Grades record);

    int insertSelective(Grades record);

    Grades selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Grades record);

    int updateByPrimaryKey(Grades record);
}