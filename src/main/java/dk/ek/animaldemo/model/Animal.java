package dk.ek.animaldemo.model;

import java.util.Objects;

public class Animal {
    private long id;
    private String name;
    private Species species;
    private Gender gender;

    public Animal(String name, Species species, Gender gender) {
        this.name = name;
        this.species = species;
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return id == animal.id && Objects.equals(name, animal.name) && species == animal.species && gender == animal.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, species, gender);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", species=" + species +
                ", gender=" + gender +
                '}';
    }
}
