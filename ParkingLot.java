class ParkingLot {
    private static ParkingLot parkingLot ;
    private int capacity ;
    private TreeMap<Integer, Ticket> occupiedSlots ;
    private PriorityQueue<Integer> availableSlots ;

    private ParkingLot(int capacity) {
        this.capacity = capacity;
        this.occupiedSlots = new TreeMap<>();
        this.availableSlots = new PriorityQueue<>();


        for (int i = 1; i <= capacity; i++) {
            availableSlots.add(i);
        }
    }


    public static ParkingLot getparkingLot(int capacity) {
        if (parkingLot == null) {
            parkingLot = new ParkingLot(capacity);
        }
        return parkingLot ;
    }


    public Ticket parkCar(String regNumber, String color) {
        if (availableSlots.isEmpty()) {
            System.out.println("Sorry!!parking lot is full.");
            return null;
        }
        int slot = availableSlots.poll();
        Car car = new Car(regNumber, color);
        Ticket ticket = new Ticket(slot, car);
        occupiedSlots.put(slot, ticket);
        System.out.println("Allocated slot number: " + slot);
        return ticket;
    }


    public void leave(int slotNumber) {
        if (occupiedSlots.containsKey(slotNumber)) {
            occupiedSlots.remove(slotNumber);
            availableSlots.add(slotNumber);
            System.out.println("Slot number " + slotNumber + " is free");
        } else {
            System.out.println("Slot number " + slotNumber + " is already vacant or invalid");
        }
    }


    public void status() {
        if (occupiedSlots.isEmpty()) {
            System.out.println("Parking lot is empty");
            return;
        }
        System.out.println("Slot No. | Registration No. | Colour");
        for (Map.Entry<Integer, Ticket> entry : occupiedSlots.entrySet()) {
            System.out.println(entry.getKey() + " | " + entry.getValue().getCar().getRegistrationNumber() + " | " + entry.getValue().getCar().getColor());
        }
    }


    public void findRegistrationByColor(String color) {
        List<String> regNumbers = new ArrayList<>();
        for (Ticket ticket : occupiedSlots.values()) {
            if (ticket.getCar().getColor().equalsIgnoreCase(color)) {
                regNumbers.add(ticket.getCar().getRegistrationNumber());
            }
        }
        System.out.println(regNumbers.isEmpty() ? "Not found" : String.join(", ", regNumbers));
    }


    public void findSlotByRegistration(String regNumber) {
        for (Map.Entry<Integer, Ticket> entry : occupiedSlots.entrySet()) {
            if (entry.getValue().getCar().getRegistrationNumber().equalsIgnoreCase(regNumber)) {
                System.out.println(entry.getKey());
                return;
            }
        }
        System.out.println("Not found");
    }

   
    public void findSlotsByColor(String color) {
        List<Integer> slots = new ArrayList<>();
        for (Map.Entry<Integer, Ticket> entry : occupiedSlots.entrySet()) {
            if (entry.getValue().getCar().getColor().equalsIgnoreCase(color)) {
                slots.add(entry.getKey());
            }
        }
        System.out.println(slots.isEmpty() ? "Not found" : slots.toString().replaceAll("[\\[\\]]", ""));
    }
}
