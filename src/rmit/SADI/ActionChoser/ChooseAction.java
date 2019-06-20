package rmit.SADI.ActionChoser;

import rmit.SADI.Actions.*;

public class ChooseAction {    //Strategy Pattern
    Command[] commands = {
            AddEnrolment.getInstance(),
            DeleteEnrolment.getInstance(),
            UndoDelete.getInstance(),
            UpdateEnrolment.getInstance(),
            GetAllEnrolment.getInstance(),
            GetEnrolmentBySemester.getInstance(),
            GetEnrolmentByStudent.getInstance()
    };

    //Singleton Pattern to save memory
    private static ChooseAction instance = new ChooseAction();
    private ChooseAction() {}
    public static ChooseAction getInstance() {
        return instance;
    }

    //Core method
    public void performOption(byte option){
        commands[option-1].execute();
    }
}
