package io.altar.jseproject.model;

import java.util.ArrayList;

public class Product extends Entity{
	
	public ArrayList<Long> shelfIds = new ArrayList<Long>();
	private float price;
	private float IVA;
	private float PVP;
	
	
	public Product (float price, float IVA) {
		super();
		this.price = price;
		this.IVA = IVA;
		this.PVP = (price + (price * (IVA/100)));
	}

	

	public ArrayList<Long> getShelfs() {
		return shelfIds;
	}


	public void setShelfs(ArrayList<Long> shelfs) {
		this.shelfIds = shelfs;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}



	public float getIVA() {
		return IVA;
	}


	public void setIVA(float iVA) {
		IVA = iVA;
	}


	public float getPVP() {
		return PVP;
	}


	@Override
	public String toString() {
		return "Product id: " + id + ", price: " + price + ", IVA: " + IVA + ", PVP: " + PVP + ", Shelfs: " + shelfIds;
	}

	
	

}