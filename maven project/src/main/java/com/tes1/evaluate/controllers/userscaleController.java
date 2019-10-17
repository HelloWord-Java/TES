package com.tes1.evaluate.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tes1.evaluate.domain.userScale;
import com.tes1.evaluate.service.userScaleService;

@Controller
public class userscaleController {
	@Autowired 
	private userScaleService userscaleService;
	@RequestMapping("/finduserScale")
	public String finduserScaleId(userScale userscale,HttpSession session){
		List<userScale> userscales = userscaleService.finduserScaleId(userscale);
		List scalesids=new ArrayList();
		for(int i=0;i<userscales.size();i++){
			//取出角色id
			System.out.println("+++++++++++我是角色"+userscales.get(i).getScaleId());
			scalesids.add(userscales.get(i).getScaleId());
		}
		if(userscale!=null){
			session.setAttribute("scalesids", scalesids);
			return "forward:/findAactionId";
		}
		return "loginSuccess";
	}
	/**
	 * 插入用户角色表
	 */
	 @RequestMapping("/adduserScaleAction")
		public ModelAndView adduserScale(HttpServletRequest request) {
			ModelAndView modelAndView;
			List<userScale> userscalesLists=((List<userScale>)request.getAttribute("userscalesList"));
			System.out.println("---------------------------'mmmmm"+userscalesLists);
			int ret=userscaleService.adduserScale(userscalesLists);
			if(ret>0){
				modelAndView=new ModelAndView("forward:/moduls/user/userManager.jsp");
			}else{
				modelAndView=new ModelAndView("forward:/error.jsp");
			}
			return modelAndView;
		}	
	 	/**
		 * 通过id查询角色信息
		 */
		@RequestMapping("/finduserScaleByIdAction")
		//@ResponseBody
		public ModelAndView findThirdScale(userScale userscale,HttpServletRequest request){
			ModelAndView modelAndView;
			List<userScale> userscales = userscaleService.finduserScaleById(userscale);
			/*HttpSession session=request.getSession();
			 //JSONArray json = JSONArray.fromObject(scales);
			 session.setAttribute("scales", scales);*/
			if (userscales!=null) {
				modelAndView=new ModelAndView("forward:/moduls/user/edit.jsp");
				modelAndView.addObject("userscales", userscales) ;
			} else {
				modelAndView=new ModelAndView("loginfailed");
			}
			/*request.setAttribute("flag", "yes");*/
			return modelAndView;
			//return scales;
		}
		/**
		 * 通过id查询角色信息(a标签)
		 */
		@RequestMapping("/AAuserScaleByIdAction")
		//@ResponseBody
		public ModelAndView findfourScale(userScale userscale,HttpServletRequest request){
			ModelAndView modelAndView;
			List<userScale> userscales = userscaleService.finduserScaleById(userscale);
			/*HttpSession session=request.getSession();
			 //JSONArray json = JSONArray.fromObject(scales);
			 session.setAttribute("scales", userscales);*/
			System.out.println("这是很多角色idididid"+userscales);
			System.out.println("哈哈哈哈哈哈哈哈哈哈哈哈哈");
			request.setAttribute("scaleidList", userscales);
			if (userscales!=null) {
				modelAndView=new ModelAndView("forward:/AAScaleAction");
				modelAndView.addObject("userscales", userscales) ;
			} else {
				modelAndView=new ModelAndView("loginfailed");
			}
			/*request.setAttribute("flag", "yes");*/
			return modelAndView;
			//return scales;
		}
		/**
		 * 通过id删除用户原有的角色信息
		 */
		@RequestMapping("/deleteuserScaleByIdAction")
		public String deleteUserById(userScale userscale) {
			boolean ret= userscaleService.deleteuserScaleById(userscale);
			if(ret){
				return "forward:/adduserScaleSecondAction?userId="+userscale.getUserId()+"";//映射地址
			}else{
				return "forward:/error.jsp";
			}
		}
		/**
		 * 第二次插入用户角色表
		 */
		 @RequestMapping("/adduserScaleSecondAction")
			public ModelAndView addUserScaleSecond(userScale userscale,HttpServletRequest request) {
				ModelAndView modelAndView;
				String[]   values   =   request.getParameterValues("ListSca");
				List<userScale> listuserscales=new ArrayList<userScale>();
				System.out.println("++++++++第二次插入用户角色表++++++++");
				for(int i=0;i<values.length;i++){
					userScale userscal=new userScale();
					String scaleid = values[i];
					System.out.println(scaleid);
					int userId = userscale.getUserId();
					System.out.println(userId);
					userscal.setScaleId(Integer.parseInt(scaleid));
					userscal.setUserId(userId);
					listuserscales.add(userscal);
				}
				System.out.println("---------------------------'mmmmm"+listuserscales);
				int ret = userscaleService.adduserScaleSecond(listuserscales);   
				if(ret>0){
					modelAndView=new ModelAndView("forward:/moduls/user/userManager.jsp");
				}else{
					modelAndView=new ModelAndView("forward:/error.jsp");
				}
				return modelAndView;
			}
}
