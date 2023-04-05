package delegation;

public class TicketBookingAgent {
    static Ticket t;
    public TicketBookingAgent(Ticket t){
        this.t = t;
    }

    public static void bookTicket(){
        t.bookTicket();
    }
}
