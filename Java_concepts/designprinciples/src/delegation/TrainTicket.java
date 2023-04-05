package delegation;

public class TrainTicket  implements  Ticket{

    @Override
    public void bookTicket() {
        System.out.println("Train ticket booking");
    }
}
