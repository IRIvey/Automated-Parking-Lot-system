package factory;

import interfaces.IParkingLot;
import manager.ParkingLotManager;


public class ParkingLotFactory {
    public static IParkingLot createParkingLot(int capacity) {
        return new ParkingLotManager(capacity);
    }
}
