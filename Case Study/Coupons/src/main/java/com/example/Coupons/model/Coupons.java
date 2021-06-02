package com.example.Coupons.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="coupons")
public class Coupons 
{
	@Id
	public String id;
	public String storeName;
	public String storePhotoUrl;
	public String offPercentage;
	public String description;
	public String category;
	public String subcategory;
	public String date;
	public String time;
	public String couponCode;
	public String couponLink;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStorePhotoUrl() {
		return storePhotoUrl;
	}
	public void setStorePhotoUrl(String storePhotoUrl) {
		this.storePhotoUrl = storePhotoUrl;
	}
	public String getOffPercentage() {
		return offPercentage;
	}
	public void setOffPercentage(String offPercentage) {
		this.offPercentage = offPercentage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public String getCouponLink() {
		return couponLink;
	}
	public void setCouponLink(String couponLink) {
		this.couponLink = couponLink;
	}
	public Coupons(String id, String storeName, String storePhotoUrl, String offPercentage, String description,
			String category, String subcategory, String date, String time, String couponCode, String couponLink) {
		super();
		this.id = id;
		this.storeName = storeName;
		this.storePhotoUrl = storePhotoUrl;
		this.offPercentage = offPercentage;
		this.description = description;
		this.category = category;
		this.subcategory = subcategory;
		this.date = date;
		this.time = time;
		this.couponCode = couponCode;
		this.couponLink = couponLink;
	}
	public Coupons() {
		super();
		// TODO Auto-generated constructor stub
	}
}