package rmit.SADI.ActionVisitor;

import rmit.SADI.Actions.*;
import rmit.SADI.CoreDatabase.StudentEnrolment;
import rmit.SADI.CoreDatabase.StudentEnrolmentList;

import java.util.List;
import java.util.Scanner;

public class ActionVisitor implements Visitor {
    //Singleton Pattern to save memory
    private static ActionVisitor instance = new ActionVisitor();
    private ActionVisitor() {}
    public static ActionVisitor getInstance() {
        return instance;
    }

    @Override
    public void visit(AddEnrolment addEnrolment) {
        StudentEnrolment studentEnrolment = AddEnrolment.enroll();
        if (studentEnrolment != null){
            List<StudentEnrolment> enrolments = StudentEnrolmentList.getInstance().getList();
            //Add to Same Student chain
            for (int i = enrolments.size()-1; i>-1; i--) {
                if (enrolments.get(i).getStudent().getId().equalsIgnoreCase(studentEnrolment.getStudent().getId())){
                    studentEnrolment.setNextSameStudent(enrolments.get(i));
                    break;
                }
            }
            //Add to Same Semester chain
            for (int i = enrolments.size()-1; i>-1; i--) {
                if (enrolments.get(i).getSemester().equalsIgnoreCase(studentEnrolment.getSemester())){
                    studentEnrolment.setNextSameSemester(enrolments.get(i));
                    break;
                }
            }
            enrolments.add(studentEnrolment);
            System.out.println();
        }
    }

    @Override
    public void visit(DeleteEnrolment deleteEnrolment) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Student ID for Enrolment-to-be-deleted: ");
        String studentID = scan.nextLine();
        System.out.print("Semester for Enrolment-to-be-deleted: ");
        String semester = scan.nextLine();

        System.out.println("Setting backup ...");
        UndoDelete.setBackUp(StudentEnrolmentList.getInstance());

        deleteEnrolment.delete(studentID,semester);
        System.out.println();
    }
}
