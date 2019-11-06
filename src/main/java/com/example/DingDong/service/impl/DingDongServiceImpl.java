package com.example.DingDong.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DingDong.dao.DingDongDao;
import com.example.DingDong.service.DingDongService;

@Service
public class DingDongServiceImpl implements DingDongService{

	@Autowired
	private DingDongDao dao;
	
}
