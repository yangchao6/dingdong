package com.example.DingDong.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.DingDong.commonality.Commonality;

/**
 * 
 * @ClassName: PuTongController
 * @Description: TODO(普通平台)
 * @author HUAWEI
 * @date 2019年11月10日
 *
 */
@Controller
public class PuTongController {
	
	@RequestMapping(value = "tiemayi")
	public ModelAndView tiemayiVime() {
		ModelAndView ma = new ModelAndView();
		ma.setViewName("html/teimayi.html");
		return ma;
	}
	
	/**
	 * 
	 * @Title: tiemayiLogin
	 * @Description: TODO(铁蚂蚁登陆)
	 * @param @param Mobile
	 * @param @param PassWord
	 * @param @return 参数
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value="tiemayiLogin",method=RequestMethod.POST)
	@ResponseBody
	public String tiemayiLogin(String Mobile,String PassWord){
		String url = "https://api.damingduo.cn/api/Login/LoginByMobile";
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("Mobile", Mobile);
		parameters.put("PassWord", PassWord);
		parameters.put("client_id", "BF7817FD2E8651B6FC4C102F607EA1CD");
		parameters.put("client_secret", "AFB5D053C0D6EE9E9B2796333AB2EAC8");
		String result = Commonality.sendPost(url, parameters);
		System.out.println(result);
		return result;
	}
	
	/**
	 * 
	 * @Title: tiemayiAccount
	 * @Description: TODO(铁蚂蚁用户查询)
	 * @param @param UserId
	 * @param @param Token
	 * @param @return 参数
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value="tiemayiAccount",method=RequestMethod.POST)
	@ResponseBody
	public String tiemayiAccount(String UserId,String Token) {
		String url = "https://api.damingduo.cn/api/Member/GetBindPlatformAccountList";
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("UserId", UserId);
		parameters.put("Token", Token);
		parameters.put("PlatId", "1");
		String result = Commonality.sendPost(url, parameters);
		System.out.println(result);
		return result;
	}
	
	/**
	 * 
	 * @Title: tiemayiTaskList
	 * @Description: TODO(查询是否有单子)
	 * @param @param UserId
	 * @param @param Token
	 * @param @param TaskType
	 * @param @param AccountId
	 * @param @return 参数
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value="tiemayiTaskList",method=RequestMethod.POST)
	@ResponseBody()
	public String tiemayiTaskList(String UserId,String Token,String TaskType,String AccountId) {
		String url = "https://api.damingduo.cn/api/Task/GetTaskList";
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("UserId", UserId);
		parameters.put("Token", Token);
		parameters.put("TaskType", TaskType);
		parameters.put("AccountId", AccountId);
		parameters.put("Page", "1");
		parameters.put("PageSize", "12");
		parameters.put("PlatId", "1");
		parameters.put("MaxAdvancePayMoney", "5000");
		String result = Commonality.sendPost(url, parameters);
		System.out.println(result);
		return result;
	}
	
	/**
	 * 
	 * @Title: tiemayiSubmit
	 * @Description: TODO(铁蚂蚁接单)
	 * @param @param UserId
	 * @param @param Token
	 * @param @param TaskListNo
	 * @param @param AccountId
	 * @param @return 参数
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value="tiemayiSubmit",method=RequestMethod.POST)
	@ResponseBody()
	public String tiemayiSubmit(String UserId,String Token,String TaskListNo,String AccountId) {
		String url = "https://api.damingduo.cn/api/Task/UserDetermineTask";
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("UserId", UserId);
		parameters.put("Token", Token);
		parameters.put("TaskListNo", TaskListNo);
		parameters.put("AccountId", AccountId);
		String result = Commonality.sendPost(url, parameters);
		System.out.println(result);
		return result;
	}
	 
}
