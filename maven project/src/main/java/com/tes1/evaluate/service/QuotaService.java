package com.tes1.evaluate.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tes1.evaluate.domain.Quota;
import com.tes1.evaluate.domain.Quotaid;
import com.tes1.evaluate.domain.Quotaoptions;
import com.tes1.evaluate.mapper.QuotaMapper;
import com.tes1.evaluate.mapper.QuotaoptionsMapper;

@Service
public class QuotaService {
	@Autowired
	private QuotaMapper quotaMapper;
	@Autowired
	private QuotaoptionsMapper quotaOptionsMapper;

	public int addQuotaByExcel(Quota quota){return quotaMapper.addQuotaByExcel(quota);}
	public Quota findIdByName(Quota quota){return quotaMapper.findIdByName(quota);}
	/**
	 * 根据用户ID获取菜单列表
	 * @param user
	 * @return
	 */
	public List<Quota> findQuotaList(){
		return quotaMapper.findQuotaList();
	}
	//根据id删除指标项
	public Integer DelQuota(Integer id) {
		
			return quotaMapper.deleteByPrimaryKey(id);
		
	}
	//根据id修改指标
	public int upquotainfo(Quota quota) {
		return quotaMapper.updateByPrimaryKeySelective(quota);
	}
	public int AddQuota(Quota quota) {
		return quotaMapper.AddQuota(quota);
	}
	public int updateQuotaById(Quotaid quotaid) {
		return quotaMapper.updateQuotaById(quotaid);
	}
	public List<Quota> findquotaName(String quotaName ){
		List<Quota> quotas=quotaMapper.findquotaName(quotaName);
		if(quotas!=null) {
			return quotas;
		}else {
			return null;
		}
	}
	public List<Quota> findvalue (String quotaName){
		List<Quota> quotas= quotaMapper.findvalue(quotaName);
		if(quotas!=null) {
			return quotas;
		}else {
			return null;
		}
	}
	public List<Quota> getQuestions(Quota startQuota){
        List<Quota>  Questions = new ArrayList();
        getNodesByParentId(Questions,startQuota);
        return Questions;
    }

    public void  getNodesByParentId( List<Quota>  Questions ,Quota startQuota){
        List<Quota>  nodes =  quotaMapper.selectByParentId(startQuota.getId());

        if(nodes == null || nodes.size() == 0){
            List<Quotaoptions> QOS = quotaOptionsMapper.selectqutaoptions(startQuota.getId());
            for(Quotaoptions q : QOS){
                q.setOptionScore(startQuota.getLevelWeight() * q.getScore());
            }
            Questions.get(Questions.size()-1).setQuotaoptions(QOS);
        }
        int i = 1;
        for (Quota q : nodes){
            q.setLevelWeight(q.getWeight() * startQuota.getLevelWeight());
            if(startQuota.getNumber() == null || startQuota.getNumber() == "") {
            	q.setNumber(String.valueOf(i));
            }else {
            	q.setNumber(startQuota.getNumber() + "." + i);
            }
            
            Questions.add(q);
            i++;
            getNodesByParentId(Questions,q);
        }
    }
}
