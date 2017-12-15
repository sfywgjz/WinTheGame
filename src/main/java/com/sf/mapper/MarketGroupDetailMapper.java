package com.sf.mapper;

import org.apache.ibatis.annotations.Param;

import com.sf.entity.MarketGroupDetailVo;

public interface MarketGroupDetailMapper {
	MarketGroupDetailVo getMarketGroupDetailByGroupId(@Param("groupId")long groupId);
}
