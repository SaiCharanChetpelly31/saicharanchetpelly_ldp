package basics;

public class Relational {
    public static void main(String[] args) {
        boolean myBool = true;
        boolean yourBool = false;
        int myAge = 22;
        int yourAge = 30;
        int bobsAge = 20;

        String myName = "Saicharan";
        String yourName = "charan";

        System.out.println("myBool is " + myBool);
        System.out.println("yourBool is " + yourBool);

        //relational operations
        boolean ageComparison = myAge > yourAge;
        System.out.println("myAge > yourAge?: " + ageComparison);

        ageComparison = yourAge > bobsAge;
        System.out.println("yourAge > bobsAge?:" + ageComparison);

        ageComparison = yourAge == bobsAge;
        System.out.println("yourAge == bobsAge?: " + ageComparison);

        boolean nameComparison = myName.equals(yourName);
        System.out.println("do names match?: " + nameComparison);

        int currentAge = 37;

        boolean isGreater21 = currentAge >= 21;

        System.out.println("currentAge >= 21?: " + isGreater21);

    }//end main
}
