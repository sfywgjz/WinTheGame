package com.sf.mapper;

import org.apache.ibatis.annotations.Param;

import com.sf.entity.JoinGroupInfoVo;

public interface JoinGroupInfoMapper {
	
	int joinGroup(@Param("joinGroupInfo")JoinGroupInfoVo joinGroupInfo);
}
