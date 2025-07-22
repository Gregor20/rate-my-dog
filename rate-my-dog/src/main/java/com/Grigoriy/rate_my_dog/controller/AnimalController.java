package com.Grigoriy.rate_my_dog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @GetMapping("/animal/{id}")
    public String animalDetail(@PathVariable int id, Model model) {
        Animal animal = animalService.getAnimalById(id);
        if (animal == null) {
            return "redirect:/";
        }
        model.addAttribute("animal", animal);
        model.addAttribute("review", new Review()); // Objeto para bindear el formulario
        return "animal-detail";
    }

    // Procesar el formulario de review
    @PostMapping("/animal/{id}/review")
    public String submitReview(@PathVariable int id, @ModelAttribute Review review) {
        animalService.saveReview(id, review);
        return "redirect:/animal/" + id;
    }
}
