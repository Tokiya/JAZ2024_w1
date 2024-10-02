package org.example;

import org.example.model.*;

import java.util.ArrayList;
import java.util.List;


public class Main {


    public static void main(String[] args) {
        /**
         * Typy uogólnione (generyczne) zostały wprowadzone w JAVA 5
         * -> można wprowadzać ograniczenia typów, dla różnych pól i/lub metod w różnych klasach,
         * -> pozwalają to wychwycenie pewnych błędów związanych z polimorficznością
         *    już podczas kompilacji programu,
         */

        /**
         * spójrzmy na zachowanie tablicy
         */
        Dog[] dogs = {new Dog(), new Dog()};

        //addAnimal(dogs);

        /**
         *
         */

//        List list = new ArrayList();
//        list.add(1);
//        list.add(new Dog());
//        list.add(new Cat());
//        list.add("napis");

//        for (Object obj :
//                list) {
//                ((Dog) obj).makeNoise();
//        }

//        for (Object obj :
//                list) {
//            if(obj instanceof Dog)
//                ((Dog) obj).makeNoise();
//        }

        /**
         * polimorfizm jest ok dla typu bazowego, w sensie ArrayLista jest implementacją Listy
         */
//        List<Cat> cats = new ArrayList<Cat>();

        /**
         * ale to przestanie działać gdy parametr Typu nie jest zgodny:
         */
        //List<Animal> animals = new ArrayList<Cat>(); //typy zadeklarowane w pramatrach muszą być tutaj zgodne, nawet jeśli typa Cat dziedziczy po Animal

        /**
         * jako, że parametry typów muszą być zgodne,
         * przy deklaracji jak i przy inincjalizacji,
         * można stosować krótszy zapis, stosując parametr typu tylko przy deklaracji
         */
//        List<Cat> otherCats = new ArrayList<>();

        /**
         * kompilator zauważy błąd,
         * gdy jest niezgodność parametrów typu,
         * nawet przy próbie wywoływania metod
         */
//        addAnimal(cats);

        /* WILDCARDS */

        /**
         * Wildcardy wprowadzają większą swobodę wprowadzania parametrów typu
         */
        List<?> myList = new ArrayList<Animal>();
        myList = new ArrayList<Object>();
//        myList = new ArrayList<Integer>();
//        myList = new ArrayList<String>();
//        myList = new ArrayList<>();

        /**
         * Ale czy aby napewno...?
         * spróbuj dodać jakiś element do tej kolekcji
         */
//        myList.add(new Object());
//        myList.add(null)
//        for (Object obj :  myList) {
//            System.out.println(obj);
//        }

        /**
         * można użyć słowa kluczowego extends,
         * aby wprowadzić pewne ograniczenia,
         * oraz spowodować aby kolekcja obiektów była bardziej użyteczna
         */
//
//        List<? extends Animal>  animals = new ArrayList<Animal>();
//        List<? extends Animal> catsList = new ArrayList<Cat>();
//        List<? extends Animal> dogsList = new ArrayList<Dog>();
//        List<? extends Animal> terriers = new ArrayList<Terrier>();
//        List<? extends Animal> otherLIst = new ArrayList<Object>(); // błąd kompilacji
//        List<? extends Animal> otherLIst = new ArrayList<String>(); // błąd kompilacji
        /**
         * ale znowu problem - zadeklarowany w powyższy sposób są "read-only" :(
         */
//        animals.add(new Dog());
//        animals.add(new Animal());
//        catsList.add(new Cat());
        /**
        * Gdzie wtedy jest sens używania taka składnia?
         * Najczęściej takie konstrukcje śą wykorzystywane przy deklarowaniu metod,
         * w których definicjach wymagamy kolkcje tylko do odczytu.
        */
//        var animals2= createList();
//        tameAnimals(List.of(new Cat(), new Dog(), new Dog()));

        /**
         * Jeśli potrzebujemy mieć możliwość, dodawania elementów do kolekcji
         * należy użyć słowa kluczowego super
         */
//        List<? super Animal>  otherAnimals = new ArrayList<Animal>();
//        List<? super Cat> otherCatsList = new ArrayList<Animal>();
//        List<? super Dog> otherDogsList = new ArrayList<Dog>();
//        List<? super Terrier> otherTerriers = new ArrayList<Terrier>();
        /**
         *
         */

//        otherTerriers.add(new Terrier());
//        otherAnimals.add(new Dog());
//        otherAnimals.add(new Cat());
//        otherAnimals.add(new Terrier());
//        otherCatsList.add(new Manx());
        //otherTerriers.add(new Dog()); // blad

        /**
         *
         */
//        NoiseRecorder<? extends Cat, ? extends Audio> catRecorder= new NoiseRecorder<>();
//        catRecorder.add(new Manx());
//
//        NoiseRecorder<? super Cat, ? extends Audio> catRecorder2= new NoiseRecorder<>();
//        catRecorder.add(new Manx());
//        catRecorder.add(new Terrier());

//        NoiseRecorder<Cat, Audio> recorder = new NoiseRecorder<>();
//        recorder.recordOn(new Tape());
    }

    static List<? extends Animal> createList(){
        return List.of(new Cat(), new Dog(), new Dog());
    }
    static void tameAnimals(List<? extends Animal> animals){
        for (Animal animal : animals) {
            animal.tame();
        }
    }

    static void addAnimal(List<Animal> animals){
        animals.add(new Dog());
        animals.add(new Cat());
    }



    static void addAnimal(Animal[] animals){
        animals[0] = new Dog();
        animals[1] = new Cat(); //ArrayStoreException
    }

    static <T> void print(T parameter){
        System.out.println(parameter);
    }

    static <T extends Animal> void addGenericAnimal(List<T> list){
        list.add((T) new Dog());
        list.add((T) new Cat());

        for (Animal animal :
                list) {
            animal.makeNoise();
        }

        for (T animal :
                list) {
            animal.makeNoise();
        }
    }
}