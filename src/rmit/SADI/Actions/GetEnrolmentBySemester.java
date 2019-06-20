package rmit.SADI.Actions;

import rmit.SADI.CoreDatabase.StudentEnrolment;
import rmit.SADI.CoreDatabase.StudentEnrolmentList;

import java.util.List;
import java.util.Scanner;

public class GetEnrolmentBySemester implements Command{//Command Pattern to outsource actions
    private List<StudentEnrolment> enrolments = StudentEnrolmentList.getInstance().getList();

    //Singleton Pattern to save memory
    private static GetEnrolmentBySemester instance = new GetEnrolmentBySemester();
    private GetEnrolmentBySemester() {}
    public static GetEnrolmentBySemester getInstance() {
        return instance;
    }

    //Core method
    private void getSemester(String semester) {
        boolean found = false;
        for (int i = enrolments.size()-1; i>-1 ; i--) {
            if (enrolments.get(i).getSemester().equalsIgnoreCase(semester)){
                enrolments.get(i).getSameSemesterChain();
                found = true;
                System.out.println();
                break;
            }
        }
        if (!found)
            System.out.println("No such semester :)\n");
    }

    //Command Pattern to outsource actions
    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Searching for Semester: ");
        String semester = scan.nextLine();
        getSemester(semester);
    }
}
