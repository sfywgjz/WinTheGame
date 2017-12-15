package com.sf.controller;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.sf.entity.MarketGroupDetailVo;
import com.sf.mapper.MarketGroupDetailMapper;

@Controller
public class MarketGroupDetailController {
	
	@Autowired
	private MarketGroupDetailMapper marketGroupDetailMapper;

	@ResponseBody
	@RequestMapping(value = "getMarketGroupDetailByGroupId.html", produces = "text/html;charset=UTF-8")
	public String getMarketGroupDetail(@RequestParam(value="groupId", required=true)long groupId){
		MarketGroupDetailVo marketGroupDetail = marketGroupDetailMapper.getMarketGroupDetailByGroupId(groupId);
		if(null != marketGroupDetail){
			marketGroupDetail.setCurrentUserNumber(marketGroupDetail.getUserIdList().size());
			return JSONObject.toJSONString(marketGroupDetail);	
		}
		return "{\"msg\":\"请求参数错误！\"}";
	}
}
