package ro.sit.course.course03_04;

import java.awt.*;

public class Course04 {
    public static void main(String[] args) {
        CarBrands carBrand = new CarBrands("DACIA","LOGAN","Benzina");
        System.out.println("Brand:"+ carBrand.getBrand());

        Car car1 = new Car(carBrand, Color.BLUE);

        Car car2 = new Car(300f,  8,"AUDI", "A6","D", Color.RED);
        car2.accelerate(10);
        System.out.println(car2);
        System.out.println("Add fuel...");
        car2.setFuelLevel(80);
        car2.accelerate(20);
        System.out.println(car2);
        car2.accelerate(10);
        System.out.println(car2);

        Dealer florinD= new Dealer();
        florinD.addCar();
        Dealer cristinaD = new Dealer();
        cristinaD.addCar();
        cristinaD.addCar();
        //call static method
        Dealer.deleteCar();
        Dealer.nrOfCars++;

        System.out.println("Number of cars Florin:"+florinD.getNrOfCars());
        System.out.println("Number of cars Cristina:"+cristinaD.getNrOfCars());

        Double nr=Double.parseDouble("56");
        System.out.println(nr);

//      Inheritance

        Shape shape = new Shape(Color.GRAY);
        shape.draw();
        Circle circle = new Circle(Color.BLUE,5);
        circle.draw();
        circle.protectedMthCircle();
        Triangle triangle = new Triangle(Color.CYAN);
        triangle.draw();
        triangle.draw(6,8,10);
        //Polymorphism
        Shape shape3 = new Shape(Color.RED);
        Shape shape1 = new Circle(Color.BLUE, 2);
        Shape shape2 = new Triangle(Color.BLACK);
        Shape shape4 = new EqTriangle(Color.CYAN);;

        System.out.println("Polymorphism");
        shape1.draw();
        shape2.draw();
        triangle.flipHorizontal();
        shape4.draw();

//        class activity inheritance
        Teacher teacher = new Teacher("Ion Popescu",(byte) 50,"m","1234567891234","123","Info");
        Student student = new Student("Vasile Ionescu",(byte) 12,"F","2234767891234","12367","Info");
        System.out.println(teacher);
        System.out.println(student);
    }
}