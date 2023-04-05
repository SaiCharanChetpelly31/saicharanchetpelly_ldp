package association.aggregation;

import java.util.ArrayList;
import java.util.List;

public class AggregationDemo {
    public static void main(String[] args) {
        List<Teacher> teachers = new ArrayList<Teacher>();
        teachers.add(new Teacher("Rohan","Java"));
        teachers.add(new Teacher("Raju","Python"));

        College college = new College("MVSR",teachers);
        System.out.println(college.getTeachers());
    }
}
