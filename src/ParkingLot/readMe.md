# Parking Lot System

This is a simple parking lot system implemented in Java, demonstrating the use of various design patterns such as Singleton, Strategy, and Template Method. The system supports parking and unparking of two-wheeler and four-wheeler vehicles, with appropriate charging strategies.

## Features

- Singleton pattern to ensure only one instance of `ParkingLot` is created.
- Strategy pattern to calculate parking charges based on vehicle type.
- Template Method pattern to handle the steps involved in parking and unparking vehicles.

## Classes

- **VEHICLE_TYPE**: Enum for vehicle types (TWO_WHEELER, FOUR_WHEELER).
- **Vehicle**: Class representing a vehicle with a registration number and type.
- **Slot**: Class representing a parking slot, capable of holding a vehicle.
- **SlotFactory**: Factory class for creating slots based on vehicle type.
- **Ticket**: Class representing a parking ticket.
- **ParkingChargingStrategy**: Interface for defining charging strategies.
- **FourWheelerParkingStrategy**: Implementation of charging strategy for four-wheelers.
- **ParkingFullException**: Exception thrown when parking is full.
- **ParkingNotFoundException**: Exception thrown when a parked vehicle is not found.
- **VehicleAndChargesToBePaid**: Class representing a vehicle and its parking charges.
- **ParkingLot**: Singleton class representing the parking lot, handling parking and unparking of vehicles.
- **Main**: Main class to test the parking lot system.

## How to Use

1. **Initialize the Parking Lot**: Use the `ParkingLot` class to create an instance of the parking lot with specified number of slots for two-wheelers and four-wheelers.
2. **Create Vehicles**: Create instances of the `Vehicle` class for different vehicles.
3. **Park Vehicles**: Use the `parkAVehicle` method of the `ParkingLot` class to park vehicles.
4. **Unpark Vehicles**: Use the `unPark` method of the `ParkingLot` class with an appropriate charging strategy to unpark vehicles and calculate charges.

## Design Patterns Used

- **Singleton Pattern**: Ensures only one instance of `ParkingLot` is created.
- **Strategy Pattern**: Used for calculating parking charges based on different strategies.
- **Template Method Pattern**: Encapsulates the steps of parking and unparking vehicles.

## Running the System

To run the parking lot system, compile and execute the `Main` class. The `Main` class contains example code for parking and unparking vehicles, and calculating charges.

## Dependencies

- Java Development Kit (JDK) 8 or higher

## License

This project is licensed under the MIT License. See the LICENSE file for details.
