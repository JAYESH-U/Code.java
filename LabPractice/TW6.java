package LabPractice;

abstract class car {
    String carName;
    int chassiNum;
    String model;

    car(String carName, String model, int chassiNum){
        this.carName = carName;
        this.model = model;
        this.chassiNum = chassiNum;
    }

    abstract void carStarts();

    abstract void steering();

    void display(){
        System.out.println("car name : "+ carName);
        System.out.println("chassi number : "+ chassiNum);
        System.out.println("model name : "+ model);
    }
}

class bmw extends car {
    bmw(String carName, String model, int chassiNum){
        super(carName,model,chassiNum);
    }

    void carStarts(){
        System.out.println("BMW is starting.");
    }

    void steering(){
        System.out.println("Steering is stiff.");
    }
}

class mercedesBenz extends car {
    mercedesBenz(String carName, String model, int chassiNum){
        super(carName,model,chassiNum);
    }

    void carStarts(){
        System.out.println("MercedesBenz is starting.");
    }

    void steering(){
        System.out.println("Steering is so much comfotable.");
    }
}

class driver {
    String name,gender;
    int age;

    driver(String name, String gender, int age){
        this.age= age;
        this.gender = gender;
        this.name = name;
    }

    void display(car c){
        System.out.println("Name : "+ name);
        System.out.println("Age : "+ age);
        System.out.println("gender : "+ gender);
        c.display();
        c.carStarts();
        c.steering();
    }
}

public class TW6 {
    public static void main(String[] args) {
        mercedesBenz m = new mercedesBenz("MercedesBenz", "G-Wagon", 100);
        bmw b = new bmw("BMW", "X5", 300);

        driver obj1 = new driver("Jayesh", "male", 19);
        obj1.display(b);
        System.out.println();

        driver obj2 = new driver("Aryan", "male", 19);
        obj2.display(m);
        System.out.println();

        driver obj3 = new driver("Taneeshq", "male", 19);
        obj3.display(m);
        System.out.println();
    }
}
