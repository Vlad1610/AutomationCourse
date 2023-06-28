package ro.sit.course.course03_04;

public class Student extends Person {

    private String subjectOfStudy;
    private String studentId;


    public Student(String name, byte age, String sex, String cnp,
                   String studentId, String subjectOfStudy) {
        super(name, age, sex, cnp);
        this.studentId = studentId;
        this.subjectOfStudy = subjectOfStudy;
    }

    public String getSubjectOfStudy() {
        return subjectOfStudy;
    }

    public String getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() + ',' +
                "subjectOfStudy='" + subjectOfStudy + '\'' +
                ",studentId='" + studentId + '\'' +
                '}';
    }
}