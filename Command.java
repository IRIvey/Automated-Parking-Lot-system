class Command {
    private ParkingLot parkingLot;


    public void processCommand(String command) {
        String[] parts = command.split(" ");
        switch (parts[0]) {
            case "create_parking_lot":
                if (parts.length == 2) {
                    int capacity = Integer.parseInt(parts[1]);
                    parkingLot = ParkingLotFactory.createParkingLot(capacity);
                    System.out.println("Created a parking lot with " + capacity + " slots");
                } else {
                    System.out.println("Invalid command syntax");
                }
                break;
            case "park":
                if (parts.length == 3 && parkingLot != null) {
                    parkingLot.parkCar(parts[1], parts[2]);
                } else {
                    System.out.println("Invalid command or parking lot not initialized");
                }
                break;
            case "leave":
                if (parts.length == 2 && parkingLot != null) {
                    int slot = Integer.parseInt(parts[1]);
                    parkingLot.leave(slot);
                } else {
                    System.out.println("Invalid command or parking lot not initialized");
                }
                break;
            case "status":
                if (parkingLot != null) {
                    parkingLot.status();
                } else {
                    System.out.println("Parking lot not initialized");
                }
                break;
            case "registration_numbers_for_cars_with_colour":
                if (parts.length == 2 && parkingLot != null) {
                    parkingLot.findRegistrationByColor(parts[1]);
                } else {
                    System.out.println("Invalid command or parking lot not initialized");
                }
                break;
            case "slot_number_for_registration_number":
                if (parts.length == 2 && parkingLot != null) {
                    parkingLot.findSlotByRegistration(parts[1]);
                } else {
                    System.out.println("Invalid command or parking lot not initialized");
                }
                break;
            case "slot_numbers_for_cars_with_colour":
                if (parts.length == 2 && parkingLot != null) {
                    parkingLot.findSlotsByColor(parts[1]);
                } else {
                    System.out.println("Invalid command or parking lot not initialized");
                }
                break;
            case "exit":
                System.out.println("Exiting system...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid command");
        }
    }
}

