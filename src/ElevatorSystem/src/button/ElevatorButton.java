package button;

public class ElevatorButton extends Button {
    private int destinationFloorNumber;
    private boolean status;

    public ElevatorButton(int destinationFloorNumber) {
        this.destinationFloorNumber = destinationFloorNumber;
        this.status = false; // Initial state is not pressed
    }

    @Override
    public void pressDown() {
        status = true;
    }

    @Override
    public boolean isPressed() {
        return status;
    }

    public void reset() {
        status = false;
    }

    public int getDestinationFloorNumber() {
        return destinationFloorNumber;
    }
}
