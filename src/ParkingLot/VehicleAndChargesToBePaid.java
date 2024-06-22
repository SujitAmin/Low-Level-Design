public class VehicleAndChargesToBePaid implements PricingStrategy {
    Vehicle vehicle;
    ParkingChargingStrategy parkingChargingStrategy;
    int parkedHours;

    public VehicleAndChargesToBePaid(Vehicle vehicle, ParkingChargingStrategy parkingChargingStrategy, int parkedHours) {
        this.vehicle = vehicle;
        this.parkingChargingStrategy = parkingChargingStrategy;
        this.parkedHours = parkedHours;
    }

    public Vehicle getParkedVehicle() {
        return vehicle;
    }

    @Override
    public double getCharges(int parkedHrs) {
        return parkingChargingStrategy.calculateCharges(parkedHours);
    }
}
