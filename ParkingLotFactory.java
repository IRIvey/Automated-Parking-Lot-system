class ParkingLotFactory {
    public static ParkingLot createParkingLot(int capacity) {
        return ParkingLot.getInstance(capacity);
    }
}