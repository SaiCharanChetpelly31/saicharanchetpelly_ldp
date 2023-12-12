package singleton.eager;

public class Samosa {
    //obj is created while class loading
    private static Samosa samosa = new Samosa();
    private Samosa(){

    }
    public static Samosa getSamosa(){
        return samosa;
    }
}
