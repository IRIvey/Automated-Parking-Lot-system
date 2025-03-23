import java.util.*;

class ParkingLotManager implements IParkingLot {
    private int capacity;
    private TreeMap<Integer, Ticket> occupiedSlots;
    private PriorityQueue<Integer> availableSlots;

    public ParkingLotManager(int capacity) {
        this.capacity = capacity;
        this.occupiedSlots = new TreeMap<>();
        this.availableSlots = new PriorityQueue<>();
        for (int i = 1; i <= capacity; i++) {
            availableSlots.add(i);
        }
    }

    @Override
    public Ticket parkCar(String regNumber, String color) {
        if (availableSlots.isEmpty()) {
            System.out.println("Sorry, parking lot is full");
            return null;
        }
        int slot = availableSlots.poll();
        Car car = new Car(regNumber, color);
        Ticket ticket = new Ticket(slot, car);
        occupiedSlots.put(slot, ticket);
        System.out.println("Allocated slot number: " + slot);
        return ticket;
    }

    @Override
    public void leave(int slotNumber) {
        if (occupiedSlots.containsKey(slotNumber)) {
            occupiedSlots.remove(slotNumber);
            availableSlots.add(slotNumber);
            System.out.println("Slot number " + slotNumber + " is free");
        } else {
            System.out.println("Slot number " + slotNumber + " is already vacant or invalid");
        }
    }

    public TreeMap<Integer, Ticket> getOccupiedSlots() {
        return occupiedSlots;
    }
}
