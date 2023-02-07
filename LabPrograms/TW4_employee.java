package LabPrograms;

class Employee {
    String name, address, gender;
    int age;
    double sal;

    Employee(String name, int age, String address, String gender) {
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.age = age;
    }

    void show() {
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
        System.out.println("Address : " + address);
        System.out.println("Gender : " + gender);
        System.out.println("Salary : " + sal);
    }
}

class FTEmployee extends Employee {
    int basSal;

    public FTEmployee(String name, int age, String address, String gender, int basSal) {
        super(name, age, address, gender);
        this.basSal = basSal;
    }

    void calSal() {
        sal = (basSal + (basSal * 0.75) + (basSal * 0.075) - (basSal * 0.1));
    }
}

class PTEmployee extends Employee {
    String qual;
    int exp, numHour;

    public PTEmployee(String name, int age, String address, String gender, String qual, int exp, int numHour) {
        super(name, age, address, gender);
        this.qual = qual;
        this.exp = exp;
        this.numHour = numHour;
    }

    void calSal() {
        switch (qual) {
            case "BE":
                if (exp <= 5)
                    sal = numHour * 300;
                else if (exp <= 10)
                    sal = numHour * 400;
                else
                    sal = numHour * 500;
                break;
            case "MTech":
                if (exp <= 5)
                    sal = numHour * 400;
                else if (exp <= 10)
                    sal = numHour * 700;
                else
                    sal = numHour * 1200;
                break;
            case "PhD":
                if (exp <= 5)
                    sal = numHour * 800;
                else if (exp <= 10)
                    sal = numHour * 1200;
                else
                    sal = numHour * 1500;
                break;
        }
    }
}

public class TW4_employee {
    public static void main(String[] args) {
        FTEmployee f1 = new FTEmployee("Aryan", 25, "Vijaypur", "Male", 10000);
        f1.calSal();
        System.out.println("Details of Full time employee : ");
        f1.show();
        PTEmployee e1 = new PTEmployee("Jayesh", 30, "Belgaum", "Male", "BE", 6, 10);
        e1.calSal();
        System.out.println("Details of part time employee : ");
        e1.show();
        PTEmployee e2 = new PTEmployee("Pratik", 36, "Mysore", "Male", "PhD", 10, 8);
        e2.calSal();
        System.out.println("Details of part time employee : ");
        e2.show();
    }
}