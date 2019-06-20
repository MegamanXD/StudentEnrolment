package rmit.SADI.Actions;

import rmit.SADI.ActionVisitor.ActionVisitor;
import rmit.SADI.ActionVisitor.Visitor;
import rmit.SADI.CoreDatabase.StudentEnrolment;
import rmit.SADI.CoreDatabase.StudentEnrolmentList;

public class DeleteEnrolment implements Command {//Command Pattern to outsource actions
    //Singleton Pattern to save memory
    private static DeleteEnrolment instance = new DeleteEnrolment();
    private DeleteEnrolment() {}
    public static DeleteEnrolment getInstance() {
        return instance;
    }

    //Core method
    public void delete(String studentID, String semester) {
        StudentEnrolmentList enrolments = StudentEnrolmentList.getInstance();
        boolean deleted = false;

        while(enrolments.hasNext()){    //Iterator Patter
            StudentEnrolment studentEnrolment = enrolments.next();

            if (studentEnrolment.getStudent().getId().equalsIgnoreCase(studentID) &&
                    studentEnrolment.getSemester().equalsIgnoreCase(semester)){
                System.out.print("Deleted: " + studentEnrolment + "\n");
                enrolments.getList().remove(studentEnrolment);
                deleted = true;
            }
        }
        if (!deleted)
            System.out.println("Wrong input! System: unchanged.");
    }

    //Visitor Pattern to externalize further complexities
    Visitor visitor = ActionVisitor.getInstance();

    @Override
    public void execute() {
        visitor.visit(this);
    }
}


