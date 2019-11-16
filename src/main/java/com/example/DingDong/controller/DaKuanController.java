package com.example.DingDong.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DaKuanController {

	@RequestMapping(value = "/addres")
	@ResponseBody
	public String addBill(HttpSession session,HttpServletRequest request) throws UnknownHostException {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getHeader("Proxy-Client-IP");
	        }
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getHeader("WL-Proxy-Client-IP");
	        }
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getHeader("HTTP_CLIENT_IP");
	        }
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
	        }
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getRemoteAddr();
	        }
	    } else if (ip.length() > 15) {
	        String[] ips = ip.split(",");
	        for (int index = 0; index < ips.length; index++) {
	            String strIp = (String) ips[index];
	            if (!("unknown".equalsIgnoreCase(strIp))) {
	                ip = strIp;
	                break;
	            }
	        }
	    }
		System.out.println(ip);
		InetAddress address = InetAddress.getLocalHost();
		return address.getHostAddress(); //返回IP地址
	}
	
}
