public class Slot {
    static long slotCounter = 1;
    long slotNo;
    Vehicle parkedVehicle;
    private VEHICLE_TYPE type;

    public Slot(VEHICLE_TYPE type) {
        this.slotNo = slotCounter++;
        this.parkedVehicle = null;
        this.type = type;
    }


    public long getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(long slotNo) {
        this.slotNo = slotNo;
    }

    public boolean isEmpty() {
        return parkedVehicle == null;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void setParkedVehicle(Vehicle parkedVehicle) {
        this.parkedVehicle = parkedVehicle;
    }

    public long slotNo() {
        return this.slotNo;
    }

    public void vacateSlot() {
        this.parkedVehicle = null;
    }

    public VEHICLE_TYPE getType() {
        return this.type;
    }
}