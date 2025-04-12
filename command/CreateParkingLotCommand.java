package command;

import factory.ParkingLotFactory;


public class CreateParkingLotCommand implements Command {
    private CommandProcessor processor;

    public CreateParkingLotCommand(CommandProcessor processor) {
        this.processor = processor;
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 1) {
            int capacity = Integer.parseInt(args[0]);
            processor.setParkingLot(ParkingLotFactory.createParkingLot(capacity));
            System.out.println("Created a parking lot with " + capacity + " slots");
        } else {
            System.out.println("Invalid command syntax");
        }
    }
}