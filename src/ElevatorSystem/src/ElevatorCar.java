import button.Direction;
import panel.Display;
import panel.ElevatorPanel;

public class ElevatorCar {
    private int id;
    private Door door;
    private ElevatorState state;
    private Display display;
    private ElevatorPanel panel;
    private int currentFloor;
    private int targetFloor;
    private int capacity;

    public ElevatorCar(int id, int numberOfFloors, Display display, ElevatorPanel panel) {
        this.id = id;
        door = new Door();
        state = ElevatorState.IDLE;
        this.display = display;
        this.panel = panel;
        currentFloor = 1; // Assume ground or first floor as initial floor
        targetFloor = 1;
        capacity = numberOfFloors;
    }

    public void move() {
        if (targetFloor > currentFloor) {
            state = ElevatorState.UP;
            while (currentFloor < targetFloor) {
                currentFloor++;
                display.updateElevatorDisplay(currentFloor, capacity, Direction.UP);
            }
        } else if (targetFloor < currentFloor) {
            state = ElevatorState.DOWN;
            while (currentFloor > targetFloor) {
                currentFloor--;
                display.updateElevatorDisplay(currentFloor, capacity, Direction.DOWN);
            }
        }
        stop();
    }

    public void stop() {
        state = ElevatorState.IDLE;
        display.updateElevatorDisplay(currentFloor, capacity, Direction.UP);
        openDoor();
    }

    public void openDoor() {
        if (state == ElevatorState.IDLE) {
            door.open();
            display.updateElevatorDisplay(currentFloor, capacity, Direction.UP);
        }
    }

    public void closeDoor() {
        door.close();
    }

    public void setTargetFloor(int targetFloor) {
        this.targetFloor = targetFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getId() {
        return id;
    }

    public void addPassenger(int capacity) {
        this.capacity += capacity;
        display.updateElevatorDisplay(currentFloor, this.capacity, Direction.UP);
    }

    public void removePassenger(int capacity) {
        this.capacity -= capacity;
        display.updateElevatorDisplay(currentFloor, this.capacity, Direction.UP);
    }
}
