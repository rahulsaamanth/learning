package ticket.booking.entities;

import java.util.List;

public class User {
    private String username;
    private String password;
    private String hashedPassword;
    private String userId;

    private List<Ticket> ticketsBooked;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public List<Ticket> getTicketsBooked() {
        return ticketsBooked;
    }

    public void printTickets() {
        if (ticketsBooked.isEmpty()) {
            System.out.println("No tickets booked yet!");
            return;
        } else {
            for (Ticket ticket : ticketsBooked)
                System.out.println(ticket.getTicketInfo());
        }
    }

    public String getUserId() {
        return userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setTicketsBooked(List<Ticket> ticketsBooked) {
        this.ticketsBooked = ticketsBooked;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

}
