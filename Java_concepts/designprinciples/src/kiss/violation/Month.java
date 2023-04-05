package kiss.violation;

public class Month {
    public String getMonth(int month){
        switch(month){
            case 1:
                return "January";
            case 2:
                return "Februaury";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "september";
            case 10:
                return "october";
            case 11:
                return "november";
            case 12:
                return "december";
            default:
                return "Please enter valid month";
        }

    }

    public static void main(String[] args) {
        Month myObj = new Month();
        System.out.println( myObj.getMonth(12));
    }
}
