package dry.corrected;
//DRY-Don't repeat yourself
public class Laundry {
    // single unambiguous authoritative representation

    public void washWhiteClothes() {

        System.out.println("Putting in white clothes");
        performCommonTasks();
    }

    public void washColorfulClothes() {
        System. out.println("Putting in colorful clothes");
        performCommonTasks();
    }
    //common code at one place
    public void performCommonTasks() {
        // filling water to washing machine,setting configuration
        // draining out water
    }
}

