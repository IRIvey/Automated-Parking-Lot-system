package interfaces;

import entity.Ticket;


public interface IParkingLot {

    Ticket parkCar(String regNumber, String color);
    void leave(int slotNumber);

}