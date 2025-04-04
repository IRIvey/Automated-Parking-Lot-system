package command;

class LeaveCommand implements Command {
    private IParkingLot parkingLot;

    public LeaveCommand(IParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 1) {
            int slot = Integer.parseInt(args[0]);
            parkingLot.leave(slot);
        } else {
            System.out.println("Invalid command syntax");
        }
    }
}