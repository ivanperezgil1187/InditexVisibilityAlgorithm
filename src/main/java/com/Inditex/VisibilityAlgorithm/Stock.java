package com.Inditex.VisibilityAlgorithm;

public class Stock {

	int sizeId;
	int quantity;

	public int getSizeId() {
		return sizeId;
	}

	public void setSizeId(int sizeId) {
		this.sizeId = sizeId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Stock() {
		super();
	}

	public Stock(int sizeId, int quantity) {
		super();
		this.sizeId = sizeId;
		this.quantity = quantity;
	}

}
