package LabPrograms;

abstract class car {
    String carName, modelName;
    int chassiNum;

    car(String carName, String modelName, int chassiNum) {
        this.carName = carName;
        this.modelName = modelName;
        this.chassiNum = chassiNum;
    }

    abstract void startCar();

    abstract void operateSteering();

    void display() {
        System.out.println("CarName : "+carName);
        System.out.println("modelName : "+modelName);
        System.out.println("chassiNum : "+chassiNum);
    }
}

class marutiCar extends car {
    marutiCar(String carName, String modelName, int chassiNum) {
        super(carName, modelName, chassiNum);
    }

    void startCar() {
        System.out.println("Maruti car is satrting");
    }

    void operateSteering() {
        System.out.println("Steering is not so powerful");
    }
}

class BmwCar extends car {
    BmwCar(String carName, String modelName, int chassiNum) {
        super(carName, modelName, chassiNum);
    }

    void startCar() {
        System.out.println("BMW car is satrting");
    }

    void operateSteering() {
        System.out.println("Steering is powerful");
    }
}

class driver {
    String name, gender;
    int age;

    driver(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    void DisplayDriver(car obj) {
        System.out.println("Driver Name = " + name);
        System.out.println("Driver gender = " + gender);
        System.out.println("Driver age = " + age);
        obj.display();
        obj.startCar();
        obj.operateSteering();
    }
}

public class TW6Polymorphism {

    public static void main(String[] args) {
        marutiCar m = new marutiCar("Maruti", "Ciaz", 100);
        BmwCar b = new BmwCar("BMW", "X5", 300);

        driver obj1 = new driver("Jayesh", "male", 19);
        obj1.DisplayDriver(b);
        System.out.println();

        driver obj2 = new driver("Aryan", "male", 19);
        obj2.DisplayDriver(m);
        System.out.println();

        driver obj3 = new driver("Taneeshq", "male", 19);
        obj3.DisplayDriver(m);
        System.out.println();
    }

}