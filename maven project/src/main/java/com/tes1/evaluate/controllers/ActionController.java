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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tes1.evaluate.domain.Action;
import com.tes1.evaluate.domain.ActionList;
import com.tes1.evaluate.domain.scaleAction;
import com.tes1.evaluate.service.ActionService;

import net.sf.json.JSONArray;

@Controller
public class ActionController {
	@Autowired
	private ActionService actionService;

	/**
	 * 查询用户的主菜单
	 */
	@RequestMapping("/findActionListByUserId")
	public ModelAndView findQuotaListByUserId(int userId, HttpServletRequest request) {
		List<Action> actionList = actionService.findActionListByUserId(userId);
		JSONArray jsonArray = JSONArray.fromObject(actionList);
		ModelAndView modelAndView = new ModelAndView("forward:/index.jsp");
		HttpSession session = request.getSession();
		session.setAttribute("action", jsonArray.toString());
		return modelAndView;
	}
	

	@RequestMapping("/findActionAction")
	// @ResponseBody
	public ModelAndView findAction(Action action, HttpServletRequest request) {
		ModelAndView modelAndView;
		List<Action> actions = actionService.findAction(action);
		/*
		 * HttpSession session=request.getSession(); //JSONArray json =
		 * JSONArray.fromObject(actions); session.setAttribute("actions",
		 * actions);
		 */
		if (actions != null) {
			modelAndView = new ModelAndView("forward:/moduls/scale/add.jsp");
			modelAndView.addObject("actions", actions);
		} else {
			modelAndView = new ModelAndView("loginfailed");
		}
		/* request.setAttribute("flag", "yes"); */
		return modelAndView;
		// return scales;
	}

	/**
	 * 查询二级菜单
	 */
	@RequestMapping("/findSecondActionAction")
	// @ResponseBody
	public ModelAndView findSecondAction(Action action, HttpServletRequest request) {
		ModelAndView modelAndView;
		List<Action> actions = actionService.findAction(action);
		String id = request.getParameter("id");
		System.out.println(id);
		if (actions != null) {
			modelAndView = new ModelAndView("forward:/findScaleByIdAction");
			modelAndView.addObject("actions", actions);
		} else {
			modelAndView = new ModelAndView("loginfailed");
		}
		/* request.setAttribute("flag", "yes"); */
		return modelAndView;
		// return scales;
	}

	/**
	 * 
	 */
	@RequestMapping("/AAActionAction")
	// @ResponseBody
	public ModelAndView AAfindAction(HttpServletRequest request) {
		ModelAndView modelAndView;
		List<scaleAction> actionsidLists = ((List<scaleAction>) request.getAttribute("actionidList"));
		System.out.println("tututututututututut" + actionsidLists);
		List<Action> actions = actionService.AAfindAction(actionsidLists);
		if (actions != null) {
			modelAndView = new ModelAndView("forward:/moduls/scale/detial.jsp");
			modelAndView.addObject("actions", actions);
		} else {
			modelAndView = new ModelAndView("loginfailed");
		}
		return modelAndView;
	}

