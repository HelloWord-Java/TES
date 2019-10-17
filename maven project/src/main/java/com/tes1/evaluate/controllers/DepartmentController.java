package com.tes1.evaluate.controllers;



import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tes1.evaluate.domain.Classinfo;
import com.tes1.evaluate.domain.Department;
import com.tes1.evaluate.domain.DepartmentList;
import com.tes1.evaluate.service.DepartmentService;


@Controller
public class DepartmentController {
		@Autowired
		private DepartmentService departmentservice;
		//返回批次列表
		@RequestMapping("/departmentAction")
		@ResponseBody
		public DepartmentList obtainDepartmentSearchList(HttpServletRequest request, HttpServletResponse response) throws IOException{
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
			int total = departmentservice.getDepartmentListTotal(filter);
			System.out.print("用户总数："+total);
			DepartmentList departmentList= new DepartmentList();
			if(total>0){
				//5 获取用户列表
				List<Department> list = departmentservice.getDepartmentList(page, rows, filter);
				departmentList.setRows(list);
			}
			departmentList.setTotal(total);

			return departmentList;
		}

	@RequestMapping("/initDeptTree")
    @ResponseBody
    public ModelAndView findQuotaList(HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("forward:/moduls/Department/DepartmentManger.jsp");
        return modelAndView;
    }

		@RequestMapping("/getDeptTree")
		@ResponseBody
		public List<Department> getDeptList(HttpServletResponse response) {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");
			return departmentservice.finddepartmentlist();
		}

	private ModelAndView findDeptList() {
		List<Department> deptList = departmentservice.finddepartmentlist();
		JSONArray jsonArray = JSONArray.fromObject(deptList);
		ModelAndView modelAndView = new ModelAndView("forward:/moduls/Department/DepartmentManager.jsp");
		modelAndView.addObject("dept", jsonArray.toString());
		return modelAndView;
	}
				/*@RequestMapping("/departmentAction")
				@ResponseBody
				public DepartmentList obtainDepartmentSearchList(HttpServletRequest request, HttpServletResponse response) throws IOException{
					request.setCharacterEncoding("UTF-8");
					response.setCharacterEncoding("UTF-8");
			        response.setContentType("text/html");
					int page = 0, rows = 20;        
			        //1 每页行数
			        String rowstr = request.getParameter("rows") ;
			        if(rowstr!=null && !rowstr.equals("")){
			        	rows = Integer.parseInt(rowstr);}
			        //2 页码
			        String pagestr = request.getParameter("page") ;
			        if(pagestr!=null && !pagestr.equals("")){
			        	page = Integer.parseInt(pagestr);
			        	if(page>0){
			        		page = (page-1)*rows;}
			        }
			        //3 过滤条件
			        String filter = request.getParameter("filter");
			        filter = filter==null ? "%%" : ("%"+filter+"%");
			        
			        //4 获取列表总数
			        int total = departmentservice.getDepartmentListTotal(filter);
			        System.out.print("用户总数："+total);
			        DepartmentList departmentList= new DepartmentList();
			        if(total>0){
			        	//5 获取用户列表
			            List<Department> list = departmentservice.getDepartmentList(page, rows, filter);
			            departmentList.setRows(list);
			        }
			        departmentList.setTotal(total);
			        
					return departmentList;
				}*/
				
		//增加院系信息
		@RequestMapping("/addDepartmentAction")
		public ModelAndView addDepartment(Department department) {
			ModelAndView modelAndView;
			boolean ret=departmentservice.addDepartment(department);
			if(ret){
				modelAndView=new ModelAndView("redirect:/departmentAction");
			}else{
				modelAndView=new ModelAndView("forward:/errorop.jsp");
			}
			return modelAndView;
		}
		//根据id查询院系信息并给修改页面
		@RequestMapping("/findDepartmentByIdAction")
		public String findDepartmentById(Integer Id,Model model) {
			List<Department> departments=departmentservice.findDepartmentById(Id);
			if(departments!=null) {
				model.addAttribute("departments", departments);
				return "forward:/moduls/Department/UpdateDepartment.jsp";
			}else {
				return "forward:/error.jsp";
			}
		}
		//修改院系信息
		@RequestMapping("/updateDepartmentAction")
		public String updateDepartment(Department department,Model model) {
			if (departmentservice.updateDepartment(department)) {
			List<Department> departments=departmentservice.findDepartment(department);
			model.addAttribute("departments", departments);
			return "forward:/moduls/Department/DepartmentManger.jsp";
		} else {
			return "forward:/error.jsp";
		}
	}
		//删除数据
				@RequestMapping("/deleteDepartmentByIdAction")
				@ResponseBody
				public Map<String, Object> deleteDepartmentById(String ids) {
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
							if (item != null && !item.equals(""))
							{list.add(Integer.parseInt(item));}
						}
						int result = departmentservice.deleteDepartmentById(list);
						map.put("success", result);
						map.put("msg", "删除成功");
						return map;
					}
				}
	}


