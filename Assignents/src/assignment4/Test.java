package assignment4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Test {
    public static String getRange(String signUpDate, String currentDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate formattedSignUpDate = LocalDate.parse(signUpDate, formatter);
        LocalDate formattedCurrentDate = LocalDate.parse(currentDate, formatter);
        int year = formattedCurrentDate.getYear();
        LocalDate next30Days = LocalDate.of(year, formattedSignUpDate.getMonth(), formattedSignUpDate.getDayOfMonth()).plusDays(30);
        LocalDate past30Days = LocalDate.of(year, formattedSignUpDate.getMonth(), formattedSignUpDate.getDayOfMonth()).minusDays(30);
        if (formattedSignUpDate.isAfter(formattedCurrentDate)) {
            return "No range";
        } else if (formattedCurrentDate.isAfter(next30Days)) {
            return (formatter.format(past30Days) + " " + formatter.format(next30Days));
        } else {
            return (formatter.format(past30Days) + " " + formatter.format(formattedCurrentDate));
        }

    }public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of inputs");
        int noOfInputs = sc.nextInt();
        sc.nextLine();
        String[] rangeDates = new String[noOfInputs];
        int i = 0;
        while ( i<noOfInputs  ) {
            System.out.println("Enter the signup and current date string");
            String str=sc.nextLine();
            String[] input = str.split(" ");
            if(input.length==2)
                rangeDates[i] = getRange(input[0], input[1]);
            i++;
        }
        for (String date : rangeDates) {
            System.out.println(date);
        }

    }
}
