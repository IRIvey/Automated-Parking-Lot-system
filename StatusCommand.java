import java.util.List;

class StatusCommand implements Command {
    private ParkingStatusManager parkingStatusManager;

    public StatusCommand(ParkingStatusManager parkingStatusManager) {
        this.parkingStatusManager = parkingStatusManager;
    }

    @Override
    public void execute(String[] args) {
        List<String> statusList = parkingStatusManager.getStatus();
        for (String line : statusList) {
            System.out.println(line);
        }
    }
}

