package ro.sit.homework.Homework04;

public class Student {
    private String nume;
    private int media;

    public Student(String nume, int media) {
        this.nume = nume;
        this.media = media;
    }

    public String getNume() {
        return nume;
    }

    public int getMedia() {
        return media;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setMedia(int media) {
        this.media = media;
    }

}
