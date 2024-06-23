import panel.Display;
import panel.HallPanel;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private List<Display> display;
    private List<HallPanel> panel;
    private int numberOfFloors;

    public Floor(int numberOfFloors) {
        display = new ArrayList<>();
        panel = new ArrayList<>();
        this.numberOfFloors = numberOfFloors;
    }

    public boolean isBottomMost(int currentFloor) {
        return currentFloor == 1;
    }

    public boolean isTopMost(int currentFloor) {
        return currentFloor == numberOfFloors;
    }
}