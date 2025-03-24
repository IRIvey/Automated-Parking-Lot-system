class FindSlotByRegCommand implements Command {
    private IParkingQuery parkingQuery;

    public FindSlotByRegCommand(IParkingQuery parkingQuery) {
        this.parkingQuery = parkingQuery;
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 1) {
            parkingQuery.findSlotByRegistration(args[0]);
        } else {
            System.out.println("Invalid command syntax");
        }
    }
}
