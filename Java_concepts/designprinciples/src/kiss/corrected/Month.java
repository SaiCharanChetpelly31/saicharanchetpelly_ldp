package kiss.corrected;

public class Month {
    public static String getMonthName(int month) {
        if ((month < 1) || (month > 12))
            throw new IllegalArgumentException("Month must be in range 1 to 12");
        else {
            String[] months = {"January","February","March","April","May","June","July","August","sepetember","october","November","December"};
            return months[month - 1];

        }
    }

    public static void main(String[] args) {
        Month month = new Month();
        System.out.println( month.getMonthName(12));
    }
}
