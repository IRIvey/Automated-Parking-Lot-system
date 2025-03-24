class ParkingLotFactory {
    public static IParkingLot createParkingLot(int capacity) {
        return new ParkingLotManager(capacity);
    }
}
