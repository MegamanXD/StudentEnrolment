package rmit.SADI.CoreDatabase;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student implements Serializable {
    private String id,name;
    private Date birthdate;
    //Make Date more intuitive
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    //Constructor
    public Student() {
        this.id = null;
        this.name = null;
        try {
            this.birthdate = dateFormat.parse("01-01-0001");
        } catch (ParseException e) {
            System.out.println("Input: invalid!");
        }
    }

    //Builder Pattern
    public Student setId(String id) {
        this.id = id;
        return this;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public Student setBirthdate(int day,int month,int year) {
        try {
            this.birthdate = dateFormat.parse(day + "-" + month + "-" + year);
        } catch (ParseException e) {
            System.out.println("Input: invalid!");
        }
        return this;
    }

    //Getters
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Date getBirthdate() {
        return birthdate;
    }

    //toString
    @Override
    public String toString() {
        return "Student ID = " + id;
    }
}
