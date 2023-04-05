package association.composition;

public class House {
    private Kitchen kitchen;

    public House(){
        kitchen = new Kitchen("pizza");
    }

    public String getFood(){
        return kitchen.getFood();
    }
}
