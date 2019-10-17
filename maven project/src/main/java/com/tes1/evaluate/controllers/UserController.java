package com.tes1.evaluate.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.tes1.evaluate.domain.Classinfo;
import com.tes1.evaluate.service.ClassinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tes1.evaluate.domain.User;
import com.tes1.evaluate.domain.UserList;
import com.tes1.evaluate.domain.userScale;
import com.tes1.evaluate.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	private ClassinfoService classinfoService;
	@RequestMapping("/login")
	public String login(User user,HttpServletRequest request) {
		User users=userService.findUser(user);
		if(users!=null){
				HttpSession session=request.getSession();
				session.setAttribute("username",users.getUsername());
				session.setAttribute("userId",users.getId());
				session.setAttribute("password",users.getPassword());
				session.setAttribute("user", users);
				System.out.println(users.getUsername());
				System.out.println(users.getId());
			return "forward:/findActionListByUserId?userId="+users.getId()+"";
		} else {
			return "loginfailed";
		}
	}
	@RequestMapping("/userAction")
	public ModelAndView Userfind(User user,HttpServletRequest request) {
		ModelAndView modelAndView;
		List<User> users=userService.Userfind(user);
		if(users!=null) {
			modelAndView =new ModelAndView("forward:/moduls/user/userManager.jsp");
			modelAndView.addObject("users",users);
		}else {
			modelAndView=new ModelAndView("loginfailed");
		}
		request.setAttribute("flag", "yes");
		return modelAndView;
	}
	/**
	 * 返回用户列表
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/userlistAction")
	@ResponseBody
	public UserList obtainUserList(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
		int page = 0, rows = 20;        
        //1 每页行数
        String rowstr = request.getParameter("rows") ;
        if(rowstr!=null && !rowstr.equals(""))
        	rows = Integer.parseInt(rowstr);
        //2 页码
        String pagestr = request.getParameter("page") ;
        if(pagestr!=null && !pagestr.equals("")){
        	page = Integer.parseInt(pagestr);
        	if(page>0)
        		page = (page-1)*rows;
        }
        //3 过滤条件
        String filter = request.getParameter("filter");
        filter = filter==null ? "%%" : ("%"+filter+"%");
        
        //4 获取列表总数
        int total = userService.getUserListTotal(filter);
        System.out.print("用户总数："+total);
        UserList userList= new UserList();
        if(total>0){
        	//5 获取用户列表
            List<User> list = userService.getUserList(page, rows, filter);
			userList.setRows(list);
        }
        userList.setTotal(total);
        
		return userList;
	}
	/**
	 * 返回用户列表
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/userlistSearchAction")
	@ResponseBody
	public UserList obtainUserSearchList(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
		int page = 0, rows = 20;        
        //1 每页行数
        String rowstr = request.getParameter("rows") ;
        if(rowstr!=null && !rowstr.equals(""))
        	rows = Integer.parseInt(rowstr);
        //2 页码
        String pagestr = request.getParameter("page") ;
        if(pagestr!=null && !pagestr.equals("")){
        	page = Integer.parseInt(pagestr);
        	if(page>0)
        		page = (page-1)*rows;
        }
        //3 过滤条件
        String filter = request.getParameter("filter");
        filter = filter==null ? "%%" : ("%"+filter+"%");
        
        //4 获取列表总数
        int total = userService.getUserListTotal(filter);
        System.out.print("用户总数："+total);
        UserList userList= new UserList();
        if(total>0){
        	//5 获取用户列表
            List<User> list = userService.getUserList(page, rows, filter);
            userList.setRows(list);
        }
        userList.setTotal(total);
        
		return userList;
	}
	/**
	 * 删除用户
	 * @param ids
	 * @return
	 */
    @RequestMapping("/deletecustomer")  
    @ResponseBody  
    public Map<String,Object> deleteCustomer(String ids) {
    	Map<String,Object> map = new HashMap<String,Object>();  
        if(ids==null || ids.equals("")){
        	map.put("success", 0);  
            map.put("msg", "无可删除用户");  
            return map;
        } else{        	
            //int result = userService.deleteByPrimaryKey(Integer.parseInt(ids));
            String[] arr = ids.split(",");
            List<Integer> list = new ArrayList<Integer>();
            for(int i=0;i<arr.length;i++){
            	String item = arr[i];
            	if(item!=null && !item.equals("")) {
					list.add(Integer.parseInt(item));
				}
            }
        	int result = userService.removeUserInfoByIds(list);
            map.put("success", result);  
            map.put("msg", "删除成功");  
            return map;
        }        
    }	
    /**
     * 增加用户，同时增加用户角色
     * 先增加，在查询该用户id传到用户角色表，循环加入页面勾选的角色
     */
    @RequestMapping("/addUserAction")
	public ModelAndView addUser(@Valid User user,HttpServletRequest request) {
		ModelAndView modelAndView;
		//User user = new User(); 
		int ret = userService.addUser(user); 
		System.out.println("插入前主键为："+user.getId());
		
		String[]   values   =   request.getParameterValues("scaList");
	
		List<userScale> userscalesList=new ArrayList<userScale>();
		for(int i=0;i<values.length;i++){
			userScale userscale=new userScale();
			String scaleid = values[i];
			System.out.println("哇哈哈哈哈红红火火恍恍惚惚"+scaleid);

			int userId = user.getId();
			System.out.println(userId);
			userscale.setScaleId(Integer.parseInt(scaleid));
			userscale.setUserId(userId);
			userscalesList.add(userscale);
		}
		System.out.println("++++++++++实施+++++++++++++++++无数"+userscalesList);
		request.setAttribute("userscalesList", userscalesList);
		//session.setAttribute("usersclesList",usersclesList);
		if(ret>0){
			modelAndView=new ModelAndView("forward:/adduserScaleAction");
		}else{
			modelAndView=new ModelAndView("forward:/error.jsp");
		}
		return modelAndView;
	}	
    
    /**
     * 用户修改查询
     */
    @RequestMapping("/findUserByIdAction")
	public ModelAndView findUserById(User user) {
    	/*request.getParameter(id);
    	System.out.println("++++++++++++"+id);*/
		ModelAndView modelAndView;
		//System.out.println("/////////////////"+id);
//		User user1 = new User();
//		user1.setId(id);
		System.out.println("PPPPPPPPPPPPP"+user.getId());
		User users= userService.findUserById(user);
		if(users!=null){
			modelAndView=new ModelAndView("forward:/finduserScaleByIdAction?userId="+user.getId()+"");
			modelAndView.addObject("user",users) ;
		}else{
			modelAndView=new ModelAndView("forward:/error.jsp");
		}
		return modelAndView;
	}
    /**
     * 用户通过a标签查看用户详情
     */
    @RequestMapping("/lookingScaleAction")
	public ModelAndView AUserById(User user) {
		ModelAndView modelAndView;
		System.out.println("QQQQQQQQQQQQQQ"+user.getId());
		User aausers= userService.findUserById(user);
		//request.setAttribute("users", aausers.getUsername());
		System.out.println("QQQQQQQQQQQQQQ"+aausers.getUsername());
		if(aausers!=null){
			modelAndView=new ModelAndView("forward:/AAuserScaleByIdAction?userId="+user.getId()+"");
			modelAndView.addObject("user",aausers) ;
		}else{
			modelAndView=new ModelAndView("forward:/error.jsp");
		}
		return modelAndView;
	}
    
    /**
     * 用户修改
     */
    @RequestMapping("/updateUserAndScaleAction")
    public ModelAndView updateUser(User user) {
    	/*request.getParameter(id);
    	System.out.println("++++++++++++"+id);*/
		ModelAndView modelAndView;
		//System.out.println("/////////////////"+id);
//		User user1 = new User();
//		user1.setId(id);
		System.out.println("66666666666666666666"+user.getId());
		int ret = userService.updateUserById(user);
		if(ret>0){
			modelAndView=new ModelAndView("forward:/deleteuserScaleByIdAction?userId="+user.getId()+"");
		}else{
			modelAndView=new ModelAndView("forward:/error.jsp");
		}
		return modelAndView;
	}
    
}
