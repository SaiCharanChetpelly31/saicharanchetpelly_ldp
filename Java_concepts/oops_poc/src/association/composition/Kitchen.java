package association.composition;

public class Kitchen {
    private String food;

    public Kitchen(String food){
        this.food = food;
    }
    public String getFood(){
        return this.food;
    }
    public void setFood(String food){
        this.food = food;
    }
}
