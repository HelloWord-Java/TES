package com.tes1.evaluate.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.tes1.evaluate.domain.*;
import com.tes1.evaluate.service.ClassinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tes1.evaluate.service.ScaleService;

@Controller
public class scaleController {
	@Autowired
    private ClassinfoService classinfoService;
    @Autowired
	private ScaleService scaleService;


	// 查询角色信息
	@RequestMapping("/findScaleAction")
	public ModelAndView findScale(Scale scale, HttpServletRequest request){

		ModelAndView modelAndView;
		List<Scale> scales = scaleService.findScale(scale);
		List<Classinfo> classinfoList=classinfoService.findclasslist();

		if (scales!=null) {
			modelAndView=new ModelAndView("forward:/moduls/user/add.jsp");
			modelAndView.addObject("scales", scales) ;
			modelAndView.addObject("classlist", classinfoList) ;
		} else {
			modelAndView=new ModelAndView("loginfailed");
		}
		return modelAndView;
	}
	//修改用户查询角色信息
	@RequestMapping("/findSecondScaleAction")
	public ModelAndView findSecondScale(Scale scale,HttpServletRequest request){
		ModelAndView modelAndView;
		List<Scale> scales = scaleService.findScale(scale);
		String id = request.getParameter("id");
		System.out.println("LLLLLLLLLLLLL"+id);
		if (scales!=null) {
			modelAndView=new ModelAndView("forward:/findUserByIdAction");
			modelAndView.addObject("scales", scales) ;
		} else {
			modelAndView=new ModelAndView("loginfailed");
		}
		return modelAndView;
	}
	//查用户的角色名称
	@RequestMapping("/AAScaleAction")
	public ModelAndView AAfindScale(HttpServletRequest request){
		ModelAndView modelAndView;
		List<userScale> scalesidLists=((List<userScale>)request.getAttribute("scaleidList"));
		System.out.println("Boxboxboxboxboxboxbxobxobxoxboxbox"+scalesidLists);
		List<Scale> scales = scaleService.AAfindScale(scalesidLists);
		if (scales!=null) {
			modelAndView=new ModelAndView("forward:/moduls/user/detail.jsp");
			modelAndView.addObject("scales", scales) ;
		} else {
			modelAndView=new ModelAndView("loginfailed");
		}
		return modelAndView;
	}
	//返回角色列表
	@RequestMapping("/scalelistAction")
	@ResponseBody
	public ScaleList obtainScaleList(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
		int page = 0, rows = 10;        
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
        int total = scaleService.getScaleListTotal(filter);
        System.out.print("角色总数："+total);
        ScaleList scaleList= new ScaleList();
        if(total>0){
        	//5 获取用户列表
            List<Scale> list = scaleService.getScaleList(page, rows, filter);
            scaleList.setRows(list);
        }
        scaleList.setTotal(total);
        
		return scaleList;
	}
	//
	@RequestMapping("/scalelistSearchAction")
	@ResponseBody
	public ScaleList obtainScaleSearchList(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
		int page = 0, rows = 10;        
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
        int total = scaleService.getScaleListTotal(filter);
        System.out.print("角色总数："+total);
        ScaleList scaleList= new ScaleList();
        if(total>0){
        	//5 获取用户列表
            List<Scale> list = scaleService.getScaleList(page, rows, filter);
            scaleList.setRows(list);
        }
        scaleList.setTotal(total);
        
		return scaleList;
	}
	//用户通过a标签查看角色功能详情
    @RequestMapping("/lookingActionAction")
	public ModelAndView AScaleById(Scale scale) {
		ModelAndView modelAndView;
		System.out.println("RRRRRRRRRRRRRRR"+scale.getId());
		Scale aascales= scaleService.findScaleById(scale);
		//request.setAttribute("users", aausers.getUsername());
		System.out.println("RRRRRRRRRRRRRRRRR"+aascales.getScaleName());
		if(aascales!=null){
			modelAndView=new ModelAndView("forward:/AAscaleActionByIdAction?scaleId="+scale.getId()+"");
			modelAndView.addObject("scale",aascales) ;
		}else{
			modelAndView=new ModelAndView("forward:/error.jsp");
		}
		return modelAndView;
	}
    //增加角色
    @RequestMapping("/addScaleAction")
	public ModelAndView addScale(@Valid Scale scale,HttpServletRequest request) {
		ModelAndView modelAndView;
		int ret = scaleService.addScale(scale); 
		System.out.println("插入前主键为："+scale.getId());
		String[]   values   =   request.getParameterValues("actList");
		List<scaleAction> scaleactionList=new ArrayList<scaleAction>();
		for(int i=0;i<values.length;i++){
			scaleAction userscal=new scaleAction();
			String actionid = values[i];
			System.out.println(actionid);
			int scaleId = scale.getId();
			System.out.println(scaleId);
			userscal.setScaleId(Integer.parseInt(actionid));
			userscal.setActionId(scaleId);
			scaleactionList.add(userscal);
		}
		System.out.println("+++++++++++++++++++++++++++"+scaleactionList);
		request.setAttribute("scaleactionList", scaleactionList);
		if(ret>0){
			modelAndView=new ModelAndView("forward:/addscaleactionAction");
		}else{
			modelAndView=new ModelAndView("forward:/error.jsp");
		}
		return modelAndView;
	}	
    // 删除角色
    @RequestMapping("/deleteScale")  
    @ResponseBody  
    public Map<String,Object> deleteScale(String ids) {
    	Map<String,Object> map = new HashMap<String,Object>();  
        if(ids==null || ids.equals("")){
        	map.put("success", 0);  
            map.put("msg", "无可删除角色");  
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
        	int result = scaleService.removeScaleInfoByIds(list);
            map.put("success", result);  
            map.put("msg", "删除成功");  
            return map;
        }        
    }	
   // 角色修改查询
    @RequestMapping("/findScaleByIdAction")
	public ModelAndView findScaleById(Scale scale) {
		ModelAndView modelAndView;
		System.out.println("PPPPPPPPPPPPP"+scale.getId());
		Scale scales= scaleService.findScaleById(scale);
		if(scales!=null){
			modelAndView=new ModelAndView("forward:/findscaleActionByIdAction?scaleId="+scale.getId()+"");
			modelAndView.addObject("scale",scales) ;
		}else{
			modelAndView=new ModelAndView("forward:/error.jsp");
		}
		return modelAndView;
	}
    //角色修改
    @RequestMapping("/updateScaleAndActionAction")
    public ModelAndView updateScale(Scale scale) {
		ModelAndView modelAndView;
		System.out.println("66666666666666666666"+scale.getId());
		int ret = scaleService.updateScaleById(scale);
		if(ret>0){
			modelAndView=new ModelAndView("forward:/deletescaleActionByIdAction?scaleId="+scale.getId()+"");
		}else{
			modelAndView=new ModelAndView("forward:/error.jsp");
		}
		return modelAndView;
	}
}
