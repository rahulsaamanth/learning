package ticket.booking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

import ticket.booking.entities.Train;
import ticket.booking.entities.User;
import ticket.booking.services.UserBookingService;
import ticket.booking.utils.UserServiceUtil;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to my Ticket Booking System!");
        Scanner sc = new Scanner(System.in);
        int option = 0;
        UserBookingService userBookingService;

        try {
            userBookingService = new UserBookingService();
        } catch (IOException ex) {
            System.out.println("There is something wrong!" + ex.getMessage());
            sc.close();
            return;
        }

        Train trainSelectedForBooking = null;
        while (option != 7) {
            System.out.println("Choose Option");
            System.out.println("1. Sign up");
            System.out.println("2. Login");
            System.out.println("3. Fetch Bookings");
            System.out.println("4. Search Trains");
            System.out.println("5. Book a seat");
            System.out.println("6. Cancel my booking");
            System.out.println("7. Exit the App");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    String signUpName;
                    while (true) {
                        System.out.println("Enter your username to signup: ");
                        signUpName = sc.nextLine();
                        if (signUpName.contains(" ")) {
                            System.out.println("Username can't contain spaces!");
                        } else
                            break;
                    }
                    System.out.println("Enter your password: ");
                    String signUpPass = sc.nextLine();
                    User userToSignup = new User(signUpName, signUpPass, UserServiceUtil.hashPassword(signUpPass),
                            new ArrayList<>(), UUID.randomUUID().toString());
                    try {
                        boolean userDuplicate = userBookingService.signUp(userToSignup);
                        if (userDuplicate)
                            System.out.println("Sign up successfull!");
                    } catch (IOException ex) {
                        System.out.println("Can SignUp User!");
                    }
                    break;

                case 2:
                    System.out.println("Enter the username to login:");
                    String username;
                    while (true) {
                        username = sc.nextLine();
                        if (username.contains(" ")) {
                            System.out.println("Username cannot contain spaces!");
                        } else
                            break;
                    }
                    System.out.println("Enter your password: ");
                    String password = sc.nextLine();

                    Optional<User> foundUser = userBookingService.getUserByUsername(username);
                    if (foundUser.isPresent()
                            && UserServiceUtil.checkPassword(password, foundUser.get().getHashedPassword())) {
                        System.out.println("Login sucessful! Welcome " + username);
                        userBookingService.setUser(foundUser.get());
                    } else
                        System.out.println("Login failed");
                    break;
                case 3:
                    try {
                        userBookingService.fetchBookings();
                    } catch (Exception ex) {
                        System.out.println("There is something wrong!");
                    }
                    break;
                case 4:
                    System.out.println("Enter the source station: ");
                    String source = sc.nextLine().toLowerCase();
                    System.out.println("Enter the destination station: ");
                    String destination = sc.nextLine().toLowerCase();

                    List<Train> trains = new ArrayList<>();
                    try {
                        trains = userBookingService.getTrains(source, destination);
                    } catch (IOException ex) {
                        System.out.println("Error fetching trains: " + ex.getMessage());
                        break;
                    }

                    if (trains.isEmpty()) {
                        System.out.println("No trains available between " + source + " and " + destination);
                        break;
                    }

                    System.out.println("Availale Trains: ");
                    int index = 1;
                    for (Train t : trains) {
                        System.out.println(index + ". Train ID: " + t.getTrainId() + " | Train No: " + t.getTrainNo());
                        System.out.println("  Route  " + String.join(". ", t.getStations()));
                        System.out.println("  Timings:");
                        for (Map.Entry<String, String> entry : t.getStationtimes().entrySet()) {
                            System.out.println("    " + entry.getKey() + " - " + entry.getValue());

                        }
                        index++;
                    }

                    System.out.println("Selct a train by typing the corresponding number: ");

                    int selectedIndex;
                    while (true) {
                        if (sc.hasNextInt()) {
                            selectedIndex = sc.nextInt();
                            sc.nextLine();
                            if (selectedIndex > 0 && selectedIndex <= trains.size())
                                break;
                            else
                                System.out.println("Invalid choice ! Please select a valid train number.");
                        } else {
                            System.out.println("Please enter a valid number");
                            sc.next();
                        }

                    }
                    trainSelectedForBooking = trains.get(selectedIndex - 1);
                    System.out.println("Train selected: " + trainSelectedForBooking.getTrainId());

                    System.out.println("Available Seats:");
                    for (List<Integer> row : trainSelectedForBooking.getSeats()) {
                        for (Integer seat : row) {
                            System.out.println(seat + "");
                        }
                        System.out.println();
                    }
                    break;
                case 5:
                    if (trainSelectedForBooking == null) {
                        System.out.println("Please select a train first in option 4!");
                        break;
                    }
                    System.out.println("Select a seat out of these seats");

                    List<List<Integer>> seats = userBookingService.fetchSeats(trainSelectedForBooking);

                    for (List<Integer> row : seats) {
                        for (Integer val : row) {
                            System.out.println(val + " ");
                        }
                        System.out.println();
                    }

                    System.out.println("Select the seat by typing the row and column");

                    System.out.println("Enter the row");
                    int row = sc.nextInt();

                    System.out.println("Enter the column");
                    int col = sc.nextInt();

                    System.out.println("Booking your seat...");

                    boolean booked = userBookingService.bookTrainSeat(trainSelectedForBooking, row, col);

                    if (booked)
                        System.out.println("Ticket(s) Booked!, Enjoy your journey");
                    else
                        System.out.println("Can't book this seat");

                    break;

                case 6:
                    System.out.println("ENter the ticket id to cancel the booking");
                    String ticketId = sc.nextLine();
                    try {
                        boolean isCancelled = userBookingService.cancelBooking(ticketId);
                        if (isCancelled)
                            System.out.println("Booking cancelled successfuly!");
                    } catch (IOException ex) {
                        System.out.println("Booking not found " + ex.getMessage());
                        break;
                    }

                default:
                    break;
            }
        }
        sc.close();
    }

}
