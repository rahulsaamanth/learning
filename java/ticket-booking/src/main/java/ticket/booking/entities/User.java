package ticket.booking.entities;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty("name")
    private String username;
    private String password;
    @JsonProperty("hashed_password")
    private String hashedPassword;
    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("tickets_booked")
    private List<Ticket> ticketsBooked;

    public User() {
    }

    public User(String username, String password, String hashedPassword, List<Ticket> ticketsBooked, String userId) {
        this.username = username;
        this.userId = userId;
        this.password = password;
        this.hashedPassword = hashedPassword;
        this.ticketsBooked = ticketsBooked != null ? ticketsBooked : Collections.emptyList();
    }

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
