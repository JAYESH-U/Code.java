package LabPrograms;

class Rectangle {

    double length;
    double width;

    Rectangle() {
        length = 1.0;
        width = 1.0;
    }

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    double computeArea() {
        return length * width;
    }

    double computePerimeter() {
        return 2 * (length + width);
    }
}

class Cuboid extends Rectangle {

    double height;

    Cuboid() {
        super();
        height = 1.0;
    }

    Cuboid(double length, double width, double height) {
        super(length, width);
        this.height = height;
    }

    @Override
    double computeArea() {
        return 2 * ((length * width) + (width * height) + (length * height));
    }

    @Override
    double computePerimeter() {
        return 4 * (length + width + height);
    }

    double computeVolume() {
        return length * width * height;
    }
}


public class TW5b_methodOverloading {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        System.out.println("Rectangle 1:");
        System.out.println("Area:" + r1.computeArea());
        System.out.println("Perimeter:" + r1.computePerimeter());
        Rectangle r2 = new Rectangle(10,30);
        System.out.println("\nRectangle 2:");
        System.out.println("Area:" + r2.computeArea());
        System.out.println("Perimeter:" + r2.computePerimeter());
        Cuboid c1=new Cuboid();
        System.out.println("\nCuboid 1:");
        System.out.println("Area:" + c1.computeArea());
        System.out.println("Perimeter:" + c1.computePerimeter());
        System.out.println("Volume:" + c1.computeVolume());
        Cuboid c2=new Cuboid(10,30,40);
        System.out.println("\nCuboid 2:");
        System.out.println("Surface area:" + c2.computeArea());
        System.out.println("Perimeter:" + c2.computePerimeter());
        System.out.println("Volume:" + c2.computeVolume());
    }

}
