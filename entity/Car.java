package entity;

public class Car {

        private String registrationNo;
        private String color;

        public Car(String registrationNo, String color) {
            this.registrationNo = registrationNo;
            this.color = color;
        }

        public String getRegistrationNo() {
            return registrationNo;
        }

        public String getColor() {
            return color;
        }
    }

