package test;

import entity.Ticket;
import manager.ParkingLotManager;
import manager.ParkingQueryManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class ParkingSystemTest {

    ParkingLotManager manager;
    ParkingQueryManager query;

    @BeforeEach
    public void setup() {
        manager = new ParkingLotManager(3);
        manager.parkCar("KA-01-HH-1234", "White");
        manager.parkCar("KA-01-HH-9999", "Black");
        manager.parkCar("KA-01-BB-0001", "White");

        query = new ParkingQueryManager(manager.getOccupiedSlots());
    }

    @Test
    public void testNearestSlotAssigned() {
        ParkingLotManager m = new ParkingLotManager(2);
        Ticket t1 = m.parkCar("ABC", "Red");
        Ticket t2 = m.parkCar("XYZ", "Blue");

        assertEquals(1, t1.getSlotNumber());
        assertEquals(2, t2.getSlotNumber());
    }

    @Test
    public void testLeaveFreesSlot() {
        manager.leave(2);
        Ticket newTicket = manager.parkCar("KA-02-XX-9999", "Green");

        assertEquals(2, newTicket.getSlotNumber());
    }

    @Test
    public void testFindRegistrationByColor() {
        query.findRegistrationByColor("White");
    }

    @Test
    public void testFindSlotByRegistration() {
        query.findSlotByRegistration("KA-01-HH-9999");
    }

    @Test
    public void testFindSlotsByColor() {
        query.findSlotsByColor("White");
    }
}
