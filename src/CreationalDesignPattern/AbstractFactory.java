public class AbstractFactory {
    // Managing Families of Related Objects with Ease
    // The Problem: Managing Different Car Brands 🚗

    // Solving with factory method
    // Vehicle.java - Common Interface
    public interface Vehicle {
        void start();
        void stop();
    }
    // Concrete Classes for Car Brands
    public class Honda implements Vehicle {
        public void start() {
            System.out.println("Honda Car is starting");
        }
        public void stop() {
            System.out.println("Honda Car is stopping");
        }
    }
    public class Toyota implements Vehicle {
        public void start() {
            System.out.println("Toyota Car is starting");
        }
        public void stop() {
            System.out.println("Toyota Car is stopping");
        }
    }
    public class BMW implements Vehicle {
        public void start() {
            System.out.println("BMW Car is starting");
        }
        public void stop() {
            System.out.println("BMW Car is stopping");
        }
    }
    // Factory Method to Create Vehicles
    public class CarFactory {
        public Vehicle createVehicle(String brand) {
            if (brand.equals("Honda")) {
                return new Honda();
            } else if (brand.equals("Toyota")) {
                return new Toyota();
            } else if (brand.equals("BMW")) {
                return new BMW();
            } else {
                throw new IllegalArgumentException("Unknown car brand");
            }
        }
    }
    // Main Method
    public static void main(String[] args) {
        CarFactory factory = new CarFactory();
        Vehicle vehicle = factory.createVehicle("Honda");
        vehicle.start();
        vehicle.stop();
    }

    // =========================================================================================================================

    // With Abstranct Factory 
    // Vehicle.java - Common Interface
    public interface Vehicle {
        void start();
        void stop();
    }
    // Concrete Classes for Car Brands
    public class Honda implements Vehicle {
        public void start() {
            System.out.println("Honda Car is starting");
        }
            public void stop() {
        System.out.println("Honda Car is stopping");
        }
    }
    public class Toyota implements Vehicle {
        public void start() {
            System.out.println("Toyota Car is starting");
        }
        public void stop() {
            System.out.println("Toyota Car is stopping");
        }
    }
    public class BMW implements Vehicle {
        public void start() {
            System.out.println("BMW Car is starting");
        }
        public void stop() {
            System.out.println("BMW Car is stopping");
        }
    }
    // Abstract Factory Interface
    public interface VehicleFactory {
        Vehicle createVehicle();
    }
    // Concrete Factories for Each Car Brand
    public class HondaFactory implements VehicleFactory {
        public Vehicle createVehicle() {
            return new Honda();
        }
    }
    public class ToyotaFactory implements VehicleFactory {
        public Vehicle createVehicle() {
            return new Toyota();
        }
    }
    public class BMWFactory implements VehicleFactory {
        public Vehicle createVehicle() {
            return new BMW();
        }
    }
    // Client Code
    public static void main(String[] args) {
        VehicleFactory hondaFactory = new HondaFactory();
        Vehicle honda = hondaFactory.createVehicle();
        honda.start();
        honda.stop();
        VehicleFactory toyotaFactory = new ToyotaFactory();
        Vehicle toyota = toyotaFactory.createVehicle();
        toyota.start();
        toyota.stop();
    }
}
