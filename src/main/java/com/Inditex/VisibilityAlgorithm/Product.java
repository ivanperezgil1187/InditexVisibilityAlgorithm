package com.Inditex.VisibilityAlgorithm;

public class Product {

	int id;
	int sequence;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public Product() {
		super();
	}

	public Product(int id, int sequence) {
		super();
		this.id = id;
		this.sequence = sequence;
	}
}
