package com.tes1.evaluate.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tes1.evaluate.domain.scaleAction;
import com.tes1.evaluate.service.scaleActionService;


@Controller
public class scaleActionController {
	@Autowired
	private scaleActionService scaleactionService;
	@RequestMapping("/findActionId")
	public String findActionId(HttpSession session){
		List<scaleAction> scaleactions=scaleactionService.findscaleActionId((List) session.getAttribute("scalesids"));
		List actions=new ArrayList();
		for(int i=0;i<scaleactions.size();i++) {
			System.out.println("yyyyyyy我是scaleAction"+scaleactions.get(i).getActionId());
			actions.add(scaleactions.get(i).getActionId());
		}
		if(scaleactions !=null){
			session.setAttribute("actions", actions);
			return "forward:/findAction";
		}
		return "loginfailed";
	
	}
/**
 * 插入角色权限表
 */
 @RequestMapping("/addscaleactionAction")
	public ModelAndView addUserScale(HttpServletRequest request) {
		ModelAndView modelAndView;
		List<scaleAction> scaleactionsLists=((List<scaleAction>)request.getAttribute("scaleactionList"));
		System.out.println("++++++++++++++mmmm"+scaleactionsLists);
		int ret=scaleactionService.addscaleAction(scaleactionsLists);
		if(ret>0){
			modelAndView=new ModelAndView("forward:/moduls/scale/scaleManager.jsp");
		}else{
			modelAndView=new ModelAndView("forward:/error.jsp");
		}
		return modelAndView;
	}
 
 	/**
	 * 通过id查询功能信息
	 */
	@RequestMapping("/findscaleActionByIdAction")
	//@ResponseBody
	public ModelAndView findThirdScale(scaleAction scaleaction,HttpServletRequest request){
		ModelAndView modelAndView;
		List<scaleAction> scaleactions = scaleactionService.findscaleActionById(scaleaction);
		if (scaleactions!=null) {
			modelAndView=new ModelAndView("forward:/moduls/scale/edit.jsp");
			modelAndView.addObject("scaleactions", scaleactions) ;
		} else {
			modelAndView=new ModelAndView("loginfailed");
		}
		return modelAndView;
	}
	
	/**
	 * 通过id删除角色原有的功能信息
	 */
	@RequestMapping("/deletescaleActionByIdAction")
	public String deleteUserById(scaleAction scaleaction) {
		boolean ret= scaleactionService.deletescaleActionById(scaleaction);
		if(ret){
			return "forward:/addscaleActionSecondAction?userId="+scaleaction.getScaleId()+"";//映射地址
		}else{
			return "forward:/error.jsp";
		}
	}
	/**
	 * 第二次插入角色功能表
	 */
	 @RequestMapping("/addscaleActionSecondAction")
		public ModelAndView addscaleActionSecond(scaleAction scaleaction,HttpServletRequest request) {
			ModelAndView modelAndView;
			String[]   values   =   request.getParameterValues("ListAct");
			List<scaleAction> listscaleactions=new ArrayList<scaleAction>();
			System.out.println("------------第二次插入角色功能表");
			for(int i=0;i<values.length;i++){
				scaleAction scaleauth=new scaleAction();
				String actionid = values[i];
				System.out.println(actionid);
				int scaleId = scaleaction.getScaleId();
				System.out.println(scaleId);
				scaleauth.setScaleId(scaleId);
				scaleauth.setActionId(Integer.parseInt(actionid));
				listscaleactions.add(scaleauth);
			}
			System.out.println("---------------------------'mmmmm"+listscaleactions);
			int ret = scaleactionService.addscaleActionSecond(listscaleactions);   
			if(ret>0){
				modelAndView=new ModelAndView("forward:/moduls/scale/scaleManager.jsp");
			}else{
				modelAndView=new ModelAndView("forward:/error.jsp");
			}
			return modelAndView;
		}
	/**
	 * 通过id查询角色信息(a标签)
	 */
	@RequestMapping("/AAscaleActionByIdAction")
	//@ResponseBody
	public ModelAndView findfourAction(scaleAction scaleaction,HttpServletRequest request){
		ModelAndView modelAndView;
		List<scaleAction> scaleactions =scaleactionService.findscaleActionById(scaleaction) ;
		System.out.println("这是很多功能idididid"+scaleactions);
		System.out.println("呵呵呵呵呵呵呵呵呵呵");
		request.setAttribute("actionidList", scaleactions);
		if (scaleactions!=null) {
			modelAndView=new ModelAndView("forward:/AAActionAction");
			modelAndView.addObject("scaleactions", scaleactions) ;
		} else {
			modelAndView=new ModelAndView("loginfailed");
		}
		/*request.setAttribute("flag", "yes");*/
		return modelAndView;
		//return scales;
	}
}
