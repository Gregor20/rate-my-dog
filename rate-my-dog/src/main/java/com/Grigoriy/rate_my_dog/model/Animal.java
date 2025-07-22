
package com.Grigoriy.rate_my_dog.model;

import java.util.ArrayList;
import java.util.List;

public class Animal {
	private int id;
	private String name;
	private String image;
	
	private List<Review> reviews = new ArrayList<>();
	
	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Animal(int id, String name, String image) {
		this.id = id;
		this.name = name;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}





