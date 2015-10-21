package com.example.cityguide;

import java.io.Serializable;


public class PlacesRegis implements Serializable {
	private String pName,pAddress,pContact,pEmail,pDesc,pCategory,pWebURL;
	private double rating;
	private byte[] pimage;
	public byte[] getPimage() {
		return pimage;
	}
	public void setPimage(byte[] pimage) {
		this.pimage = pimage;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	
	public String getpAddress() {
		return pAddress;
	}
	public void setpAddress(String pAddress) {
		this.pAddress = pAddress;
	}
	public String getpContact() {
		return pContact;
	}
	public void setpContact(String pContact) {
		this.pContact = pContact;
	}
	public String getpEmail() {
		return pEmail;
	}
	public void setpEmail(String pEmail) {
		this.pEmail = pEmail;
	}
	public String getpDesc() {
		return pDesc;
	}
	public void setpDesc(String pDesc) {
		this.pDesc = pDesc;
	}
	public String getpCategory() {
		return pCategory;
	}
	public void setpCategory(String pCategory) {
		this.pCategory = pCategory;
	}
	public String getpWebURL() {
		return pWebURL;
	}
	public void setpWebURL(String pWebURL) {
		this.pWebURL = pWebURL;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	
}
