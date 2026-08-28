package dk.ek.animaldemo.repository;

import dk.ek.animaldemo.model.Animal;
import dk.ek.animaldemo.model.Gender;
import dk.ek.animaldemo.model.Species;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AnimalRepository {
    private final List<Animal> animals = new ArrayList<>();
    private long nextId = 1;

    public AnimalRepository() {
        populate();
    }

    public Animal save(Animal animal) {
        animal.setId(nextId++);
        animals.add(animal);
        return animal;
    }

    public List<Animal> findAll() {
        return new ArrayList<>(animals); //animals i repository kan ikke ændres udenfor repository
    }

    public Animal findById(long id) {
        for (Animal animal : animals) {
            if(animal.getId() == id)
                return animal;
        }
        return null;
    }

    public List<Animal> findByFilters(Gender gender, Species species){
        List<Animal> foundAnimals = new ArrayList<>();
        //find animals, der matcher gender og species
        return foundAnimals;
    }

    private void populate() {
        //initialiser repository med dyr

    }
}
