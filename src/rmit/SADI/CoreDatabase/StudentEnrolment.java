package rmit.SADI.CoreDatabase;

import java.io.Serializable;
import java.util.Arrays;

public class StudentEnrolment implements Serializable {
    private Student student = new Student();
    private Course[] courses = {new Course(),new Course(),new Course(),new Course()};//Maximum 4 courses for RMIT
    private String semester;

    //Constructor
    public StudentEnrolment() {}

    //Getters & Setters
    public Student getStudent() {
        return student;
    }
    public Course[] getCourses() {
        return courses;
    }
    public String getSemester() {
        return semester;
    }
    public void setSemester(String semester) {
        this.semester = semester;
    }

    //Chain of Responsibilities to minimize search time
    StudentEnrolment nextSameStudent;
    StudentEnrolment nextSameSemester;

        //Get the same student into a chain
    public void setNextSameStudent(StudentEnrolment nextSameStudent) {
        this.nextSameStudent = nextSameStudent;
    }

        //Get the same semester into a chain
    public void setNextSameSemester(StudentEnrolment nextSameSemester) {
        this.nextSameSemester = nextSameSemester;
    }

        //Get the Same Student chain to display themselves
    public void getSameStudentChain(){
        System.out.println(this);
        if (nextSameStudent!=null)
            nextSameStudent.getSameStudentChain();
    }

        //Get the Same Semester chain to display themselves
    public void getSameSemesterChain(){
        System.out.println(this);
        if (nextSameSemester!=null)
            nextSameSemester.getSameSemesterChain();
    }

    //toString
    @Override
    public String toString() {
        return  student + "   Courses = " + Arrays.toString(courses) + "   Semester = " + semester + "";
    }
}
