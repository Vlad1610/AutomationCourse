package ro.sit.homework.Homework04;

public class Dog {
    private int id;
    private String nume;
    private String rasa;

    public Dog(int id, String nume, String rasa) {
        this.id = id;
        this.nume = nume;
        this.rasa = rasa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getRasa() {
        return rasa;
    }

    public void setRasa(String rasa) {
        this.rasa = rasa;
    }
}
