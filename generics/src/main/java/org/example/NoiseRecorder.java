package org.example;

import java.util.ArrayList;
import java.util.List;

public class NoiseRecorder<T> {
//    public class NoiseRecorder<T extends Animal> {
//    public class NoiseRecorder<TNoise extends IMakeNoise> {
//    public class NoiseRecorder<T extends Animal, TNoise extends IMakeNoise> {

    T animal;
    List<T> animals = new ArrayList<>();

    public void add(T animal){
        //animal.tame();
        animals.add(animal);
    }

    public T getByIndex(int index){
        return animals.get(index);
    }

//
//    TNoise noise;
//    <TMedium extends SavingMedium> void recordOn(TMedium medium){
//        medium.save(noise);
//
//    }

}
