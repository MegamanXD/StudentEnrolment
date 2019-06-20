package rmit.SADI.Actions;

import rmit.SADI.CoreDatabase.StudentEnrolment;
import rmit.SADI.CoreDatabase.StudentEnrolmentList;

import java.util.List;

public class UndoDelete implements Command{//Command Pattern to outsource actions
    private static List<StudentEnrolment> backUp;

    //Singleton Pattern to save memory
    private static UndoDelete instance = new UndoDelete();
    private UndoDelete() {}
    public static UndoDelete getInstance() {
        return instance;
    }

    //Memento Pattern
        //Backup method
    public static void setBackUp (StudentEnrolmentList list) {      //This is the Backup method
        backUp = list.clone();
    }

        //Restore method
    @Override
    public void execute() {     //This is the Restore method
        if (backUp==null){
            System.out.println();
        }
        else
        {
            StudentEnrolmentList.getInstance().getList().clear();
            StudentEnrolmentList.getInstance().getList().addAll(backUp);
            System.out.println();
        }
    }
}
