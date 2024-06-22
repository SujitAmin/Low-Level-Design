public class TwoWheelerChargingStrategy implements ParkingChargingStrategy {
    @Override
    public double calculateCharges(int parkedHrs) {
        if (parkedHrs < 1) {
            return 1;
        }
        return parkedHrs * 10;
    }
}
