import panel.Display;
import panel.ElevatorPanel;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private List<Floor> floors;
    private List<ElevatorCar> elevators;

    private Building() {
        floors = new ArrayList<>();
        elevators = new ArrayList<>();
    }
    private static Building building = null;
    public static Building getInstance(){
        if (building == null){
            building = new Building();
        }
        return building;
    }

    public void addFloors(int numberOfFloors) {
        for (int i =1; i <= numberOfFloors; i++) {
            floors.add(new Floor(8));
        }
    }

    public void addElevatorCars(int numberOfElevators) {
        for (int i = 1; i <= numberOfElevators; i++) {
            elevators.add(new ElevatorCar(i, floors.size(), new Display(), new ElevatorPanel(8)));
        }
    }

    public ElevatorCar getElevatorCar(int id) {
        return elevators.get(id - 1);
    }
}
