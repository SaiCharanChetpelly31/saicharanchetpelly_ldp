package datahiding;

public class Student {
    private int marks;
    private String studentName;
    private int rollNo;
    Student(String studentName,int rollNo,int marks){
        this.studentName = studentName;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    public int getMarks(String studentName,int rollNo){
        if(this.studentName.equals(studentName) && (this.rollNo == rollNo)){
            return this.marks;
        }
        return  0;
    }

    public static void main(String[] args) {
        Student student1 = new Student("Saicharan",134,90);
        System.out.println(student1.getMarks(student1.studentName,student1.rollNo));

    }
}
