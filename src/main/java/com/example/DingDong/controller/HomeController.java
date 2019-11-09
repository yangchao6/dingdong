package com.example.DingDong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.Api;

/**
 * 
 * @ClassName: HomeController
 * @Description: TODO(通过访问这个类的请求进入首页)
 * @author HUAWEI
 * @date 2019年10月29日
 *
 */
@Controller
@Api(value = "SayController|一个用来测试swagger注解的控制器")
public class HomeController {

	@RequestMapping(value = "/")
	public ModelAndView homePage() {
		ModelAndView ma = new ModelAndView();
		ma.setViewName("html/index.html");
		return ma;
	}

}