package com.tes1.evaluate.service;

import com.tes1.evaluate.domain.BarDetail;
import com.tes1.evaluate.domain.PieDetail;
import com.tes1.evaluate.domain.Scoretable;
import com.tes1.evaluate.mapper.ScoretableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoretableService {
    @Autowired
    ScoretableMapper scoretableMapper;

    public int getScoretableTotal() {

        return scoretableMapper.getScoretableTotal();
    }
    public List<Scoretable> findScoretable(int page, int rows){
        return scoretableMapper.findScoretable(page,rows);
    }
    public int findanumber(int teacherid){
        return scoretableMapper.findanumber(teacherid);
    }
    public int findpnumber(int teacherid){
        return scoretableMapper.findpnumber(teacherid);
    }
    public List<BarDetail> classmatchData(int teacherid){ return scoretableMapper.classmatchData(teacherid);}
}
