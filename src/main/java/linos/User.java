package linos;


import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;



public class User {
    protected String id;
    protected String name;
    protected String email;
    protected String password;
    protected File qrcode;
    protected String path;

    private ArrayList<Ticket> tickets = new ArrayList<>();

    public User(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        /* 
        Random random = new Random();
        String loc = "resources/"+ random.nextInt() + ".png";
        this.path = loc;
        this.qrcode = new File(path);
        */
        try {
            
            URL resourceUrl = getClass().getClassLoader().getResource("images");
            if (resourceUrl != null) {
                File resourceDir = new File(resourceUrl.toURI());
                Random random = new Random();
                File qrCodeFile = new File(resourceDir, random.nextInt() + ".png");
                
                this.qrcode = qrCodeFile;
                this.path = qrCodeFile.getAbsolutePath();
            } else {
                throw new RuntimeException("Could not locate resources directory");
            }
        } catch (URISyntaxException e) {
            System.err.println("Error creating QR code file: " + e.getMessage());
            e.printStackTrace();
        }

    }
    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        /* 
        Random random = new Random();
        String path = "resources/"+ random.nextInt() + ".png";
        this.qrcode = new File(path);*/
        try {
        
        URL resourceUrl = getClass().getClassLoader().getResource("");
        if (resourceUrl != null) {
            File resourceDir = new File(resourceUrl.toURI());
            Random random = new Random();
            File qrCodeFile = new File(resourceDir, random.nextInt() + ".png");
            
            this.qrcode = qrCodeFile;
            this.path = qrCodeFile.getAbsolutePath();
        } else {
            throw new RuntimeException("Could not locate resources directory");
        }
        } catch (URISyntaxException e) {
        System.err.println("Error creating QR code file: " + e.getMessage());
        e.printStackTrace();
        }
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




    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }
    public void purchaseTicket(String eventId, double price, String seatNumber, String ticketType, String filepath) {
        Ticket t = new Ticket(ticketType, eventId, price, seatNumber, ticketType, filepath);
        addTicket(t);
    }
    public File getFile(){
        return qrcode;
    }
    public String getPath(){
        return path;
    }
}
