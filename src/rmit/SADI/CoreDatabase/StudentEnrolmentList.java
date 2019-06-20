package rmit.SADI.CoreDatabase;

import rmit.SADI.ListManipulation.ListToString;
import rmit.SADI.ListManipulation.MyCloneable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentEnrolmentList implements StudentEnrolmentManager, MyIterator, MyCloneable, Serializable {
    private List<StudentEnrolment> enrolments = new ArrayList<>();
    short currentItem = 0;

    //Singleton Pattern
    private static StudentEnrolmentList instance = new StudentEnrolmentList();
    private StudentEnrolmentList() {}
    public static StudentEnrolmentList getInstance() {
        return instance;
    }

    //Setter
    public static void setInstance(StudentEnrolmentList instance) {
        StudentEnrolmentList.instance = instance;
    }

    //Implement StudentEnrolmentManager
    @Override
    public List<StudentEnrolment> getList() {
        return enrolments;
    }

    //toString
    @Override
    public String toString() {
        return "Enrolment list:\n" + ListToString.convert(enrolments);//Facade Pattern
    }

    //Iterator Pattern
    @Override
    public boolean hasNext() {
        if(currentItem >= enrolments.size()){
            currentItem = 0;
            return false;
        }
        return true;
    }

    @Override
    public StudentEnrolment next() {
        return enrolments.get(currentItem++);
    }

    //Prototype Pattern
    @Override
    public List<StudentEnrolment> clone() {
        List<StudentEnrolment> temp = new ArrayList<>();
        temp.addAll(enrolments);
        return temp;
    }
}
