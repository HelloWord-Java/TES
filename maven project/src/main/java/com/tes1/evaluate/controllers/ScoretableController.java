package com.tes1.evaluate.controllers;

import com.mysql.jdbc.StringUtils;
import com.sun.javafx.collections.MappingChange;
import com.tes1.evaluate.domain.*;
import com.tes1.evaluate.service.AvgscoresServive;
import com.tes1.evaluate.service.ScoretableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class ScoretableController {
    @Autowired
    private ScoretableService scoretableService;

    @RequestMapping("/findscoretable")
    @ResponseBody
    public ScoretableList findSearchSocrelist(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException{
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

        /*String userId = request.getParameter("userId");
        int uid =0;
        if(!StringUtils.isNullOrEmpty(userId)){
        	uid = Integer.parseInt(userId);
        }*/


        //4 获取成绩列表总数
        int total = scoretableService.getScoretableTotal();
        System.out.print("成绩记录总数："+total);
        ScoretableList scoreList= new ScoretableList();
        if(total>0){
            //5 获取成绩列表
            List<Scoretable> list = scoretableService.findScoretable(page, rows);
            scoreList.setRows(list);
        }
        scoreList.setTotal(total);

        return scoreList;
    }

    @RequestMapping("/ScoreData")

    public ModelAndView ScoreData(int teacherid,HttpServletRequest request){
        ModelAndView modelAndView;
            int anumber=scoretableService.findanumber(teacherid);
            int pnumber=scoretableService.findpnumber(teacherid)/10;
            List<BarDetail> list=scoretableService.classmatchData(teacherid);

            modelAndView=new ModelAndView("forward:/moduls/table/detail.jsp");
            modelAndView.addObject("anumber",anumber);
        modelAndView.addObject("pnumber",pnumber);
        modelAndView.addObject("bar",list);
        return modelAndView;
    }


}