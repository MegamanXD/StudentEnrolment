package rmit.SADI.Actions;

import rmit.SADI.ActionVisitor.ActionVisitor;
import rmit.SADI.ActionVisitor.Visitor;
import rmit.SADI.CoreDatabase.StudentEnrolment;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AddEnrolment implements Command{//Command Pattern to outsource actions
    //Singleton Pattern to save memory
    private static AddEnrolment instance = new AddEnrolment();
    private AddEnrolment() {}
    public static AddEnrolment getInstance() {
        return instance;
    }

    //Core method: enrol student by asking for Student ID, Course ID, and Semester with Scanner(System.in)
    public static StudentEnrolment enroll(){
        StudentEnrolment studentEnrolment = new StudentEnrolment();
        Scanner scan = new Scanner(System.in);

        System.out.print("Student ID: ");
        studentEnrolment.getStudent().setId(scan.nextLine());

        System.out.print("Semester: ");
        studentEnrolment.setSemester(scan.nextLine()) ;

        System.out.print("Number of course (1-4): ");

        try{
            byte noOfCourses= scan.nextByte();
            scan.nextLine(); //Get the Enter key out of the Scanner

            if (noOfCourses<1 || noOfCourses>4){
                System.out.println("Input: invalid! Please enter 1-4 only.\n");
                return null;
            }
            else {
                for (int i = 0; i < noOfCourses; i++) {
                    System.out.print("Course ID no." + (i+1) + ": ");
                    studentEnrolment.getCourses()[i].setId(scan.nextLine());
                }
            }
        }catch (InputMismatchException e){
            System.out.println("Input: invalid! Please enter 1-4 only.\n");
            return null;
        }
        return studentEnrolment;
    }

    //Visitor Pattern to externalize further complexities
    Visitor visitor = ActionVisitor.getInstance();

    @Override
    public void execute() {
        visitor.visit(this);
    }
}
