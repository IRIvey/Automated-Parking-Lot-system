import java.util.Scanner;

public class ParkingCLI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommandProcessor processor = new CommandProcessor();

        while (true) {
            String command = scanner.nextLine();
            processor.processCommand(command);
        }
    }
}

