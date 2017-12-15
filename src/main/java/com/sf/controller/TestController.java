package com.sf.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sf.entity.TestObj;
import com.sf.mapper.TestMapper;
import com.sf.service.TestService;


@Controller
public class TestController {
	
	@Autowired
	private TestMapper testMapper;
	
	@Autowired
	private TestService testService;

	private org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping("test.html")
	public ModelAndView addApp(){

		
		TestObj testObj  = testMapper.getTestData();
		LOGGER.info(testObj.getUserName());
		LOGGER.info(testService.getServiceString());
		return new ModelAndView("test");
	}
}
