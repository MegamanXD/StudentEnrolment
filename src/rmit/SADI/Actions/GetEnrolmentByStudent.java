package rmit.SADI.Actions;
import rmit.SADI.CoreDatabase.StudentEnrolment;
import rmit.SADI.CoreDatabase.StudentEnrolmentList;

import java.util.List;
import java.util.Scanner;

public class GetEnrolmentByStudent implements Command{//Command Pattern to outsource actions
    private List<StudentEnrolment> enrolments = StudentEnrolmentList.getInstance().getList();

    //Singleton Pattern to save memory
    private static GetEnrolmentByStudent instance = new GetEnrolmentByStudent();
    private GetEnrolmentByStudent() {}
    public static GetEnrolmentByStudent getInstance() {
        return instance;
    }

    //Core method
    private void getStudent(String studentID) {
        boolean found = false;
        for (int i = enrolments.size()-1; i>-1 ; i--) {
            if (enrolments.get(i).getStudent().getId().equalsIgnoreCase(studentID)){
                enrolments.get(i).getSameStudentChain();
                found = true;
                System.out.println();
                break;
            }
        }
        if (!found)
            System.out.println("Haven't seen that one around :)\n");
    }

    //Command Pattern to outsource actions
    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Searching for Student ID: ");
        String studentID = scan.nextLine();
        getStudent(studentID);
    }
}
