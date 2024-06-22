public class ParkingStrategyFactory {
    public static ParkingChargingStrategy getParkingChargingStrategy(VEHICLE_TYPE vehicleType) {
        if (vehicleType == VEHICLE_TYPE.FOUR_WHEELER) {
            return new FourWheelerParkingStrategy();
        } else {
            return new TwoWheelerChargingStrategy();
        }
    }
}
