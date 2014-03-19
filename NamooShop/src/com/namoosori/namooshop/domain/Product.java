package com.namoosori.namooshop.domain;

public class Product {
	//
	private int serialNo;
	private String name;
	private int price;
	private int like; // 선호도 (0~5)
	
	public Product(int serialNo, String name, int price, int like) {
		//
		this.serialNo = serialNo;
		this.name = name;
		this.price = price;
		this.like = like;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}
	
	public String getStar(int like) {
		String star = "";
		for(int i = 0; i < like ; i++) {
			star += "★";
		}
		for(int i = 0; i < 5-like ; i++) {
			star += "☆";
		} 
		return star;
	}
}
