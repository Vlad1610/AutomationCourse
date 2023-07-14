package ro.sit.homework.Homework04;

import java.util.*;

public class Catalog {

    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        Student student1 = new Student("Valentin", 10);
        Student student2 = new Student("Andreea", 8);
        Student student3 = new Student("Bogdan", 9);
        HashSet<Student> MyStudentList = new HashSet<>();
        MyStudentList = catalog.getStudentList(student1, student2, student3);
        catalog.showAllStudents(MyStudentList);
        catalog.findStudent("Valentin", MyStudentList);
        catalog.deleteStudent("Bogdan", MyStudentList);
        catalog.showAllStudents(MyStudentList);
        catalog.sortStudents(MyStudentList);
        catalog.sortMedia(MyStudentList);
//        catalog.getSearch("Valentin");
//        catalog.findStudent(student1, student2, student3);
//        catalog.getSearch("Andreea");
//        catalog.deleteStudent(student1, student2, student3);


    }
    public HashSet<Student> getStudentList(Student s1, Student s2, Student s3) {
        HashSet<Student> studentList = new HashSet<>();
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        return studentList;
    }
    public void showAllStudents(HashSet<Student> s) {
        for (Student st : s)
            System.out.println(st.getNume() + " " + st.getMedia());

    }

    public void findStudent(String name, HashSet<Student> sList)  {
        for (Student currentStud : sList) {
            if (Objects.equals(currentStud.getNume(), name)) {
                System.out.println("The student with the name " + currentStud.getNume() + " and mean " + currentStud.getMedia() + " is present in the list.");
                return;
            }
        }
        System.out.println("The student with the name " + name + " is not in the list.");
    }

    public void deleteStudent(String name, HashSet<Student> stList)  {
        for (Student currentStud : stList) {
            if (Objects.equals(currentStud.getNume(), name)) {
                stList.remove(currentStud);
                System.out.println("The student with the name " + name + " was deleted from the list.");
                return;
            }
            System.out.println("The student with the name" + name + " is not in the list.");
        }
        System.out.println("The student with the name " + name + " is not in the list.");
    }

    public void sortStudents(HashSet<Student> sortList) {
        List<String> nameOfStudents = new ArrayList<String>();
        for (Student stud :sortList){
            nameOfStudents.add(stud.getNume());
        }
        Collections.sort(nameOfStudents);
        System.out.println("List elements in alphabetical order: " + nameOfStudents);
    }

    public void sortMedia(HashSet<Student> sortAvg) {
        List<Integer> mediaOfStudents = new ArrayList<Integer>();
        for (Student med : sortAvg) {
            mediaOfStudents.add(med.getMedia());
        }
        Collections.sort(mediaOfStudents);
        System.out.println("List elements in ascending average value: " + mediaOfStudents);
    }
}
