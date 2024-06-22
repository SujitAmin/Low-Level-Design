public class SlotFactory {

    public static Slot[] createSlots(int numberOfSlots, VEHICLE_TYPE type) {
        Slot[] slots = new Slot[numberOfSlots];
        for (int i = 0; i < numberOfSlots; i++) {
            slots[i] = new Slot(type);
        }
        return slots;
    }
}
