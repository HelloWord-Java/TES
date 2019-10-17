package com.tes1.evaluate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tes1.evaluate.domain.Action;
import com.tes1.evaluate.domain.Batch;
import com.tes1.evaluate.mapper.BatchMapper;

@Service
public class BatchService {
	@Autowired
	private BatchMapper batchmapper;
	//修改时根据id查询批次
	public List<Batch> FindBatchid(Integer Id){
		List<Batch> batchs=batchmapper.findbatchid(Id);
		if(batchs!=null) {
			return batchs;
		}else {
			return null;
		}
	}
	// ��ѯ��������
	public List<Batch> FindBatch(Batch batch) {
		List<Batch> batchs = batchmapper.selectByPrimaryKey(batch);
		if (batchs != null) {
			return batchs;
		} else {
			return null;
		}

	}
	// �޸�����
	public boolean UpdateBatch(Batch batch) {
		if (batchmapper.updateByPrimaryKeySelective(batch) > 0) {
			return true;
		} else {
			return false;
		}
	}

	// ��������
	public boolean AddBatch(Batch batch) {
		if (batchmapper.insertSelective(batch) > 0) {
			return true;
		} else {
			return false;
		}
	}
	public List<Batch> getBatchList(int page, int rows, String filter){
		
		return batchmapper.getBatchList(page, rows, filter);
		
	}
	public int getBatchListTotal(String filter){
		return batchmapper.getBatchListTotal(filter);
	}
	public List<Batch> findbatchs(Batch batch) {
		return batchmapper.findbatchNameList(batch);
	}
	public int DeleteBatch(List<Integer> list) {
		return batchmapper.deleteByPrimaryKey(list);
	}

	
}
