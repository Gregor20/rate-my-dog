package com.Grigoriy.rate_my_dog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Grigoriy.rate_my_dog.model.Animal;
import com.Grigoriy.rate_my_dog.model.Cat;
import com.Grigoriy.rate_my_dog.model.Dog;
import com.Grigoriy.rate_my_dog.model.Review;

@Service
public class AnimalService {
	
	private final List<Animal> animalList = new ArrayList<>();
	
	public AnimalService() {
		animalList.add(new Dog(1, "Baco1", "/images/Baco1.jpg"));
		animalList.add(new Dog(2, "Baco2", "images/Baco2.jpg"));
		animalList.add(new Dog(3, "Baco3", "images/Baco3.jpg"));
		animalList.add(new Dog(4, "Baco4", "images/Baco4.jpg"));
		animalList.add(new Dog(5, "Baco5", "images/Baco5.jpg"));
		animalList.add(new Dog(6, "Baco6", "images/Baco6.jpg"));
		animalList.add(new Dog(7, "Baco7", "images/Baco7.jpg"));
		animalList.add(new Dog(8, "Baco8", "images/Baco8.jpg"));
		animalList.add(new Dog(9, "Baco9", "images/Baco9.jpg"));
		animalList.add(new Dog(10, "Baco10", "images/Baco10.jpg"));
		animalList.add(new Dog(11, "Baco11", "images/Baco11.jpg"));
		animalList.add(new Cat(12, "Marselle", "images/marselle.jpg"));		
		
		//Las imagenes estarán guardadas en el directorio src/main/resources/static/images/
	}
	
	public List<Animal> getAllAnimals() {
		return animalList;
	}

	public Animal getAnimalById(int id) {
	    return animalList.stream()
	        .filter(animal -> animal.getId() == id)
	        .findFirst()
	        .orElse(null);
	}
	
	public void saveReview(int animalId, Review review) {
	    // Aquí puedes guardar en base de datos o en una lista, por ejemplo:
	    Animal animal = getAnimalById(animalId);
	    if (animal != null) {
	        animal.getReviews().add(review);
	    }
	}

}
