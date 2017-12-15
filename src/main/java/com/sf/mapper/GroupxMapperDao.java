package com.sf.mapper;


import org.apache.ibatis.annotations.Param;

import com.sf.entity.GroupxModel;

public interface GroupxMapperDao {
	
	//设置团过期
	public abstract int updateEndingMarket();
	
}