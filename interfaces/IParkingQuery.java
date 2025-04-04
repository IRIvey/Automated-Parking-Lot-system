package interfaces;

public interface IParkingQuery {

    void findRegistrationByColor(String color);
    void findSlotByRegistration(String regNumber);
    void findSlotsByColor(String color);

}
