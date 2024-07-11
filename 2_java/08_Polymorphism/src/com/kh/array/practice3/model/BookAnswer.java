package com.kh.array.practice3.model;

public class BookAnswer {
	
	private String title;
	private boolean coupon;
	private int accessAge;
	
	public BookAnswer(String title, boolean coupon, int accessAge) {
		super();
		this.title = title;
		this.coupon = coupon;
		this.accessAge = accessAge;
	}

	public BookAnswer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isCoupon() {
		return coupon;
	}

	public void setCoupon(boolean coupon) {
		this.coupon = coupon;
	}

	public int getAccessAge() {
		return accessAge;
	}

	public void setAccessAge(int accessAge) {
		this.accessAge = accessAge;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", coupon=" + coupon + ", accessAge=" + accessAge + "]";
	}
	

}
