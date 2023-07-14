package ro.sit.homework.Homework04;

import java.util.HashMap;
import java.util.Map;

public class PetHotel {
    public HashMap<Room, Dog> dogHashMap;

    public PetHotel(HashMap<Room, Dog> dogHashMap) {
        this.dogHashMap = dogHashMap;
    }

    public void showHotelMap(HashMap<Room, Dog> hotelMap) {
        for(Room r: hotelMap.keySet()) {
            System.out.println(r.getRoomNr());
        }
        for(Dog d: hotelMap.values()) {
            System.out.println(d.getNume());
        }
    }
    public  void showHotelMap2(HashMap<Room, Dog> h){
        for (Map.Entry<Room, Dog> entry : h.entrySet()){
            System.out.println(entry.getKey().getRoomNr() + " " + entry.getValue().getNume());
        }
    }

    public void addNewDog(HashMap<Room, Dog> h, Room r, Dog d) {
        h.put(r, d);
    }

    public void deleteRoom(HashMap<Room, Dog> h, Room r) {
        h.remove(r);
    }
    public static void main(String[] args) {
        Dog dog1 = new Dog(1, "Bobby", "Pichinez");
        Dog dog2 = new Dog(2, "Leon", "Labrador");
        Dog dog3 = new Dog(3, "Pablo", "Poodle");
        Dog dog4 = new Dog(4, "Milo", "Bulldog");
        Dog dog5 = new Dog(5, "Rocky", "Poodle");
        Dog dog6 = new Dog(6, "Peter", "German Shepard");
        Room room1 = new Room(1);
        Room room2 = new Room(2);
        Room room3 = new Room(3);
        Room room4 = new Room(4);
        Room room5 = new Room(5);
        Room room6 = new Room(6);

        HashMap<Room, Dog> dogHashMap1 = new HashMap<>();
        dogHashMap1.put(room1, dog1);
        dogHashMap1.put(room2, dog2);
        dogHashMap1.put(room3, dog3);
        dogHashMap1.put(room4, dog4);
        dogHashMap1.put(room5, dog5);

        PetHotel petHotel = new PetHotel(dogHashMap1);
        petHotel.showHotelMap(dogHashMap1);
        System.out.println();
        petHotel.showHotelMap2(dogHashMap1);
        System.out.println();
        petHotel.addNewDog(dogHashMap1, room6, dog6);
        petHotel.showHotelMap2(dogHashMap1);
        System.out.println();
        petHotel.deleteRoom(dogHashMap1, room3);
        petHotel.showHotelMap2(dogHashMap1);
        System.out.println();
    }




}
