class LeaveCommand implements Command {
    private IParkingLot parkingLot;

    public LeaveCommand(IParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 1) {
            parkingLot.leave(Integer.parseInt(args[0]));
        }
    }
}