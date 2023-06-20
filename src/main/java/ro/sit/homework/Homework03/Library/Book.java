package ro.sit.homework.Homework03.Library;

public class Book {
    String name;
    int year;
    Author author;
    double price;

    public Book(String name, int year, Author author, double price) {
        this.name = name;
        this.year = year;
        this.author = author;
        this.price = price;
    }
    String getName() {return this.name;}
    Author getAuthor() {return this.author;}
    double getPrice() {return this.price;}
    int getYear() {return this.year;}
}
