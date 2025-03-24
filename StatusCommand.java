class StatusCommand implements Command {
    private ParkingQueryManager parkingQuery;

    public StatusCommand(ParkingQueryManager parkingQuery) {
        this.parkingQuery = parkingQuery;
    }

    @Override
    public void execute(String[] args) {
        parkingQuery.status();
    }
}
