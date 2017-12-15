package com.sf.entity;

import java.util.Date;

public class GroupxModel {
	private Long id;
	private Integer market_id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getMarket_id() {
		return market_id;
	}
	public void setMarket_id(Integer market_id) {
		this.market_id = market_id;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public Date getBtm() {
		return btm;
	}
	public void setBtm(Date btm) {
		this.btm = btm;
	}
	public Date getEtm() {
		return etm;
	}
	public void setEtm(Date etm) {
		this.etm = etm;
	}
	public Date getReal_etm() {
		return real_etm;
	}
	public void setReal_etm(Date real_etm) {
		this.real_etm = real_etm;
	}
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
	public Date getInsert_tm() {
		return insert_tm;
	}
	public void setInsert_tm(Date insert_tm) {
		this.insert_tm = insert_tm;
	}
	private String gname;
	private Date btm;
	private Date etm;
	private Date real_etm;
	private Byte status;
	private Date insert_tm;
}
