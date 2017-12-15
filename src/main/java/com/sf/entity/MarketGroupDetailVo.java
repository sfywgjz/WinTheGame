package com.sf.entity;

import java.util.List;

public class MarketGroupDetailVo {

	// 拼团Id
	private long groupId;
	
	// 拼团名称
	private String groupName;
	
	// 拼团开始时间范围
	private String groupStartDate;
	private String groupEndDate;

	// 当前团的状态
	private int status;
	
	// 专业市场Id
	private long marketId;
	
	// 专业市场名称
	private String marketName;

	// 当前团需要的总人数
	private int minPackages;
		
	// 重量限制范围
	private float minWeight;
	private float maxWeight;
	
	// 一个团的基本价格
	private float basePrice;
	
	// 物品的基本重量
	private float baseWeight;
	
	// 当前团已经有
	private int currentUserNumber;
	
	//参团人数
	private int groupLimit;

	// 参加当前团的用户Id列表
	private List<String> userIdList;
	
	private String descriptionOfGroup;
	
	public String getDescriptionOfGroup() {
		return descriptionOfGroup;
	}

	public void setDescriptionOfGroup(String descriptionOfGroup) {
		this.descriptionOfGroup = descriptionOfGroup;
	}

	public float getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(float basePrice) {
		this.basePrice = basePrice;
	}

	public float getBaseWeight() {
		return baseWeight;
	}

	public void setBaseWeight(float baseWeight) {
		this.baseWeight = baseWeight;
	}
	
	public List<String> getUserIdList() {
		return userIdList;
	}

	public void setUserIdList(List<String> userIdList) {
		this.userIdList = userIdList;
	}

	public int getGroupLimit() {
		return groupLimit;
	}

	public void setGroupLimit(int groupLimit) {
		this.groupLimit = groupLimit;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getMarketId() {
		return marketId;
	}

	public void setMarketId(long marketId) {
		this.marketId = marketId;
	}

	public String getMarketName() {
		return marketName;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public float getMinWeight() {
		return minWeight;
	}

	public void setMinWeight(float minWeight) {
		this.minWeight = minWeight;
	}

	public float getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(float maxWeight) {
		this.maxWeight = maxWeight;
	}

	public int getMinPackages() {
		return minPackages;
	}

	public void setMinPackages(int minPackages) {
		this.minPackages = minPackages;
	}

	public int getCurrentUserNumber() {
		return currentUserNumber;
	}

	public void setCurrentUserNumber(int currentUserNumber) {
		this.currentUserNumber = currentUserNumber;
	}

	public String getGroupStartDate() {
		return groupStartDate;
	}

	public void setGroupStartDate(String groupStartDate) {
		this.groupStartDate = groupStartDate;
	}

	public String getGroupEndDate() {
		return groupEndDate;
	}

	public void setGroupEndDate(String groupEndDate) {
		this.groupEndDate = groupEndDate;
	}
	
}	
