package org.zerock.domain;

import java.util.Date;

public class OrderVO {

	private int idx;
	private int dtIdx;
	private int quantity;
	private int gameIdx;
	private int sno;	
	private int memberIdx;
	private String addr;
	private String gameTitle;
	private int price;
	private int phone;
	private int cost;
	private Date orderDate;
	private int paymentTypeIdx;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getGameTitle() {
		return gameTitle;
	}
	public void setGameTitle(String gameTitle) {
		this.gameTitle = gameTitle;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPaymentTypeIdx() {
		return paymentTypeIdx;
	}
	public void setPaymentTypeIdx(int paymentTypeIdx) {
		this.paymentTypeIdx = paymentTypeIdx;
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
