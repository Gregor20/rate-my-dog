package com.Grigoriy.rate_my_dog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Grigoriy.rate_my_dog.model.Dog;

@Service
public class DogService {
	
	private final List<Dog> dogList = new ArrayList<>();
	
	public DogService() {
		dogList.add(new Dog(1, "Saltinbanki", "/images/saltamontes.jpg")); // Aquí puedes poner la URL de la imagen"));
		//dogList.add(new Dog(2, "Max", "/images/max.jpg"));
		//dogList.add(new Dog(3, "Bella", "/images/bella.jpg"));
		
		//Las imagenes estarán guardadas en el directorio src/main/resources/static/images/
	}
	
	public List<Dog> getAllDogs() {
		return dogList;
	}

	public Dog getDogById(int id) {
		return dogList.stream()
				.filter(dog -> dog.getId() == id) // Filtra la lista de perros por ID con lambda
				.findFirst() 					  // Obtiene el primer perro que coincida con el ID
				.orElse(null); 					  // Si no se encuentra, devuelve null
	}
}
