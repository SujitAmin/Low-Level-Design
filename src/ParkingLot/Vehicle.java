public class Vehicle {
    private String registrationNumber;
    private String ownerName;
    private VEHICLE_TYPE type;


    public Vehicle(String registrationNumber, String ownerName, VEHICLE_TYPE type) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.type = type;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public VEHICLE_TYPE getType() {
        return type;
    }
}
