package delegation;

public class Demo {

    public static void main(String[] args) {
        TicketBookingAgent agent = new TicketBookingAgent(new TrainTicket());
        agent.bookTicket();
        TicketBookingAgent agent1 = new TicketBookingAgent(new FlightTicket());
        agent1.bookTicket();
    }

}
