package delegation;

public class FlightTicket implements  Ticket{
    @Override
    public void bookTicket() {
        System.out.println("Flight ticket booked");
    }
}
