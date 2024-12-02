import java.util.ArrayList;
import java.util.List;
/*  Create a password , =create a getter method for password and a check method for password

 */



public abstract class User {
    protected String id;
    protected String name;
    protected String email;
    protected String password;

    private List<Ticket> tickets = new ArrayList<>();

    public User(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;

    }
    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }


    

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    public String getPassword()
    {return password;}




    public List<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }
    public void purchaseTicket(String eventId, double price, String seatNumber, String ticketType, String filepath) {
        Ticket t = new Ticket(ticketType, eventId, price, seatNumber, ticketType, filepath);
        addTicket(t);
    }
}
