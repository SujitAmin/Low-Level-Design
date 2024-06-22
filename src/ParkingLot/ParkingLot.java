import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class ParkingLot {
    private Slot[] fourWheelerSlots;
    private Slot[] twoWheelerSlots;
    private static ParkingLot instance;


    public static ParkingLot getInstance(int noOfTwoWheelerSlots, int noOfFourWheelerSlots) {
        if (instance == null) {
            instance = new ParkingLot(noOfTwoWheelerSlots, noOfFourWheelerSlots);
        }
        return instance;
    }


    private ParkingLot(int noOfTwoWheelerSlots, int noOfFourWheelerSlots) {
        this.fourWheelerSlots = SlotFactory.createSlots(noOfFourWheelerSlots, VEHICLE_TYPE.FOUR_WHEELER) ;
        this.twoWheelerSlots = SlotFactory.createSlots(noOfTwoWheelerSlots, VEHICLE_TYPE.TWO_WHEELER);

    }

    public Ticket parkAVehicle(Vehicle vehicle) throws ParkingFullException {
        var nextAvailableSlot = this.getNextAvailableSlot(vehicle.getType());
        nextAvailableSlot.setParkedVehicle(vehicle);
        return generateTicket(vehicle, nextAvailableSlot);
    }

    private Ticket generateTicket(Vehicle vehicle, Slot nextAvailableSlot) {
        return new Ticket(nextAvailableSlot.slotNo(), vehicle.getRegistrationNumber(), vehicle.getType(), new Date());
    }

    private Slot getNextAvailableSlot(VEHICLE_TYPE
                                       vehicleType) throws ParkingFullException {
        if (vehicleType == VEHICLE_TYPE.FOUR_WHEELER) {
            return this.getNextAvailableFourWheelerSlot();
        }
        return getNextAvailableTwoWheelerSlot();
    }

    private Slot getNextAvailableFourWheelerSlot() throws ParkingFullException {
        return getAvailableSlot( fourWheelerSlots, VEHICLE_TYPE.FOUR_WHEELER);
    }

    private Slot getNextAvailableTwoWheelerSlot() throws ParkingFullException {
        return getAvailableSlot(this.twoWheelerSlots, VEHICLE_TYPE.TWO_WHEELER);
    }

    private Slot getAvailableSlot(Slot[] listOfSlots, VEHICLE_TYPE vehicleType) throws ParkingFullException {
        for (var slot : listOfSlots) {
            if (slot.isEmpty()) {
                return slot;
            }
        }
        throw new ParkingFullException(vehicleType);
    }

    public VehicleAndChargesToBePaid unPark(Ticket ticket, ParkingChargingStrategy parkingChargingStrategy) throws ParkingNotFoundException {
        var parkedVehicleSlot = this.getParkedVehicleSlot(ticket);
        Vehicle vehicle = parkedVehicleSlot.getParkedVehicle();
        parkedVehicleSlot.vacateSlot();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        int parkedHours = this.getParkedHours( calendar.getTime() , new Date());
        return new VehicleAndChargesToBePaid(vehicle, parkingChargingStrategy, parkedHours);
    }

    private Slot getParkedVehicleSlot(Ticket ticket) throws ParkingNotFoundException {
        if (ticket.vehicleType() == VEHICLE_TYPE.FOUR_WHEELER) return this.getParkedFourWheeler(ticket);
        return this.getParkedTwoWheeler(ticket);
    }

    private Slot getParkedTwoWheeler(Ticket ticket) throws ParkingNotFoundException {
        return this.getSlot(this.twoWheelerSlots, ticket, VEHICLE_TYPE.TWO_WHEELER);
    }

    private Slot getParkedFourWheeler(Ticket ticket) throws ParkingNotFoundException {
        return this.getSlot(this.fourWheelerSlots, ticket, VEHICLE_TYPE.FOUR_WHEELER);
    }

    private Slot getSlot(Slot[] slots, Ticket ticket, VEHICLE_TYPE type) throws ParkingNotFoundException {
        for (var slot : slots) {
            if (slot.slotNo() == ticket.slotNo() && slot.getParkedVehicle().getRegistrationNumber().equals(ticket.vehicleNo()))
                return slot;
        }
        throw new ParkingNotFoundException(type);
    }

    private int getParkedHours(Date startDate, Date endDate) {
        int MILLISECOND_IN_A_SECOND = 1000;
        int SECONDS_IN_A_HOUR = 3600;
        long secondsSpent = (endDate.getTime() - startDate.getTime()) / MILLISECOND_IN_A_SECOND;
        return (int) (secondsSpent / SECONDS_IN_A_HOUR);
    }

}
