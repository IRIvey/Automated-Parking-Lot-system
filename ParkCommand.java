class ParkCommand implements Command {
    private IParkingLot parkingLot;

    public ParkCommand(IParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 2) {
            parkingLot.parkCar(args[0], args[1]);
        } else {
            System.out.println("Invalid command syntax");
        }
    }
}