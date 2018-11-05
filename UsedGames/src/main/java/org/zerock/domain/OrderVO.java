package org.zerock.domain;

import java.util.Date;

public class OrderVO {

	private int mtIdx;
	private int dtIdx;
	private int quantity;
	private int gameIdx;
	private int sno;	
	private int memberIdx;
	private String addr;
	private int phone;
	private Date orderDate;
	
	public int getMtIdx() {
		return mtIdx;
	}
	public void setMtIdx(int mtIdx) {
		this.mtIdx = mtIdx;
	}
	public int getDtIdx() {
		return dtIdx;
	}
	public void setDtIdx(int dtIdx) {
		this.dtIdx = dtIdx;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getGameIdx() {
		return gameIdx;
	}
	public void setGameIdx(int gameIdx) {
		this.gameIdx = gameIdx;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public int getMemberIdx() {
		return memberIdx;
	}
	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
		
}
