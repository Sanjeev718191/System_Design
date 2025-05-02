public class Factory {
    // So, the problem is: 
    // How can we create vehicles easily and cleanly without hard-coding the class names everywhere in the code? 🤔

    // Bad Code
    public interface Vehicle {
        void start();
        void stop();
    }

    // Car.java - Concrete class for Car
    public class Car implements Vehicle {
        public void start() {
            System.out.println("Car is starting...");
        }
        public void stop() {
            System.out.println("Car is stopping...");
        }
    }
  
    // Truck.java - Concrete class for Truck
    public class Truck implements Vehicle {
        public void start() {
            System.out.println("Truck is starting...");
        }
        public void stop() {
            System.out.println("Truck is stopping...");
        }
    }
  
    // Bike.java - Concrete class for Bike
    public class Bike implements Vehicle {
        public void start() {
            System.out.println("Bike is starting...");
        }
        public void stop() {
            System.out.println("Bike is stopping...");
        }
    }

    public static void main(String[] args) {
        Vehicle vehicle1 = new Car();
        vehicle1.start();
        vehicle1.stop();
        Vehicle vehicle2 = new Truck();
        vehicle2.start();
        vehicle2.stop();
        Vehicle vehicle3 = new Bike();
        vehicle3.start();
        vehicle3.stop();
    }


    // ======================================================================
    // Code with Factory Design Pattern 

    // Vehicle.java - Common interface
    public interface Vehicle {
        void start();
        void stop();
    }
  
    // Concrete vehicle classes remain the same
    public class Car implements Vehicle {
        public void start() {
            System.out.println("Car is starting...");
        }
        public void stop() {
            System.out.println("Car is stopping...");
        }
    }
  
    public class Truck implements Vehicle {
        public void start() {
            System.out.println("Truck is starting...");
        }
        public void stop() {
            System.out.println("Truck is stopping...");
        }
    }
  
    public class Bike implements Vehicle {
        public void start() {
            System.out.println("Bike is starting...");
        }
        public void stop() {
            System.out.println("Bike is stopping...");
        }
    }
  
    // VehicleFactory.java - Factory to create vehicles
    public class VehicleFactory {
        public static Vehicle getVehicle(String vehicleType) {
            if (vehicleType.equals("Car")) {
                return new Car();
            } else if (vehicleType.equals("Truck")) {
                return new Truck();
            } else if (vehicleType.equals("Bike")) {
                return new Bike();
            } else {
                throw new IllegalArgumentException("Unknown vehicle type");
            }
        }
    }
  
    // Main.java - Simplified with Factory
    public class Main {
        public static void main(String[] args) {
        Vehicle vehicle1 = VehicleFactory.getVehicle("Car");
        vehicle1.start();
        vehicle1.stop();
        Vehicle vehicle2 = VehicleFactory.getVehicle("Truck");
        vehicle2.start();
        vehicle2.stop();
        Vehicle vehicle3 = VehicleFactory.getVehicle("Bike");
        vehicle3.start();
        vehicle3.stop();
        }
    }

}
