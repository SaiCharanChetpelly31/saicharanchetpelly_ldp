//problem statement : John is a recruiter in a company and wants to map candidates based on their location preferences.
// Develop an algorithm to match candidates to the locations based on their preferences.
import java.util.HashMap;
import java.util.Scanner;

class Cities {
    HashMap<String, Integer> cities = new HashMap<>(); //map to store cities and no.of vacancies
    Cities() {
        cities.put("hyderabad", 10);
        cities.put("bangalore", 16);
        cities.put("pune", 18);
        cities.put("chennai", 17);
        cities.put("mumbai", 16);
        cities.put("delhi", 23);
        cities.put("noida", 20);
        cities.put("nagpur", 11);
        cities.put("Coimbatore", 15);
        cities.put("Kolkata", 13);
    }
    //method to search for location/city in map(cities)
    boolean searchCity(String city) {
        //if map(cities) contains required city
        if (cities.containsKey(city)) {
            if (cities.get(city) > 0) {
                cities.replace(city, cities.get(city) - 1); //decrementing vacancies by 1
                System.out.println("Your Preferred city " + city + " is allocated");
                return true;
            } else System.out.println("No vacancies at " + city + " location");
        }
        return false; //city not found or vacancy not available
    }
}
public class Main {
    public static void main(String[] args) {
        Cities c = new Cities();
        Scanner in = new Scanner(System.in);
        int candidate = 1;
        //infinite loop until input is "exit"
        while (true) {
            String firstCity = "";
            String secondCity = "";
            String thirdCity = "";
            System.out.println("candidate:" + candidate + " Enter your first preference city: ");
            //reading firstCity input from candidate
            firstCity = in.next();
            if (firstCity.equals("exit")) System.exit(0);

            //if firstCity is not allocated to candidate
            if (!c.searchCity(firstCity)) {
                System.out.println("Enter your Second preference city: ");
                //reading secondCity input from candidate
                secondCity = in.next();
                if (secondCity.equals("exit")) System.exit(0);
            }

            //if secondCity is not allocated to candidate
            if (secondCity.length() > 0 && !c.searchCity(secondCity)) {
                System.out.println("Enter your third preference city: ");
                //reading thirdCity input from candidate
                thirdCity = in.next();
                if (thirdCity.equals("exit")) System.exit(0);
            }

            //if thirdCity is not allocated to candidate
            if (thirdCity.length() > 0 && !c.searchCity(thirdCity))
                System.out.println("You are not allocated to any location");
            candidate++;
        }
    }
}



