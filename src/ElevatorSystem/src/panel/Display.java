package panel;

import button.Direction;

public class Display extends AbstractDisplay {

    public Display() {
        this.floor = 1;
        this.capacity = 8;
        this.direction = Direction.UP;
    }

    public void updateElevatorDisplay(int floor, int capacity, Direction direction) {
        this.floor = floor;
        this.capacity = capacity;
        this.direction = direction;
        showElevatorDisplay();
    }

    public void updateHallDisplay(int floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
        showHallDisplay();
    }

    public void showElevatorDisplay() {
        System.out.println("Elevator at Floor: " + floor + ", Capacity: " + capacity + ", Direction: " + direction);
    }

    public void showHallDisplay() {
        //System.out.println("Elevator at Floor: " + floor + ", Direction: " + direction);
    }
}
