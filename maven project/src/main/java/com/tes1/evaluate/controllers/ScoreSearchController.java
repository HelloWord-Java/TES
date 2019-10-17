package com.tes1.evaluate.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.jdbc.StringUtils;
import com.tes1.evaluate.domain.ScoreSearch;
import com.tes1.evaluate.domain.ScoreSearchList;
import com.tes1.evaluate.domain.User;
import com.tes1.evaluate.service.AvgscoresServive;
import com.tes1.evaluate.service.UserService;

@Controller
public class ScoreSearchController { 
	@Autowired
	private AvgscoresServive avgscoreService;
	@RequestMapping("/findallScore")
	@ResponseBody
	public  ScoreSearchList findSearchSocrelist(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException{
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
        int uid = 0;
        if(session!=null){
        	String userId = session.getAttribute("userId").toString();
        	if(!StringUtils.isNullOrEmpty(userId)){
            	uid = Integer.parseInt(userId);
            }
        }
        /*String userId = request.getParameter("userId");
        int uid =0;
        if(!StringUtils.isNullOrEmpty(userId)){
        	uid = Integer.parseInt(userId);
        }*/
        
        System.out.println("用户ID："+ uid);
        //4 获取成绩列表总数
        int total = avgscoreService.getScoreListTotal(uid);
        System.out.print("成绩记录总数："+total);
        ScoreSearchList scoreList= new ScoreSearchList();
        if(total>0){
        	//5 获取成绩列表
          List<ScoreSearch> list = avgscoreService.getScoreList(uid, page, rows);
            scoreList.setRows(list);
        }
        scoreList.setTotal(total);
        
		return scoreList;
	}
    /*按条件查找*/
	
	@RequestMapping("/searchSocrelist")
	@ResponseBody
	public  ScoreSearchList searchSocrelist(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException{
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
        //3 获取session中的UserId
        int uid = 0;
        if(session!=null){
        	String userId = session.getAttribute("userId").toString();
        	if(!StringUtils.isNullOrEmpty(userId)){
            	uid = Integer.parseInt(userId);
            }
        }
        
        //4 按条件查找过滤条件
    	String coursename= request.getParameter("coursename");
    	coursename = coursename == null ? "%%" : ("%" + coursename + "%");
        
        System.out.println("课程名："+coursename);
        //4 获取成绩列表总数
        int total = avgscoreService.getsearchScoreListTotal(uid,coursename);
        System.out.print("成绩记录总数："+total);
        ScoreSearchList scoreList= new ScoreSearchList();
        if(total>0){
        	//5 获取成绩列表
          List<ScoreSearch> list = avgscoreService.getsearchScoreList(uid,coursename, page, rows);
            scoreList.setRows(list);
        }
        scoreList.setTotal(total);
        
		return scoreList;
	}
	

}
