package ro.sit.homework.Homework03.Library;

public class Author {
    String name;
    String email;

    public Author(String name, String email) {
        this.name = name;
        this.email = email;
    }

    String getName() {return this.name;}
    String getEmail() {return this.email;}
}
