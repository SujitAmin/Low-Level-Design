public class Main {
    public static void main(String[] args) {
        // Create a building with 10 floors and 2 elevator cars
        Building building = Building.getInstance();
        building.addFloors(8);
        building.addElevatorCars(3);

        // Retrieve the elevator system instance
        ElevatorSystem elevatorSystem = ElevatorSystem.getInstance();

        // Get the first elevator car and set a target floor
//        ElevatorCar elevator1 = building.getElevatorCar(1);
//        elevator1.setTargetFloor(5);
//        elevator1.move();
//
//        // Add passengers to the elevator
//        elevator1.addPassenger(3);

        // Get the second elevator car and set a target floor
        ElevatorCar elevator2 = building.getElevatorCar(2);
        elevator2.setTargetFloor(8);
        elevator2.move();

        elevator2.removePassenger(1);
        elevator2.setTargetFloor(2);
        elevator2.move();

        // Remove passengers from the elevator
        elevator2.removePassenger(1);

        // Monitor the elevators
        elevatorSystem.monitoring();
    }
}