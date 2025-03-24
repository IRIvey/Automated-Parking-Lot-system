import java.util.*;

class ParkingQueryManager implements IParkingQuery {
    private TreeMap<Integer, Ticket> occupiedSlots;

    public ParkingQueryManager(TreeMap<Integer, Ticket> occupiedSlots) {
        this.occupiedSlots = occupiedSlots;
    }

    @Override
    public void findRegistrationByColor(String color) {
        List<String> regNumbers = new ArrayList<>();
        for (Ticket ticket : occupiedSlots.values()) {
            if (ticket.getCar().getColor().equalsIgnoreCase(color)) {
                regNumbers.add(ticket.getCar().getRegistrationNo());
            }
        }
        System.out.println(regNumbers.isEmpty() ? "Not found" : String.join(", ", regNumbers));
    }

    @Override
    public void findSlotByRegistration(String regNumber) {
        for (Map.Entry<Integer, Ticket> entry : occupiedSlots.entrySet()) {
            if (entry.getValue().getCar().getRegistrationNo().equalsIgnoreCase(regNumber)) {
                System.out.println(entry.getKey());
                return;
            }
        }
        System.out.println("Not found");
    }

    @Override
    public void findSlotsByColor(String color) {
        List<Integer> slots = new ArrayList<>();
        for (Map.Entry<Integer, Ticket> entry : occupiedSlots.entrySet()) {
            if (entry.getValue().getCar().getColor().equalsIgnoreCase(color)) {
                slots.add(entry.getKey());
            }
        }
        System.out.println(slots.isEmpty() ? "Not found" : slots.toString().replaceAll("[\\[\\]]", ""));
    }


    public void status() {
        if (occupiedSlots.isEmpty()) {
            System.out.println("Parking lot is empty");
            return;
        }
        System.out.println("Slot No. | Registration No. | Colour");
        for (Map.Entry<Integer, Ticket> entry : occupiedSlots.entrySet()) {
            System.out.println(entry.getKey() + " | " + entry.getValue().getCar().getRegistrationNo() + " | " + entry.getValue().getCar().getColor());
        }
    }
}
