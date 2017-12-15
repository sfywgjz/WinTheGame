package com.sf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sf.entity.JoinGroupInfoVo;
import com.sf.mapper.JoinGroupInfoMapper;

@Controller
public class JoinGroupController {
	
	@Autowired
	JoinGroupInfoMapper joinGroupInfoMapper;
	
	@ResponseBody
	@RequestMapping(value = "joinGroup.html", produces = "text/html;charset=UTF-8")
	private String joinGroup(@RequestParam(value="userId", required=true)String userId, 
			@RequestParam(value="name", required=true)String userName, 
			@RequestParam(value="phone", required=true)String userMobile,
			@RequestParam(value="areaInfo", required=true) String fromCity, 
			@RequestParam(value="detailAddress", required=true) String fromDetailAddress, 
			@RequestParam(value="mailNumber", required=true) int totalPkgs,	
			@RequestParam(value="weights", required=true) float avgWeith,
			@RequestParam(value="groupId", required=true) long groupId) {
		
		JoinGroupInfoVo joinGroupInfo = new JoinGroupInfoVo();
		joinGroupInfo.setUserId(userId);
		joinGroupInfo.setUserName(userName);
		joinGroupInfo.setUserMobile(userMobile);
		joinGroupInfo.setAvgWeith(avgWeith);
		joinGroupInfo.setFromCity(fromCity);
		joinGroupInfo.setFromDetailAddress(fromDetailAddress);
		
		int status = joinGroupInfoMapper.joinGroup(joinGroupInfo);
		
		if(status == 1){
			return "拼团成功！";
		}else{
			return "拼团失败！";
		}
	}
}
