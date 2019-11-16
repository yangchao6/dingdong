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
	 * @param @param Mobile  用户名
	 * @param @param PassWord 密码
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
	 * @Title: tiemayiSubmit
	 * @Description: TODO(铁蚂蚁用户查询)
	 * @param @param UserId
	 * @param @param Token
	 * @param @return 参数
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value="tiemayiAccount",method=RequestMethod.POST)
	@ResponseBody
	public String tiemayiSubmit(String UserId,String Token) {
		String url = "https://api.damingduo.cn/api/Member/GetBindPlatformAccountList";
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("UserId", UserId);
		parameters.put("Token", Token);
		parameters.put("PlatId", "1");
		String result = Commonality.sendPost(url, parameters);
		System.out.println(result);
		return result;
	}
	
	
	@RequestMapping(value="tiemayiTaskList",method=RequestMethod.POST)
	@ResponseBody()
	public String tiemayiTaskList(String UserId,String Token,String TaskType,String AccountId) {
		String url = "https://api.damingduo.cn/api/Task/GetTaskList";
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("Page", "1");
		parameters.put("PageSize", "12");
		parameters.put("PlatId", "1");
		parameters.put("MaxAdvancePayMoney", "5000");
		String result = Commonality.sendPost(url, parameters);
		System.out.println(result);
		return result;
	}
	 
}
