package ro.sit.course.course03_04;

public class Teacher extends Person {
    private String teacherId;
    private String discipline;

    public Teacher(String name, byte age, String sex, String cnp, String teacherId, String discipline) {
        super(name, age, sex, cnp);
        this.teacherId = teacherId;
        this.discipline = discipline;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public String getDiscipline() {
        return discipline;
    }

    @Override
    public String toString() {
        return "Teacher{" + super.toString() + ','+
                "teacherId='" + teacherId + '\'' +
                ", discipline='" + discipline + '\'' +
                '}';
    }
}