	/**
	 * 分页
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/actionlistAction")
	@ResponseBody
	public ActionList obtainActionList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		int page = 0, rows = 10;

		String rowstr = request.getParameter("rows");
		if (rowstr != null && !rowstr.equals(""))
		{rows = Integer.parseInt(rowstr);}

		String pagestr = request.getParameter("page");
		if (pagestr != null && !pagestr.equals("")) {
			page = Integer.parseInt(pagestr);
			if (page > 0)
            {page = (page - 1) * rows;}
		}

		String filter = request.getParameter("filter");
		filter = filter == null ? "%%" : ("%" + filter + "%");


		int total = actionService.getActionListTotal(filter);

		ActionList actionList = new ActionList();
		if (total > 0) {

			List<Action> list = actionService.getActionList(page, rows, filter);
			actionList.setRows(list);
		}
		actionList.setTotal(total);

		return actionList;
	}
	/**
	 *
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/actionlistSearchAction")
	@ResponseBody
	public ActionList obtainActionSearchList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		int page = 0, rows = 10;

		String rowstr = request.getParameter("rows");
		if (rowstr != null && !rowstr.equals("")) {
            rows = Integer.parseInt(rowstr);
        }

		String pagestr = request.getParameter("page");
		if (pagestr != null && !pagestr.equals("")) {
			page = Integer.parseInt(pagestr);
			if (page > 0) {
                page = (page - 1) * rows;
            }
		}

		String filter = request.getParameter("filter");
		filter = filter == null ? "%%" : ("%" + filter + "%");

		//
		int total = actionService.getActionListTotal(filter);
		System.out.print(total);
		ActionList actionList = new ActionList();
		if (total > 0) {
			//
			List<Action> list = actionService.getActionList(page, rows, filter);
			actionList.setRows(list);
		}
		actionList.setTotal(total);

		return actionList;
	}


	@RequestMapping("/addActionAction")
	public ModelAndView addAction(@Valid Action action, HttpServletRequest request) {
		ModelAndView modelAndView;
		int ret = actionService.addAction(action);
		if (ret > 0) {
			modelAndView = new ModelAndView("forward:/moduls/action/actionManager.jsp");
		} else {
			modelAndView = new ModelAndView("forward:/error.jsp");
		}
		return modelAndView;
	}


	@RequestMapping("/findActionAction2")
	// @ResponseBody
	public ModelAndView findAction2(Action action, HttpServletRequest request) {
		ModelAndView modelAndView;
		List<Action> actions = actionService.findAction(action);
		/*
		 * HttpSession session=request.getSession(); //JSONArray json =
		 * JSONArray.fromObject(actions); session.setAttribute("actions",
		 * actions);
		 */
		if (actions != null) {
			modelAndView = new ModelAndView("forward:/moduls/action/add.jsp");
			modelAndView.addObject("actions", actions);
		} else {
			modelAndView = new ModelAndView("loginfailed");
		}
		/* request.setAttribute("flag", "yes"); */
		return modelAndView;
		// return scales;
	}


	@RequestMapping("/findActionAction3")
	// @ResponseBody
	public ModelAndView findAction3(Action action, HttpServletRequest request) {
		ModelAndView modelAndView;
		List<Action> actionss = actionService.findAction(action);
		/*
		 * HttpSession session=request.getSession(); //JSONArray json =
		 * JSONArray.fromObject(actions); session.setAttribute("actions",
		 * actions);
		 */
		if (actionss != null) {
			modelAndView = new ModelAndView("forward:/findActionByIdAction");
			modelAndView.addObject("actionss", actionss);
		} else {
			modelAndView = new ModelAndView("loginfailed");
		}
		/* request.setAttribute("flag", "yes"); */
		return modelAndView;
		// return scales;
	}


	@RequestMapping("/findActionByIdAction")
	// @ResponseBody
	public ModelAndView findActionById(Action action, HttpServletRequest request) {
		ModelAndView modelAndView;
		Action actions = actionService.findActionById(action);
		if (actions != null) {
			modelAndView = new ModelAndView("forward:/moduls/action/edit.jsp");
			modelAndView.addObject("actions", actions);
		} else {
			modelAndView = new ModelAndView("loginfailed");
		}
		/* request.setAttribute("flag", "yes"); */
		return modelAndView;
		// return scales;
	}

	/**
	 * 
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping("/deleteAction")
	@ResponseBody
	public Map<String, Object> deleteAction(String ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (ids == null || ids.equals("")) {
			map.put("success", 0);
			map.put("msg", "Del");
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
			int result = actionService.removeActionInfoByIds(list);
			map.put("success", result);
			map.put("msg", "删除成功");
			return map;
		}
	}

	/**
	 * 更新菜单
	 */
	@RequestMapping("/updateActionAction")
	public ModelAndView updateAction(Action action) {
		ModelAndView modelAndView;

		int ret = actionService.updateActionById(action);
		if (ret > 0) {
			String finish_Url = "/TCES1/moduls/action/actionManager.jsp";
			modelAndView = new ModelAndView("forward:/finish.jsp");
			modelAndView.addObject("finish_Url", finish_Url);
		} else {
			modelAndView = new ModelAndView("forward:/error.jsp");
		}
		return modelAndView;
	}
}
