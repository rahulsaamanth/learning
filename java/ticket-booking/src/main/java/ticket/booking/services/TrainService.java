package ticket.booking.services;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import ticket.booking.entities.Train;

public class TrainService {
    private List<Train> trainList;
    private final ObjectMapper objectMapper;
    private static final String TRAIN_DB_PATH = "src/main/java/ticket/booking/localDB/trains.json";

    public TrainService() throws IOException {
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        loadTrains();
    }

    public void loadTrains() throws IOException {
        trainList = objectMapper.readValue(new File(TRAIN_DB_PATH), new TypeReference<List<Train>>() {
        });
    }

    public List<Train> searchTrains(String source, String destination) {
        try {
            return trainList.stream().filter(train -> validTrain(train, source, destination))
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            System.out.println("Error in searchTrains: " + ex.getMessage());
            return null;
        }
    }

    public boolean validTrain(Train train, String source, String destination) {
        List<String> stationList = train.getStations();

        int sourceIndex = stationList.indexOf(source);
        int destinationIndex = stationList.indexOf(destination);

        try {
            return sourceIndex != -1 && destinationIndex != -1 && sourceIndex < destinationIndex;
        } catch (Exception e) {
            System.out.println("Error in validTrain: " + e.getMessage());
            return false;
        }
    }

    public void addTrain(Train newTrain) {
        Optional<Train> existingTrain = trainList.stream()
                .filter(train -> train.getTrainId().equalsIgnoreCase(newTrain.getTrainId())).findFirst();

        if (existingTrain.isPresent())
            updateTrain(newTrain);
        else {
            trainList.add(newTrain);
            saveTraintoFile();
        }
    }

    public void saveTraintoFile() {
        try {
            objectMapper.writeValue(new File(TRAIN_DB_PATH), trainList);
        } catch (IOException e) {
            System.out.println("Failed to save train list to file: " + e.getMessage());
        }

    }

    public void updateTrain(Train updatedTrain) {
        OptionalInt index = IntStream.range(0, trainList.size())
                .filter(i -> trainList.get(i).getTrainId().equalsIgnoreCase(updatedTrain.getTrainId())).findFirst();

        if (index.isPresent()) {
            trainList.set(index.getAsInt(), updatedTrain);
            saveTraintoFile();
        } else {
            addTrain(updatedTrain);
        }
    }

    public boolean bookTickets(Train train, int row, int seat) {
        List<List<Integer>> seats = train.getSeats();
        try {
            if (row >= 0 && row < seats.size() && seat >= 0 && seat < seats.get(row).size()) {
                if (seats.get(row).get(seat) == 0) {
                    seats.get(row).set(seat, 1);
                    train.setSeats(seats);
                    addTrain(train);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            System.out.println("Error in booking Tickets: " + e.getMessage());
            return false;
        }
    }
}
