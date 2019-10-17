package com.tes1.evaluate.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tes1.evaluate.domain.Course;
import com.tes1.evaluate.domain.CourseList;
import com.tes1.evaluate.domain.TeachingInfo;
import com.tes1.evaluate.domain.TeachingList;
import com.tes1.evaluate.service.CourseService;
import com.tes1.evaluate.service.TeachingService;

@Controller
public class CourseController {
	@Autowired
	private CourseService courseservice;
	@Autowired
	private TeachingService teachingservice;

	// 查找所有课程
	@RequestMapping("/coursesAction")
	@ResponseBody
	public CourseList findCourses(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		int page = 0, rows = 20;
		// 1 每页行数
		String rowstr = request.getParameter("rows");
		if (rowstr != null && !rowstr.equals("")) {
			rows = Integer.parseInt(rowstr);
		}
		// 2 页码
		String pagestr = request.getParameter("page");
		if (pagestr != null && !pagestr.equals("")) {
			page = Integer.parseInt(pagestr);
			if (page > 0) {
				page = (page - 1) * rows;
			}
		}
		// 3 过滤条件(按条件查询需过滤条件)
		 String filter = request.getParameter("filter");
	      filter = filter==null ? "%%" : ("%"+filter+"%");
		// 4 获取列表总数
		int total = courseservice.getcourseListTotal(filter);
		System.out.print("用户总数：" + total);
		CourseList courserList = new CourseList();
		if (total > 0) {
			// 5 获取用户列表
			List<Course> list = courseservice.getcourseList(page, rows,filter);
			courserList.setRows(list);
		}
		courserList.setTotal(total);

		return courserList;
	}

	
	
	// 增加课程
	@RequestMapping("/insertSelective")
	public ModelAndView insertCourse(Course course) {
		ModelAndView modelAndView;
		int ret = courseservice.insertSelective(course);
		if (ret != 0) {
			modelAndView = new ModelAndView("redirect:/coursesAction");
		} else {
			modelAndView = new ModelAndView("forward:/errorop.jsp");
		}
		return modelAndView;
	}

	// 根据id查询院系信息并给修改页面
	@RequestMapping("/selectByPrimaryKey")
	public String findDepartmentById(Integer Id, Model model) {
		List<Course> courses = courseservice.selectByPrimaryKey(Id);
		if (courses != null) {
			model.addAttribute("courses", courses);
			return "forward:/moduls/course/UpdateCourse.jsp";
		} else {
			return "forward:/error.jsp";
		}
	}

	// 修改
	// 修改院系信息
	@RequestMapping("/updateCourseAction")
	@ResponseBody
	public String updateCourse(Course course) {
		if (courseservice.updateByPrimaryKeySelective(course)) {
			//List<Course> courses = courseservice.findCourse(course);
			//model.addAttribute("courses", courses);
			return "{\"code\":1,\"message\":\"修改成功\"}";
		} else {
			return "{\"code\":0,\"message\":\"修改失败\"}";
		}
	}

	// 删除课程
	@RequestMapping("/deleteCourseByIdAction")
	@ResponseBody
	public Map<String, Object> deleteCourse(String ids) {
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
			int result = courseservice.deleteByPrimaryKey(list);
			map.put("success", result);
			map.put("msg", "删除成功");
			return map;
		}
	}
}
