package com.example.Stores.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection="stores")
public class Stores 
{
	@Id
	private String id;
	private String name;
	private String availableOffers;
	private String photo;
	
	public Stores(String id, String name, String availableOffers, String photo) {
		super();
		this.id = id;
		this.name = name;
		this.availableOffers = availableOffers;
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "Stores [id=" + id + ", name=" + name + ", availableOffers=" + availableOffers + ", photo=" + photo
				+ "]";
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAvailableOffers() {
		return availableOffers;
	}
	public void setAvailableOffers(String availableOffers) {
		this.availableOffers = availableOffers;
	}
	
	public Stores() {
		super();
	}
	
	
}
