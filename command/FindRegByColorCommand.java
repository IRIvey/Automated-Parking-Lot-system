package command;
import interfaces.IParkingQuery;

public class FindRegByColorCommand implements Command {
    private IParkingQuery parkingQuery;

    public FindRegByColorCommand(IParkingQuery parkingQuery) {
        this.parkingQuery = parkingQuery;
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 1) {
            parkingQuery.findRegistrationByColor(args[0]);
        } else {
            System.out.println("Invalid command syntax");
        }
    }
}

