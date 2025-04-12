package manager;

import entity.Ticket;
import interfaces.IParkingStatus;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class ParkingStatusManager implements IParkingStatus {
    private TreeMap<Integer, Ticket> occupiedSlots;

    public ParkingStatusManager(TreeMap<Integer, Ticket> occupiedSlots) {
        this.occupiedSlots = occupiedSlots;
    }

    @Override
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


