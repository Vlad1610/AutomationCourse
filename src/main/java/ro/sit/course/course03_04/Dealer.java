package ro.sit.course.course03_04;

public class Dealer {
    public static int nrOfCars;

    public int getNrOfCars() {
        return nrOfCars;
    }

    public void addCar() {
        nrOfCars++;
    }

    public static void deleteCar(){
        nrOfCars--;
    }



}