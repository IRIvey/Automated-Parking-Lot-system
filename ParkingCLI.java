import java.util.Scanner;


public class ParkingCLI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Command processor = new Command();

        while (true) {
            String command = scanner.nextLine();
            processor.processCommand(command);
        }
    }
}
