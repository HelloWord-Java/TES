package com.tes1.evaluate.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tes1.evaluate.domain.Action;
import com.tes1.evaluate.domain.Batch;
import com.tes1.evaluate.domain.BatchList;
import com.tes1.evaluate.domain.User;
import com.tes1.evaluate.domain.UserList;
import com.tes1.evaluate.service.AvgscoresServive;
import com.tes1.evaluate.service.BatchService;

import net.sf.json.JSONArray;

@Controller
public class StateControl {
		@Autowired
		private BatchService batchservice;
		@Autowired
		private AvgscoresServive avgscoresServive;
		
		// 修改批次的评教状态关闭评教的时候计算出平均成绩将其存入平均成绩表
		@RequestMapping("/modbatch")
		public String updatebatch(Batch batch, Model model,Integer batchid,Integer state) {
			if(state==0) {
				boolean ret=avgscoresServive.AddAvgscores(batchid);
				if (batchservice.UpdateBatch(batch)&&ret) {
					return "redirect:/allbatch";
				}else {
					return "forward:/error.jsp";
				}
			}else {
				if (batchservice.UpdateBatch(batch)) {
					List<Batch> batchs = batchservice.FindBatch(batch);
					model.addAttribute("batchs", batchs);
					return "forward:/moduls/State/StateManger.jsp";
				}else {
					return "forward:/error.jsp";
				}
			}
		}
		/**
		 * 返回批次列表
		 * @param request
		 * @param response
		 * @return
		 * @throws IOException
		 */
		@RequestMapping("/allbatch")
		@ResponseBody
		public BatchList obtainBatchSearchList(HttpServletRequest request, HttpServletResponse response) throws IOException{
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
	        int total = batchservice.getBatchListTotal(filter);
	        System.out.print("用户总数："+total);
	        BatchList batchList= new BatchList();
	        if(total>0){
	        	//5 获取用户列表
	            List<Batch> list = batchservice.getBatchList(page, rows, filter);
	            batchList.setRows(list);
	        }
	        batchList.setTotal(total);
	        
			return batchList;
		}
}
