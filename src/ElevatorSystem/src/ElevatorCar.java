import button.Direction;
import panel.Display;
import panel.ElevatorPanel;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

enum Algorithm {
    SSTF,
    LOOK
}
public class ElevatorCar {
    private int id;
    private Door door;
    private ElevatorState state;
    private Display display;
    private ElevatorPanel panel;
    private int currentFloor;
    private int targetFloor;
    private int capacity;
    private List<Integer> floorRequests;

    public ElevatorCar(int id, int numberOfFloors, Display display, ElevatorPanel panel) {
        this.id = id;
        door = new Door();
        state = ElevatorState.IDLE;
        this.display = display;
        this.panel = panel;
        currentFloor = 1; // Assume ground or first floor as initial floor
        targetFloor = 1;
        capacity = numberOfFloors;
        floorRequests = new ArrayList<>();
    }
    // FCFS (First-Come, First-Served)
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


    public void requestFloor(int floor) {
        floorRequests.add(floor);
        Collections.sort(floorRequests); // Keep requests sorted
    }

    public void moveSSTF(Algorithm algorithm) {
        while (!floorRequests.isEmpty()) {
            int closestFloor = findClosestFloor();
            if (closestFloor > currentFloor) {
                state = ElevatorState.UP;
                display.direction = Direction.UP;
                while (currentFloor < closestFloor) {
                    currentFloor++;
                    display.updateElevatorDisplay(currentFloor, capacity, Direction.UP);
                }
            } else if (closestFloor < currentFloor) {
                state = ElevatorState.DOWN;
                display.direction = Direction.DOWN;
                while (currentFloor > closestFloor) {
                    currentFloor--;
                    display.updateElevatorDisplay(currentFloor, capacity, Direction.DOWN);
                }
            }
            stop();
            floorRequests.remove(Integer.valueOf(closestFloor));
        }
    }

    // Elevator Algorithm (SCAN):  This strategy moves the elevator in one direction, serving all requests in that direction,
    // then reverses direction and serves requests in the opposite direction, similar to the movement of an elevator.
    // The provided code does not account for continuous movement in one direction
    // before reversing; it directly moves to the specified targetFloor.
    // LOOK Similar to the Elevator Algorithm but instead of moving to the end of the direction,
    // it only goes as far as the last request in that direction.
    // Again, the provided code does not check for other requests but directly moves to the specified targetFloor.
    private void moveLOOK() {
        while (!floorRequests.isEmpty()) {
            if (display.direction == Direction.UP) {
                Iterator<Integer> iterator = floorRequests.iterator();
                while (iterator.hasNext()) {
                    int floor = iterator.next();
                    if (floor > currentFloor) {
                        state = ElevatorState.UP;
                        while (currentFloor < floor) {
                            currentFloor++;
                            display.updateElevatorDisplay(currentFloor, capacity, Direction.UP);
                        }
                        stop();
                        iterator.remove();
                    }
                }
                display.direction = Direction.DOWN;
            } else {
                Iterator<Integer> iterator = floorRequests.iterator();
                while (iterator.hasNext()) {
                    int floor = iterator.next();
                    if (floor < currentFloor) {
                        state = ElevatorState.DOWN;
                        while (currentFloor > floor) {
                            currentFloor--;
                            display.updateElevatorDisplay(currentFloor, capacity, Direction.DOWN);
                        }
                        stop();
                        iterator.remove();
                    }
                }
                display.direction = Direction.UP;
            }
        }
    }

    private int findClosestFloor() {
        int closestFloor = floorRequests.get(0);
        int minDistance = Math.abs(currentFloor - closestFloor);
        for (int floor : floorRequests) {
            int distance = Math.abs(currentFloor - floor);
            if (distance < minDistance) {
                minDistance = distance;
                closestFloor = floor;
            }
        }
        return closestFloor;
    }

    // Shortest Seek Time First (SSTF) This algorithm serves
    // the request closest to the current position of the elevator, minimizing movement.
    // The provided code does not check for the closest target but instead moves directly to the specified targetFloor.
    public void moveSSTF() {

    }

//    public void moveSCAN() {
//
//    }




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

    public void addPassenger(int capacity) throws Exception {
        if (capacity + this.capacity > 8) {
            throw new Exception("Full capacity");
        }
        this.capacity += capacity;
        display.updateElevatorDisplay(currentFloor, this.capacity, Direction.UP);
    }

    public void removePassenger(int capacity) {
        this.capacity -= capacity;
        display.updateElevatorDisplay(currentFloor, this.capacity, Direction.UP);
    }
}
