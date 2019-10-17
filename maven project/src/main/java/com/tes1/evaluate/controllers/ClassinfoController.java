package com.tes1.evaluate.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tes1.evaluate.domain.Batch;
import com.tes1.evaluate.domain.Classinfo;
import com.tes1.evaluate.domain.ClassinfoList;
import com.tes1.evaluate.service.ClassinfoService;


@Controller
public class ClassinfoController {
		@Autowired
		private ClassinfoService classinfoservice;

		@RequestMapping("/classinfoAction")
		@ResponseBody
		public ClassinfoList obtainClassinfoSearchList(HttpServletRequest request, HttpServletResponse response) throws IOException{
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
	        response.setContentType("text/html");
			int page = 0, rows = 20;        
	        //1 每页行数
	        String rowstr = request.getParameter("rows") ;
	        if(rowstr!=null && !rowstr.equals("")) {
				rows = Integer.parseInt(rowstr);
			}
	        //2 页码
	        String pagestr = request.getParameter("page") ;
	        if(pagestr!=null && !pagestr.equals("")){
	        	page = Integer.parseInt(pagestr);
	        	if(page>0) {
					page = (page-1)*rows;
				}
	        }
	        //3 过滤条件
	        String filter = request.getParameter("filter");
	        filter = filter==null ? "%%" : ("%"+filter+"%");
	        
	        //4 获取列表总数
	        int total = classinfoservice.getClassinfoListTotal(filter);
	        System.out.print("用户总数："+total);
	        ClassinfoList classinfoList= new ClassinfoList();
	        if(total>0){
	        	//5 获取用户列表
	            List<Classinfo> list = classinfoservice.getClassinfoList(page, rows, filter);
	            classinfoList.setRows(list);
	        }
	        classinfoList.setTotal(total);
	        
			return classinfoList;
		}
		
		//增加班级
		@RequestMapping("/addClassinfoAction")
		public ModelAndView addClassinfo(Classinfo classinfo) {
			ModelAndView modelAndView;
			boolean ret=classinfoservice.addClassinfo(classinfo);
			if(ret){
				modelAndView=new ModelAndView("redirect:/classinfoAction");
			}else{
				modelAndView=new ModelAndView("forward:/errorop.jsp");
			}
			return modelAndView;
		}
		
		//根据id查询班级信息并给修改页面
				@RequestMapping("/findclassid")
				public String findclassid(Integer Id, Model model) {
					List<Classinfo> classinfos = classinfoservice.findClassid(Id);
					if(classinfos!=null) {
						model.addAttribute("classinfos", classinfos);
						return "forward:/moduls/Classinfo/UpdateClassinfo.jsp";
					}else {
						return "forward:/error.jsp";
					}
				}
		//修改班级信息
		@RequestMapping("/updateClassinfo")
		public String updateClassinfo(Classinfo classinfo, Model model) {
			if (classinfoservice.UpdateClassinfo(classinfo)) {
				List<Classinfo> classinfos = classinfoservice.findClassinfo(classinfo);
				model.addAttribute("classinfos", classinfos);
				return "forward:/moduls/Classinfo/ClassinfoManger.jsp";
			} else {
				return "forward:/error.jsp";
			}
		}
		//删除数据
		@RequestMapping("/deleclass")
		@ResponseBody
		public Map<String, Object> deleteClassinfo(String ids) {
			Map<String, Object> map = new HashMap<String, Object>();
			if (ids == null || ids.equals("")) {
				map.put("success", 0);
				map.put("msg", "删除成功");
				return map;
			} else {
				String[] arr = ids.split(",");
				List<Integer> list = new ArrayList<Integer>();
				for (int i = 0; i < arr.length; i++) {
					String item = arr[i];
					if (item != null && !item.equals("")) {
						list.add(Integer.parseInt(item));
					}
				}
				int result = classinfoservice.DeleteClassinfo(list);
				map.put("success", result);
				map.put("msg", "删除成功");
				return map;
			}
		}

	}


