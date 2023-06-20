package ro.sit.homework.Homework03.Library;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.sql.SQLOutput;

public class Library {
    public static void main(String[] args) {
        Author author = new Author("Mircea Eliade", "mircea.eliade@gmail.com");
        Book book = new Book("Maytrei ", 1933, author, 12.50);
        System.out.println("Book " + book.getName() + "(" + book.getPrice() + " RON), by " + author.getName() +
                ", published in " + book.getYear());
    }
}
