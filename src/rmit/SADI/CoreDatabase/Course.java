package rmit.SADI.CoreDatabase;

import java.io.Serializable;

public class Course implements Serializable {
    private String id,name;
    private static final byte credits = 12; //All courses are 12 credits//

    //Builder Pattern
    public Course setId(String id) {
        this.id = id;
        return this;
    }

    public Course setName(String name) {
        this.name = name;
        return this;
    }

    //Getters
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    //toString
    @Override
    public String toString() {
        return id==null?" ":id ;
    }
}
