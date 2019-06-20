package rmit.SADI.ListManipulation;

import rmit.SADI.CoreDatabase.StudentEnrolment;
import java.util.List;

public class ListToString {
    public static String convert(List<StudentEnrolment> list){
        StringBuilder sb = new StringBuilder();
        if (list.size() == 0)
            sb.append("Empty\n");
        else {
            for (StudentEnrolment studentEnrolment:list) {
                sb.append(studentEnrolment + "\n");
            }
        }
        return sb.toString();
    }
}
