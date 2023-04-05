package association.aggregation;

import java.util.ArrayList;
import java.util.List;

public class College {
    List<Teacher> teachers = new ArrayList<>();
    String collegeName;

    public College(String collegeName,List<Teacher> teachers){
        this.collegeName = collegeName;
        this.teachers = teachers;
    }

    public List<Teacher> getTeachers(){
        return teachers;
    }
}
