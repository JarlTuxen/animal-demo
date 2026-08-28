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
        for (Animal animal : animals) {
            boolean matchesSpecies = (species == null) || (species == animal.getSpecies());
            boolean matchesGender = (gender == null) || (gender == animal.getGender());
            if (matchesSpecies && matchesGender) {
                foundAnimals.add(animal);
            }
        }
        return foundAnimals;
    }

    private void populate() {
        //initialiser repository med dyr - fra ChatGPT
        save(new Animal("Nuller", Species.BIRD, Gender.MALE));
        save(new Animal("Mille", Species.CAT, Gender.FEMALE));
        save(new Animal("Rex", Species.DOG, Gender.MALE));
        save(new Animal("Luna", Species.CAT, Gender.FEMALE));
        save(new Animal("Pjuske", Species.RODENT, Gender.UNKNOWN));
        save(new Animal("Nemo", Species.FISH, Gender.MALE));
        save(new Animal("Bella", Species.DOG, Gender.FEMALE));
        save(new Animal("Dino", Species.DINOSAUR, Gender.UNKNOWN));
        save(new Animal("Kiki", Species.BIRD, Gender.FEMALE));
        save(new Animal("Bølle", Species.OTHER, Gender.MALE));
    }
}
