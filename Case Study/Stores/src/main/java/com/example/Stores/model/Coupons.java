package com.example.Stores.model;

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
	public String shortDescription;
	public String category;
	public String subcategory;
	public String detailDescription;
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
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
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
	public String getDetailDescription() {
		return detailDescription;
	}
	public void setDetailDescription(String detailDescription) {
		this.detailDescription = detailDescription;
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
	public Coupons(String id, String storeName, String storePhotoUrl, String offPercentage, String shortDescription,
			String category, String subcategory, String detailDescription, String date, String time, String couponCode,
			String couponLink) {
		super();
		this.id = id;
		this.storeName = storeName;
		this.storePhotoUrl = storePhotoUrl;
		this.offPercentage = offPercentage;
		this.shortDescription = shortDescription;
		this.category = category;
		this.subcategory = subcategory;
		this.detailDescription = detailDescription;
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