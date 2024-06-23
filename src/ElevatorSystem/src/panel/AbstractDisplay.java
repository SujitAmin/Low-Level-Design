package panel;

import button.Direction;

public abstract class AbstractDisplay {
    public int floor;
    public int capacity;
    public Direction direction;

    public abstract void updateElevatorDisplay(int floor, int capacity, Direction direction);
    public abstract void updateHallDisplay(int floor, Direction direction);
}