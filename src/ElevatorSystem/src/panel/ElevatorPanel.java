package panel;

import button.DoorButton;
import button.ElevatorButton;

import java.util.ArrayList;
import java.util.List;

public class ElevatorPanel {
    private List<ElevatorButton> floorButtons;
    private DoorButton openButton;
    private DoorButton closeButton;

    public ElevatorPanel(int numberOfFloors) {
        floorButtons = new ArrayList<>();
        for (int i = 1; i <= numberOfFloors; i++) {
            floorButtons.add(new ElevatorButton(i));
        }
        this.openButton = new DoorButton();
        this.closeButton = new DoorButton();
    }

    public List<ElevatorButton> getFloorButtons() {
        return floorButtons;
    }

    public DoorButton getOpenButton() {
        return openButton;
    }

    public DoorButton getCloseButton() {
        return closeButton;
    }
}
