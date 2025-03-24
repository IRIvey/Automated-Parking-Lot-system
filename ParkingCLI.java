import java.util.Scanner;

public class ParkingCLI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter parking lot size: ");
        int size = scanner.nextInt();
        scanner.nextLine();

        ParkingLotManager parkingLot = new ParkingLotManager(size);
        ParkingQueryManager queryService = new ParkingQueryManager(parkingLot.getOccupiedSlots());

        CommandProcessor processor = new CommandProcessor();
        processor.registerCommand("park", new ParkCommand(parkingLot));
        processor.registerCommand("leave", new LeaveCommand(parkingLot));

        while (true) {
            String command = scanner.nextLine();
            processor.processCommand(command);
        }
    }
}
