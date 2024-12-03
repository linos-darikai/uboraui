package linos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class UserManager {
    private ArrayList<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
        System.out.println("User added: " + user.getName());
    }
    public ArrayList<User> getUsers(){return users;}

    public User getUserByPassword(String password) {
        for (User user : users) {
            if (user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void displayUsers() {
        if (users.isEmpty()) {
            System.out.println("No users are registered yet.");
        } else {
            System.out.println("All Registered Users:");
            users.forEach(user -> System.out.println("- " + user.getName()));
        }
    }

    public void saveUsersToCSV(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (User user : users) {
                StringBuilder userLine = new StringBuilder(user.getId() + "," + user.getName() + "," + user.getEmail() + "," + user.getPassword()+ ","+ user.getClass().getSimpleName());
                //edit the ticket here

                for (Ticket ticket : user.getTickets()) {
                    userLine.append(",").append(ticket.getEventId()).append("|").append(ticket.getPrice())
                            .append("|").append(ticket.getSeatNumber()).append("|").append(ticket.getTicketType()).append("|").append(ticket.getQRCode().getfilePath());
                }
                writer.println(userLine.toString());
            }
            System.out.println("Users and tickets saved to CSV successfully.");
        } catch (IOException e) {
            System.out.println("Error saving users to CSV: " + e.getMessage());
        }
    }

    public void loadUsersFromCSV(String fileName) {
        users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    String id = parts[0];
                    String name = parts[1];
                    String email = parts[2];
                    String password = parts[3];
                    String type = parts[4];


                    User user = null;
                    switch (type) {
                        case "Student":
                            user = new Student(id, name, email, password);
                            break;
                        case "Faculty":
                            user = new Faculty(id, name, email,password);
                            break;
                        case "Guest":
                            user = new Guest(email, name, password, "0000");
                            break;
                        default:
                            System.out.println("Unknown user type: " + type);
                    }


                    // edit this code for the ticket thing 
                    if (user != null) {
                        for (int i = 4; i < parts.length; i++) {
                            String[] ticketData = parts[i].split("\\|");
                            if (ticketData.length == 5) {
                                String eventId = ticketData[0];
                                double price = Double.parseDouble(ticketData[1]);
                                String seatNumber = ticketData[2];
                                String ticketType = ticketData[3];
                                String qrPath = ticketData[4];

                                Ticket ticket = new Ticket(user.getId(), eventId, price, seatNumber, ticketType, qrPath);
                                user.addTicket(ticket);
                            }
                        }
                        users.add(user);
                    }
                }
            }
            System.out.println("Users and tickets loaded from CSV successfully.");
        } catch (IOException e) {
            System.out.println("Error loading users from CSV: " + e.getMessage());
        }
    }
}
