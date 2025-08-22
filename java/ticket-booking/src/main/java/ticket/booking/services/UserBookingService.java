package ticket.booking.services;

import ticket.booking.entities.Ticket;
import ticket.booking.entities.Train;
import ticket.booking.entities.User;
import ticket.booking.utils.UserServiceUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class UserBookingService {
    private User user;
    private List<User> userList;

    private ObjectMapper objectMapper = new ObjectMapper();

    private static final String USERS_PATH = "src/main/java/ticket/booking/localDB/users.json";

    public UserBookingService() throws IOException {
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        loadUsers();
    }

    private void loadUsers() throws IOException {
        userList = objectMapper.readValue(new File(USERS_PATH), new TypeReference<List<User>>() {
        });
    }

    public Boolean signUp(User user) throws IOException {
        try {
            Optional<User> foundUser = userList.stream().filter(usr -> {
                return usr.getUsername().equals(user.getUsername());
            }).findFirst();

            if (foundUser.isPresent()) {
                System.out.println("Username already exists!");
                return false;
            }

            userList.add(user);
            saveUserListToFile();
        } catch (Exception ex) {
            System.out.println("Saving user list to file failed " + ex.getMessage());
            return false;
        }
        return true;
    }

    private void saveUserListToFile() throws IOException {
        File usersFile = new File(USERS_PATH);
        objectMapper.writeValue(usersFile, userList);
    }

    public void fetchBookings() {
        System.out.println("Fetching your bookings");
        user.printTickets();
    }

    public Optional<User> getUserByUsername(String username) {
        return userList.stream().filter(user -> user.getUsername().equals(username)).findFirst();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean cancelBooking(String ticketId) throws IOException {
        if (ticketId == null || ticketId.isEmpty()) {
            System.out.println("Ticket ID can't be null or empty.");
            return Boolean.FALSE;
        }
        boolean isRemoved = user.getTicketsBooked().removeIf(ticket -> ticket.getTicketId().equals(ticketId));
        if (isRemoved) {
            saveUserListToFile();
            System.out.println("Ticket with ID " + ticketId + " has been canceled.");
            return false;
        } else {
            System.out.println("No ticket found with ID " + ticketId);
            return false;
        }
    }

    public List<List<Integer>> fetchSeats(Train train) {
        return train.getSeats();
    }

    public Boolean bookTrainSeat(Train train, int row, int seat) {
        try {
            TrainService trainService = new TrainService();
            List<List<Integer>> seats = train.getSeats();
            if (row >= 0 && row < seats.size() && seat >= 0 && seat < seats.get(row).size()) {
                if (seats.get(row).get(seat) == 0) {
                    seats.get(row).set(seat, 1);

                    train.setSeats(seats);
                    trainService.addTrain(train);

                    Ticket ticket = new Ticket();

                    ticket.setSource(train.getStations().getFirst());
                    ticket.setDestination(train.getStations().getLast());
                    ticket.setTrain(train);
                    ticket.setUserId(user.getUserId());
                    ticket.setDateOfTravel("2025-08-22");
                    ticket.setTIcketId(UserServiceUtil.generateTicketId());

                    user.getTicketsBooked().add(ticket);

                    System.out.println("Seat boocked successfully!");

                    System.out.println(ticket.getTicketInfo());

                    saveUserListToFile();

                    return true;
                } else
                    return false;
            } else
                return false;
        } catch (IOException ex) {
            return Boolean.FALSE;
        }
    }

}
