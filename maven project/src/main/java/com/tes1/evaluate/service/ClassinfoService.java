package com.tes1.evaluate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tes1.evaluate.domain.Batch;
import com.tes1.evaluate.domain.Classinfo;
import com.tes1.evaluate.mapper.ClassinfoMapper;

@Service
public class ClassinfoService {
		// TODO Auto-generated constructor stub
		@Autowired
		private ClassinfoMapper  classinfomapper;
		//���ӿγ�
		public boolean addClassinfo(Classinfo classinfo) {
			return classinfomapper.addClassinfo(classinfo);
		}	
		//获取所有数据总条数
		public int getClassinfoListTotal(String filter) {
			return classinfomapper.getClassinfoListTotal(filter);
		}
		//获取所有数据行数和页数
		public List<Classinfo> getClassinfoList(int page, int rows, String filter) {
			return classinfomapper.getClassinfoList(page,rows,filter);
		}
		//查找班级所有数据
		public List<Classinfo> findclassinfolist(Classinfo classinfo) {
			return classinfomapper.findclassinfolist(classinfo);
		}

		public List<Classinfo> findclasslist(){
			return classinfomapper.findclasslist();
		}
		//修改班级信息
		public boolean UpdateClassinfo(Classinfo classinfo) {
			return classinfomapper.updateClassinfo(classinfo);
		}
		public List<Classinfo> findClassinfo(Classinfo classinfo) {
		 return classinfomapper.findClassinfo(classinfo);
		}
		//修改时根据id查询批次
		public List<Classinfo> findClassid(Integer Id) {
			return classinfomapper.findclassid(Id);
		}
		//删除数据
		public int DeleteClassinfo(List<Integer> list) {
			return classinfomapper.deleteClassinfoById(list);
		}
	}

