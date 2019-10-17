package com.tes1.evaluate.controllers;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tes1.evaluate.domain.Batch;
import com.tes1.evaluate.domain.BatchList;
import com.tes1.evaluate.domain.User;
import com.tes1.evaluate.domain.UserList;
import com.tes1.evaluate.service.BatchService;

@Controller
public class BatchController {
	@Autowired
	private BatchService batchservice;
	//查询所有批次
	
	/**
	 * 返回批次列表
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/findallbatch")
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
	//根据id查询批次状态并给修改页面
	@RequestMapping("/idbatch")
	public String idbatch(Batch batch, Integer Id, Model model) {
		List <Batch> batchs=batchservice.FindBatch(batch);
		List <Batch> batchsid=batchservice.FindBatchid(Id);
		if(batchsid!=null) {
			if(batchsid.get(0).getState()==1) {
				model.addAttribute("batchs", batchs);
				return "forward:/moduls/evaluate/Batchretrieval.jsp";
			}else {
				model.addAttribute("batchs", batchs);
				return "forward:/moduls/evaluate/Batchretrievalerro.jsp";
			}
			
		}else {
			return "forward:/error.jsp";
		}
	}
	//根据id查询批次信息并给修改页面
	@RequestMapping("/findidbatch")
	public String findidbatch(Integer Id, Model model) {
		List <Batch> batchs=batchservice.FindBatchid(Id);
		if(batchs!=null) {
			model.addAttribute("batchs", batchs);
			return "forward:/moduls/Batchinfo/edit.jsp";
		}else {
			return "forward:/error.jsp";
		}
	}
	//查询所有批次
	@RequestMapping("/fallbatch")
	public String findallbatch(Batch batch,Model model) {
		List <Batch> batchs=batchservice.FindBatch(batch);
		if(batchs!=null){
			model.addAttribute("batchs", batchs);
			return "forward:/moduls/evaluate/Batchretrieval.jsp";
		}else {
			return"forward:/error.jsp";
		}
	}
	//修改批次信息
	@RequestMapping("/upbatch")
	public String updatebatch(Batch batch, Model model) {
		if (batchservice.UpdateBatch(batch)) {
			List<Batch> batchs = batchservice.FindBatch(batch);
			model.addAttribute("batchs", batchs);
			return "forward:/moduls/Batchinfo/BatchManger.jsp";
		} else {
			return "forward:/error.jsp";
		}
	}


	//删除数据
	@RequestMapping("/delebatch")
	@ResponseBody
	public Map<String, Object> deleteBatch(String ids) {
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
				if (item != null && !item.equals("")) {
					list.add(Integer.parseInt(item));
				}
			}
			int result = batchservice.DeleteBatch(list);
			map.put("success", result);
			map.put("msg", "删除成功");
			return map;
		}
	}
	//添加批次
	@RequestMapping("/addbatch")
	public String addbatch(Batch batch, Model model) {
		if (batchservice.AddBatch(batch)) {
			List<Batch> batchs = batchservice.FindBatch(batch);
			model.addAttribute("batchs", batchs);
			return "forward:/moduls/Batchinfo/BatchManger.jsp";
		} else {
			return "forward:/error.jsp";
		}
	}

}
