package command;

import interfaces.IParkingStatus;
import java.util.List;

public class StatusCommand implements Command {
    private IParkingStatus parkingStatusManager;

    public StatusCommand(IParkingStatus parkingStatusManager) {
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
