public class Door {
    private DoorState state;

    public Door() {
        state = DoorState.OPEN;
    }

    public boolean isOpen() {
        return state == DoorState.OPEN;
    }

    public void open() {
        state = DoorState.OPEN;
    }

    public void close() {
        state = DoorState.CLOSE;
    }
}
