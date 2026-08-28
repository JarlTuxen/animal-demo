package dk.ek.animaldemo.controller;

import dk.ek.animaldemo.model.Animal;
import dk.ek.animaldemo.service.AnimalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/animalshelter")
public class AnimalController {

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> getAnimal(@PathVariable long id){
        Animal animal = animalService.getAnimalById(id);
        return animal == null ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(animal);
    }

    @PostMapping
    public ResponseEntity<Animal> createAnimal(@RequestBody Animal animal){
        Animal createdAnimal = animalService.createAnimal(animal);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAnimal);
    }

}
