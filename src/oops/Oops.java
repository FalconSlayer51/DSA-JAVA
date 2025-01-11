package oops;

class Car {
    public String brand;
    public String color;
    public String model;
    public boolean isABSPresent;
    public int speed;


    // Default constructor
    public Car() {
        System.out.println("This is default constructor");
        this.brand = "maruti";
        this.model = "alto800";
        this.speed = 80;
        this.isABSPresent = false;
        this.color = "orange";
    }

    // Parameterized constructor
    public Car(String brand, String color, boolean isABSPresent, int speed, String model) {
        this.brand = brand;
        this.color = color;
        this.isABSPresent = isABSPresent;
        this.speed = speed;
        this.model = model;

        System.out.println("Init done");
    }

    public Car(Car newCar) {
        this.brand = newCar.brand;
        this.color = newCar.color;
        this.isABSPresent = newCar.isABSPresent;
        this.model = newCar.model;
        this.speed = newCar.speed;

        System.out.println("Copy constructor invoked");
    }

    public void drive() {
        System.out.println("Driving car ....");
    }

    public void speedUp(int speed) {
        this.speed = speed;
        System.out.println("Speed up");
    }
}

public class Oops {
    public static void main(String[] args) {
        // `Car obj;` no memory location here
        Car obj = new Car(); // memory allocated in heap
        System.out.println("speed: " + obj.speed);

        // Parameterized constructor
        Car obj2 = new Car("ford", "red", true, 100, "ecosport");
        System.out.println("speed: " + obj2.speed);

        // Copy constructor
        Car obj3 = new Car(obj2);
        System.out.println("speed: " + obj3.speed);

        obj2.speed = 90;
        System.out.println("speed: " + obj2.speed);
        System.out.println("speed: " + obj3.speed);

        // Same Reference
        Car obj4 = obj2;
        System.out.println("speed: " + obj4.speed);
        obj2.speed = 50;
        System.out.println("speed: " + obj4.speed);
    }
}
