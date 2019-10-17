package com.tes1.evaluate.mapper;

import com.tes1.evaluate.domain.BarDetail;
import com.tes1.evaluate.domain.PieDetail;
import com.tes1.evaluate.domain.Scoretable;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScoretableMapper {
    int getScoretableTotal();
    List<Scoretable> findScoretable(@Param("page")int page, @Param("rows")int rows);
    int findanumber(int teacherid);
    int findpnumber(int teacherid);
    List<BarDetail> classmatchData(int teacherid);

}
