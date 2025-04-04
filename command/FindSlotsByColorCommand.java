package command;

class FindSlotsByColorCommand implements Command {
    private IParkingQuery parkingQuery;

    public FindSlotsByColorCommand(IParkingQuery parkingQuery) {
        this.parkingQuery = parkingQuery;
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 1) {
            parkingQuery.findSlotsByColor(args[0]);
        } else {
            System.out.println("Invalid command syntax");
        }
    }
}

