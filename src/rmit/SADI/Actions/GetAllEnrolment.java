package rmit.SADI.Actions;
import rmit.SADI.CoreDatabase.StudentEnrolmentList;

public class GetAllEnrolment implements Command{//Command Pattern to outsource actions
    //Singleton Pattern to save memory
    private static GetAllEnrolment instance = new GetAllEnrolment();
    private GetAllEnrolment() {}
    public static GetAllEnrolment getInstance() {
        return instance;
    }

    @Override
    public void execute() {
        System.out.println("\n" + StudentEnrolmentList.getInstance()); //Facade Pattern
    }
}
