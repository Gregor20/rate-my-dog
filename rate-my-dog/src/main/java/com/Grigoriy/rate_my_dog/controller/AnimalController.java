package com.Grigoriy.rate_my_dog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Grigoriy.rate_my_dog.model.Animal;
import com.Grigoriy.rate_my_dog.model.Dog;
import com.Grigoriy.rate_my_dog.model.Review;
import com.Grigoriy.rate_my_dog.service.AnimalService;


@Controller
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping("/")
    public String index(Model model) {
        List<Animal> animals = animalService.getAllAnimals();
        model.addAttribute("animals", animals);
        return "index";
    }

    // Mostrar detalle y formulario para un animal
 // En tu AnimalController
    @GetMapping("/animal/{id}")
    public String animalDetail(@PathVariable int id, Model model) {
        // 1. Obtener el animal
        Animal animal = animalService.getAnimalById(id);
        
        // 2. Normalizar la ruta de la imagen (eliminar "/" inicial si existe)
        if (animal.getImage() != null && animal.getImage().startsWith("/")) {
            animal.setImage(animal.getImage().substring(1)); // Elimina la barra inicial
        }
        
        // 3. Añadir atributos al modelo
        model.addAttribute("animal", animal);
        model.addAttribute("review", new Review());
        
        return "animal-detail";
    }

    // Procesar el formulario de review
    @PostMapping("/animal/{id}/review")
    public String submitReview(
        @PathVariable int id,
        @ModelAttribute Review review,
        BindingResult bindingResult, // Necesario para validación
        Model model
    ) {
        // Validación manual (si no usas @Valid)
        if (review.getRating() < 1 || review.getRating() > 5) {
            bindingResult.rejectValue("rating", "error.rating", "La valoración debe ser entre 1 y 5");
        }
        
        if (bindingResult.hasErrors()) {
            model.addAttribute("animal", animalService.getAnimalById(id));
            return "animal-detail"; // Recarga la página mostrando errores
        }
        
        animalService.saveReview(id, review);
        return "redirect:/animal/" + id;
    }
}
