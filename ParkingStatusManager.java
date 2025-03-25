import java.util.*;

class ParkingStatusManager {
    private TreeMap<Integer, Ticket> occupiedSlots;

    public ParkingStatusManager(TreeMap<Integer, Ticket> occupiedSlots) {
        this.occupiedSlots = occupiedSlots;
    }

    public List<String> getStatus() {
        List<String> statusList = new ArrayList<>();
        if (occupiedSlots.isEmpty()) {
            statusList.add("Parking lot is empty");
        } else {
            statusList.add("Slot No. | Registration No. | Colour");
            for (Map.Entry<Integer, Ticket> entry : occupiedSlots.entrySet()) {
                statusList.add(entry.getKey() + " | " +
                        entry.getValue().getCar().getRegistrationNo() + " | " +
                        entry.getValue().getCar().getColor());
            }
        }
        return statusList;

    }
}

