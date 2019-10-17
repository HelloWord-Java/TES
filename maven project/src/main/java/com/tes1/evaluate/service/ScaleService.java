package com.tes1.evaluate.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tes1.evaluate.domain.Action;
import com.tes1.evaluate.domain.Scale;
import com.tes1.evaluate.domain.User;
import com.tes1.evaluate.domain.userScale;
import com.tes1.evaluate.mapper.ScaleMapper;

@Service
public class ScaleService {
	@Autowired
	private ScaleMapper scaleMapper;
	public List<Scale> findScaleId(Scale scale) {
		List<Scale> scales=new ArrayList<Scale>();
		if(scaleMapper.findScaleId(scale).size()>0){
			return scales;
		}else{
			return null;
		}
	}
	public List<Scale> findScale(Scale scale) {
	return scaleMapper.findScale(scale);
	}
	public List<Scale> AAfindScale(List<userScale> scalesidLists) {
		return scaleMapper.AAfindScale(scalesidLists);
	}
	/**
	 * 获取用户列表
	 * @param page
	 * @param rows
	 * @param filter
	 * @return
	 */
	public List<Scale> getScaleList(int page, int rows, String filter){
		return scaleMapper.getScaleList(page,rows,filter);
	}
	/**
	 * 获取角色列表总数
	 * @param filter
	 * @return
	 */
	public int getScaleListTotal(String filter){
		return scaleMapper.getScaleListTotal(filter);
	}
	public Scale findScaleById(Scale scale) {
		return scaleMapper.findScaleById(scale);
	}
	public int addScale(Scale scale) {
		return scaleMapper.addScale(scale);
	}
	/**
	 * 批量删除角色
	 * @param id
	 * @return
	 */
	public int removeScaleInfoByIds(List<Integer> list) {  
        return scaleMapper.deleteScaleInfoByIds(list);  
    }
	public int updateScaleById(Scale scale) {
		return scaleMapper.updateScaleById(scale);
	}
}
