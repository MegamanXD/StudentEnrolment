package rmit.SADI.Actions;

import rmit.SADI.CoreDatabase.StudentEnrolment;
import rmit.SADI.CoreDatabase.StudentEnrolmentList;

import java.util.List;

public class UpdateEnrolment implements Command{//Command Pattern to outsource actions
    private List<StudentEnrolment> enrolments = StudentEnrolmentList.getInstance().getList();

    //Singleton Pattern to save memory
    private static UpdateEnrolment instance = new UpdateEnrolment();
    private UpdateEnrolment() {}
    public static UpdateEnrolment getInstance() {
        return instance;
    }

    //Core method
    private void update(StudentEnrolment studentEnrolment) {
        boolean updated = false;
        if (studentEnrolment == null){
            System.out.println("Wrong input! System: unchanged.\n");
            return;
        }
        for (int i = 0; i < enrolments.size(); i++) {
            StudentEnrolment enrolment = enrolments.get(i);
            if (enrolment.getStudent().getId().equalsIgnoreCase(studentEnrolment.getStudent().getId()) &&
                    enrolment.getSemester().equalsIgnoreCase(studentEnrolment.getSemester())){
                enrolments.set(i,studentEnrolment);
                updated = true;
                System.out.println();
            }
        }
        if (!updated)
            System.out.println("Wrong input! System: unchanged.\n");
    }

    //Command Pattern to outsource actions
    @Override
    public void execute() {
        System.out.println("Please input updated details:");
        StudentEnrolment updated = AddEnrolment.enroll();
        update(updated);
    }
}
