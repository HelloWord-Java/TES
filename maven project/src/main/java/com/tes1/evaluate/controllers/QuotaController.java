package com.tes1.evaluate.controllers;

import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.tes1.evaluate.domain.Quotaoptions;
import com.tes1.evaluate.service.QuotaoptionsService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tes1.evaluate.domain.Quota;
import com.tes1.evaluate.domain.Quotaid;
import com.tes1.evaluate.service.QuotaService;

import net.sf.json.JSONArray;

@Controller
public class QuotaController {
	@Autowired
	private QuotaService quotaService;
	private QuotaoptionsService quotaoptionsService;
	/**
	 * 根据用户ID删除指标项
	 */
	@RequestMapping("/delquota")
	@ResponseBody
public Integer delquota(Integer id) {
		return quotaService.DelQuota(id);
}
	/**
	 * 根据用户ID获取指标列表
	 */
	@RequestMapping("/initQuotaTree")
	@ResponseBody
	public ModelAndView findQuotaList(HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("forward:/moduls/quota/quotaManager.jsp");
		return modelAndView;
	}
	
	/**
	 * 根据用户ID获取指标列表
	 */
	@RequestMapping("/getQuotaTree")
	@ResponseBody
	public List<Quota> getQuotaList(HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        return quotaService.findQuotaList();
	}
	
	private ModelAndView findQuotaList() {
		List<Quota> quotaList = quotaService.findQuotaList();
		JSONArray jsonArray = JSONArray.fromObject(quotaList);
		ModelAndView modelAndView = new ModelAndView("forward:/moduls/quota/quotaManager.jsp");
		modelAndView.addObject("zhibiaos", jsonArray.toString());
		return modelAndView;
	}
	
	/**
	 * 增加父级指标
	 */
	@RequestMapping("/AddParentQuota")
	@ResponseBody
	public ModelAndView AddParentQuota(Quota quota,Integer id) {
		ModelAndView modelAndView = new ModelAndView();
		Quotaid quotaid = new Quotaid();
		System.out.println("被修改的id为"+id);
		quotaid.setIdd(id);
		int ret = quotaService.AddQuota(quota);
		System.out.println("修改前的父级主键id为："+quota.getId());
		int parentIdd = quota.getId();
		quotaid.setParentIdd(parentIdd);
		System.out.println(parentIdd+"------------------------------");
		if(ret>0){
			modelAndView=new ModelAndView("forward:/updateQuotaById?parentIdd="+quota.getId()+"&&idd="+id+"");
		}
		return modelAndView;
	}
	/**
	 * 改变父级指标后通过Id修改指标的内容
	 */
	@RequestMapping("/updateQuotaById")
	@ResponseBody
	public ModelAndView updateQuotaById(Quotaid quotaid) {
		System.out.println(quotaid.getIdd()+"------------------------------");
		System.out.println(quotaid.getParentIdd()+"------------------------------");
		ModelAndView modelAndView = new ModelAndView();
		int ret = quotaService.updateQuotaById(quotaid);
		if(ret>0){
			modelAndView = findQuotaList();
		}	
		return modelAndView;
	}
	
	/**
	 * 增加指标
	 */
	@RequestMapping("/AddChildQuota")
	@ResponseBody
	public Integer AddChildQuota(Quota quota) {

		return quotaService.AddQuota(quota);

	}
	@RequestMapping("/upQuotaiInfo")
	@ResponseBody
	public int upquotainfo(Quota quota) {
		return quotaService.upquotainfo(quota);
	}
	/**
	 * 解析excel
	 * @param quotaExcel
	 * @return
	 */
	@RequestMapping("/addAllQuota")
	@ResponseBody
	public int addQuotaByExcel(@RequestParam MultipartFile quotaExcel) {
		Quota quota=new Quota();
		Quotaoptions quotaoptions=new Quotaoptions();
		String fileName = quotaExcel.getOriginalFilename();
		long size = quotaExcel.getSize();
		String format = fileName.substring(fileName.lastIndexOf(".") + 1);
		System.out.println("文件名:" + fileName + ",大小:" + size / 1024 + "kb,格式:" + format);
		XSSFWorkbook xssfWorkbook = null;
		try {
			InputStream inputStream = quotaExcel.getInputStream();
			//- excel 2007+
			if ("xls".equals(format)) {
				xssfWorkbook = new XSSFWorkbook(inputStream);
			} else if ("xlsx".equals(format)) {
				xssfWorkbook = new XSSFWorkbook(inputStream);
			} else {
				throw new Exception("文件格式非法！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		XSSFSheet xssfSheet=xssfWorkbook.getSheetAt(0);
		Quota resId=null;
		for (int i=xssfSheet.getFirstRowNum()+1;i<xssfSheet.getLastRowNum();i++){
			XSSFRow xssfRow=xssfSheet.getRow(i);
			for (int j=xssfRow.getFirstCellNum();j<xssfRow.getLastCellNum()/2-1;j++){
				if (getValue(xssfRow.getCell(j))!=null){
					quota.setQuotaName((String) getValue(xssfRow.getCell(2*j)));
					quota.setWeight((Float) getValue(xssfRow.getCell(2*j+1)));
					quota.setParentId(2);
					resId=quotaService.findIdByName(quota);
					if (resId==null){
						quotaService.addQuotaByExcel(quota);
						resId=quotaService.findIdByName(quota);
					}


				}
			}
			quotaoptions.setQuotaId(resId.getId());
			quotaoptions.setScore((Float) getValue(xssfRow.getCell(xssfRow.getLastCellNum()-1)));
			quotaoptions.setOptionsName((String) getValue(xssfRow.getCell(xssfRow.getLastCellNum()-2)));
			quotaoptionsService.addQuotaOptionsByExcel(quotaoptions);
		}
		return 1;
	}

	/**
	 * excel返回类型判断
	 * @param cell
	 * @return
	 */
	private static Object getValue(Cell cell) {
		Object obj = null;
		switch (cell.getCellType()) {
			case XSSFCell.CELL_TYPE_BOOLEAN:
				obj = cell.getBooleanCellValue();
				break;
			case XSSFCell.CELL_TYPE_ERROR:
				obj = cell.getErrorCellValue();
				break;
			case XSSFCell.CELL_TYPE_NUMERIC:
				obj = (float)cell.getNumericCellValue();
				break;
			case XSSFCell.CELL_TYPE_STRING:
				obj = cell.getStringCellValue();
				break;
			default:
				break;
		}
		return obj;
	}
}
