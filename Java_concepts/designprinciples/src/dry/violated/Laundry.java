package dry.violated;

public class Laundry {
    // single unambiguous authoritative representation

    public void washWhiteClothes() {
        // filling water to washing machine,setting configuration
        System.out.println("Putting in white clothes");
        // draining out water
    }

    public void washColorfulClothes() {
        // filling water to washing machine,setting configuration
        System.out.println("Putting in colorful clothes");
        // draining out water
    }
}
//here there is repeated code , if we change at one place,we have to change at another place. so place repeated code
//in one function and reuse whereever you need.
