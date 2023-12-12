package singleton.lazy;

class Samosa {
    private static Samosa samosa;

    private Samosa(){

    }

    //lazy initialization since we are creating object only on calling this method;
    public static Samosa getInstance(){
        if(samosa == null){
            samosa = new Samosa();
        }
        return samosa;
    }
}
