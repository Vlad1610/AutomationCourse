package ro.sit.course.course03;

public class Person {
    String name;
    byte age;
    boolean hungry;

    public void eat() { //metoda pentru a schimba starea de hungry in false
        hungry = false;
    }
}
