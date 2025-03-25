import java.util.HashMap;
import java.util.Map;

class CommandProcessor {
    private Map<String, Command> commands = new HashMap<>();
    private IParkingLot parkingLot;
    private ParkingQueryManager parkingQuery;
    private ParkingStatusManager parkingStatusManager;

    public void setParkingLot(IParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        this.parkingQuery = new ParkingQueryManager(((ParkingLotManager) parkingLot).getOccupiedSlots());
        this.parkingStatusManager = new ParkingStatusManager(((ParkingLotManager) parkingLot).getOccupiedSlots());


        commands.put("status", new StatusCommand(parkingStatusManager));
        commands.put("park", new ParkCommand(parkingLot));
        commands.put("leave", new LeaveCommand(parkingLot));
        commands.put("registration_numbers_for_cars_with_colour", new FindRegByColorCommand(parkingQuery));
        commands.put("slot_number_for_registration_number", new FindSlotByRegCommand(parkingQuery));
        commands.put("slot_numbers_for_cars_with_colour", new FindSlotsByColorCommand(parkingQuery));
    }

    public CommandProcessor() {
        commands.put("create_parking_lot", new CreateParkingLotCommand(this));
        commands.put("exit", new ExitCommand());
    }

    public void processCommand(String commandInput) {
        String[] parts = commandInput.split(" ");
        String commandName = parts[0];
        String[] args = parts.length > 1 ? java.util.Arrays.copyOfRange(parts, 1, parts.length) : new String[0];

        Command command = commands.get(commandName);
        if (command != null) {
            command.execute(args);
        } else {
            System.out.println("Invalid command");
        }
    }
}

