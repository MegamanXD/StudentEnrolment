package rmit.SADI.FileInputOutput;

import rmit.SADI.CoreDatabase.StudentEnrolmentList;

import java.io.*;

public class FileIO {
    public static void export(){
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Enrolment List.heo"));
                outputStream.writeObject(StudentEnrolmentList.getInstance());
        } catch (IOException e) {
            System.out.println("Error writing file!");
        }
    }

    public static void read(){
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("Enrolment List.heo"));
            StudentEnrolmentList.setInstance((StudentEnrolmentList) inputStream.readObject());
        } catch (IOException e) {
            System.out.println("Error reading file!");
        } catch (ClassNotFoundException e) {
            System.out.println("Error reading file!");
        }
    }
}
