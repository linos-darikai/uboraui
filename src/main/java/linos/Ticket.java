// Create a private static variable that would store the price of the tickets

public class Ticket {
    private String userId; // treat as email.
    private String eventId;
    private double price;
    private String seatNumber;
    private String ticketType;
    private QRCode qrcode;
    private String qrCodepath;
    // Create an image location variable and its getter methods

    public Ticket(String userId, String eventId, double price, String seatNumber, String ticketType, String qString) {
        this.userId = userId;
        this.eventId = eventId;
        this.price = price;
        this.seatNumber = seatNumber;
        this.ticketType = ticketType;
        this.qrCodepath = qString;
        this.qrcode = new QRCode(qString);
        // Create the image using ZXing QR code
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "Event ID: " + eventId + ". Ticket Type: " + ticketType +
                ", Price: " + price + ", Seat: " + seatNumber;
    }


    public String getEventId() {
        return eventId;
    }

    public double getPrice() {
        return price;
    }

    public String getSeatNumber() {
        return seatNumber;
    }
    public String getTicketType() {
        return ticketType;
    }
    public QRCode getQRCode(){
        return qrcode;
    }
}

