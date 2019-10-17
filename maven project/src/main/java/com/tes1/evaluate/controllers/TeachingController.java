package com.tes1.evaluate.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tes1.evaluate.domain.Action;
import com.tes1.evaluate.domain.Batch;
import com.tes1.evaluate.domain.Classinfo;
import com.tes1.evaluate.domain.Course;
import com.tes1.evaluate.domain.Department;
import com.tes1.evaluate.domain.Teaching;
import com.tes1.evaluate.domain.TeachingInfo;
import com.tes1.evaluate.domain.TeachingList;
import com.tes1.evaluate.domain.User;
import com.tes1.evaluate.service.BatchService;
import com.tes1.evaluate.service.ClassinfoService;
import com.tes1.evaluate.service.CourseService;
import com.tes1.evaluate.service.DepartmentService;
import com.tes1.evaluate.service.TeachingService;
import com.tes1.evaluate.service.UserService;

@Controller
public class TeachingController {
	@Autowired
	private TeachingService teachingService;
	@Autowired
	private BatchService batchService;
	@Autowired
	private ClassinfoService classinfoService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private UserService userService;
	
	/**
	 * 返回批次列表
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/findTeachingList")
	@ResponseBody
	public TeachingList obtainTeachingSearchList(HttpServletRequest request, HttpServletResponse response) throws IOException{
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
        int total = teachingService.getTeachingListTotal(filter);
        System.out.print("用户总数："+total);
        TeachingList teachingList= new TeachingList();
        if(total>0){
        	//5 获取用户列表
            List<TeachingInfo> list = teachingService.getTeachingList(page, rows);
            teachingList.setRows(list);
        }
        teachingList.setTotal(total);
        
		return teachingList;
	}
	/**
	 * 按条件查询
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/searchteachinginfo")
	@ResponseBody
	public TeachingList SearchTeachingList(HttpServletRequest request, HttpServletResponse response) throws IOException{
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
        
        //4 获取授课列表总数
        int total = teachingService.getTeachingSearchListTotal(filter);
        System.out.print("用户总数："+total);
        TeachingList teachingList= new TeachingList();
        if(total>0){
        	//5 获取授课关系列表
            List<TeachingInfo> list = teachingService.getTeachingSearchList(page, rows);
            teachingList.setRows(list);
        }
        teachingList.setTotal(total);
        
		return teachingList;
	}

	/**
	 * 按值查询列表
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/searchteaching")
	@ResponseBody
	public TeachingList TeachingSearchList(HttpServletRequest request, HttpServletResponse response,int batchid,int classid,int teacherid) throws IOException{
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
        int total = teachingService.getTeachingListTotal(filter);
        System.out.print("用户总数："+total);
        TeachingList teachingList= new TeachingList();
        if(total>0){
        	//5 获取用户列表
            List<TeachingInfo> list = teachingService.get(page, rows, classid, batchid,teacherid);
            teachingList.setRows(list);
        }
        teachingList.setTotal(total);
        
		return teachingList;
	}
	/**
	 * 按值查询列表
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/searchteachingby")
	@ResponseBody
	public TeachingList TeachingSearchListby(HttpServletRequest request, HttpServletResponse response,int batchid,int classid,int teacherid) throws IOException{
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
        int total = teachingService.getTeachingListTotal(filter);
        System.out.print("用户总数："+total);
        TeachingList teachingList= new TeachingList();
        if(total>0){
        	//5 获取用户列表
            List<TeachingInfo> list = teachingService.getgb(page, rows, classid, batchid,teacherid);
            teachingList.setRows(list);
        }
        teachingList.setTotal(total);
        
		return teachingList;
	}
	
	/**
	 * 增加授课关系
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/findTeachinginfo1")
	public ModelAndView addfindTeachinglist(Batch batch,Classinfo classinfo, Course course,User users,HttpServletRequest request) {
		ModelAndView modelAndView;
		List<Batch> batchs = batchService.findbatchs(batch);
		List<Classinfo> classinfos=classinfoService.findclassinfolist(classinfo);
		List<Course> courses=courseService.findcourselist(course);
		List<User> teachers=userService.findteachers(users);	
		modelAndView = new ModelAndView("forward:/moduls/Teachinginfo/addTeaching.jsp");
			modelAndView.addObject("batchs", batchs);
			modelAndView.addObject("classinfos",classinfos);
			modelAndView.addObject("courses",courses);
			modelAndView.addObject("teachers",teachers);
		return modelAndView;
	}
	@RequestMapping("/addTeachinginfo1")
	public ModelAndView  addTeachingList(@Valid Teaching teaching,HttpServletRequest request){
		ModelAndView modelAndView;
		int teachings=teachingService.addTeaching(teaching);
		if(teachings>0){
			modelAndView = new ModelAndView("forward:/moduls/Teachinginfo/addTeaching.jsp");	
			}
		else{
			modelAndView = new ModelAndView("forward:/error.jsp");
		}
		return modelAndView;
	}
	/**
	 * 修改数据
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/getTeachingInfoDetail")
	public  ModelAndView getTeachingInfoDetail(Integer id,HttpServletRequest request){
		ModelAndView modelAndView;
		Teaching entity = teachingService.findteachingDetailbyId(id);
		System.out.print("**********"+entity);
		if(entity!=null){
			List<Batch> batchs = batchService.findbatchs(null);
			List<Classinfo> classinfos=classinfoService.findclassinfolist(null);
			List<Course> courses=courseService.findcourselist(null);
			List<User> teachers=userService.findteachers(null);		
			modelAndView = new ModelAndView("forward:/moduls/Teachinginfo/update.jsp");	
			modelAndView.addObject("batchs", batchs);
			modelAndView.addObject("classinfos",classinfos);
			modelAndView.addObject("courses",courses);
			modelAndView.addObject("teachers",teachers);
			modelAndView.addObject("TeachingInfo", entity);
		}
		else{
			modelAndView = new ModelAndView("loginfailed");
		}
		return modelAndView;
	}
	
	@RequestMapping("/updateTeachinginfo1")
	public  ModelAndView updateTeachinglist(Teaching teaching,HttpServletRequest request){
		ModelAndView modelAndView;
		int rets=teachingService.updateTeaching(teaching);
		System.out.print("**********"+rets);
		if(rets>0){
			modelAndView = new ModelAndView("forward:/moduls/Teachinginfo/update.jsp");
		}
		else{
			modelAndView = new ModelAndView("loginfailed");
		}
		return modelAndView;
	}
	
	/**
	 * 删除数据
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/deleteteachinginfo")
	@ResponseBody
	public Map<String, Object> deleteTeachinginfo(String ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (ids == null || ids.equals("")) {
			map.put("success", 0);
			map.put("msg", "删除成功");
			return map;
		} else {
			// int result =
			// userService.deleteByPrimaryKey(Integer.parseInt(ids));
			String[] arr = ids.split(",");
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < arr.length; i++) {
				String item = arr[i];
				if (item != null && !item.equals("")) {
					list.add(Integer.parseInt(item));
				}
			}
			int result = teachingService.deleteTeachinginfoByIds(list);
			map.put("success", result);
			map.put("msg", "删除成功");
			return map;
		}
	}

}
