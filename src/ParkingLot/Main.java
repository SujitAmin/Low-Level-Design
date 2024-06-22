public class Main {
    public static void main(String[] args) {
        try {
            // Initialize the parking lot
            ParkingLot parkingLot = ParkingLot.getInstance(2, 2);

            // Create vehicles
            Vehicle car1 = new Vehicle("Sujit Amin", "CAR123", VEHICLE_TYPE.FOUR_WHEELER);
            Vehicle bike1 = new Vehicle("Sumanth Amin","BIKE123", VEHICLE_TYPE.TWO_WHEELER);

            // Park vehicles
            Ticket carTicket = parkingLot.parkAVehicle(car1);
            Ticket bikeTicket = parkingLot.parkAVehicle(bike1);

            // Unpark vehicles
            ParkingChargingStrategy fourWheelerStrategy = new FourWheelerParkingStrategy();
            ParkingChargingStrategy twoWheelerStrategy = new TwoWheelerChargingStrategy();
            VehicleAndChargesToBePaid bikeDetails = parkingLot.unPark(bikeTicket, twoWheelerStrategy);

            System.out.println("Bike charges: " + bikeDetails.getCharges(100));
        } catch (ParkingFullException | ParkingNotFoundException e) {
            e.printStackTrace();
        }
    }
}
