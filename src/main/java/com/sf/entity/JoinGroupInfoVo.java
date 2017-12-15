package com.sf.entity;

public class JoinGroupInfoVo {
	private String userId;
	private String userName;
	private String userMobile;
	private String fromCity;
	private String fromDetailAddress;
	private int totalPkgs;
	private float avgWeith;
	private long groupId;
	
	public long getGroupId() {
		return groupId;
	}
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public String getFromDetailAddress() {
		return fromDetailAddress;
	}
	public void setFromDetailAddress(String fromDetailAddress) {
		this.fromDetailAddress = fromDetailAddress;
	}
	public int getTotalPkgs() {
		return totalPkgs;
	}
	public void setTotalPkgs(int totalPkgs) {
		this.totalPkgs = totalPkgs;
	}
	public float getAvgWeith() {
		return avgWeith;
	}
	public void setAvgWeith(float avgWeith) {
		this.avgWeith = avgWeith;
	}
}
