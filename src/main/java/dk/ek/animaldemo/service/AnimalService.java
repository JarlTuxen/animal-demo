package dk.ek.animaldemo.service;

import dk.ek.animaldemo.model.Animal;
import dk.ek.animaldemo.model.Gender;
import dk.ek.animaldemo.model.Species;
import dk.ek.animaldemo.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository){
        this.animalRepository = animalRepository;
    }

    public List<Animal> getAnimals(Species species, Gender gender){
        if (species == null && gender == null){
            return animalRepository.findAll();
        }

        return animalRepository.findByFilters(gender, species);

    }

    public Animal getAnimalById(long id){
        return animalRepository.findById(id);
    }

    public Animal createAnimal(Animal animal){
        return animalRepository.save(animal);
    }

}
