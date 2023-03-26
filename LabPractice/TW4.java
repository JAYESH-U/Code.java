package LabPractice;

class Employee {
    String name, gender, address;
    int age;
    double sal;

    Employee(String name, int age, String gender, String address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    void show() {
        System.out.println("Name : " + name);
        System.out.println("age : " + age);
        System.out.println("Gender : " + gender);
        System.out.println("Address : " + address);
        System.out.println("Salary : " + sal);
    }
}

class FullTime extends Employee {
    int baseSal;

    FullTime(String name, int age, String gender, String address, int baseSal) {
        super(name, age, gender, address);
        this.baseSal = baseSal;
    }

    void computeSal() {
        sal = (baseSal + (baseSal * 0.75) + (baseSal * 0.075) - (baseSal * 0.1));
    }
}

class PartTime extends Employee {
    int exp, time;
    String degree;

    PartTime(String name, int age, String gender, String address, String degree, int exp, int time) {
        super(name, age, gender, address);
        this.exp = exp;
        this.time = time;
        this.degree = degree;
    }

    void computeSal() {
        if (degree == "be") {
            if (exp <= 5)
                sal = 300 * time;
            else if (exp <= 10)
                sal = 400 * time;
            else
                sal = 500 * time;
        } else if (degree == "mtech") {
            if (exp <= 5)
                sal = 500 * time;
            else if (exp <= 10)
                sal = 600 * time;
            else
                sal = 700 * time;
        } else if (degree == "phd") {
            if (exp <= 5)
                sal = 700 * time;
            else if (exp <= 10)
                sal = 800 * time;
            else
                sal = 900 * time;
        }
    }
}

public class TW4 {
    public static void main(String[] args) {
        FullTime f1 = new FullTime("Aryan", 25, "Male", "Vijaypur", 10000);
        f1.computeSal();
        System.out.println("\nDetails of Full time employee : ");
        f1.show();
        PartTime e1 = new PartTime("Jayesh", 30, "Male", "Belgaum", "be", 6, 10);
        e1.computeSal();
        System.out.println("\nDetails of part time employee : ");
        e1.show();
        PartTime e2 = new PartTime("Pratik", 36, "Male", "Mysore", "phd", 10, 8);
        e2.computeSal();
        System.out.println("\nDetails of part time employee : ");
        e2.show();
    }
}
