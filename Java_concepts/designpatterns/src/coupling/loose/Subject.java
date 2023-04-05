package coupling.loose;

public class Subject {
    Topic t = new Science();
    public Subject(){
        t.read();
    }
}

class Science implements Topic{

    @Override
    public void read() {
        System.out.println("reading science...");
    }
}
class Maths implements Topic{

    @Override
    public void read() {
        System.out.println("reading Maths...");
    }
}
