import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

interface Plant {
    String getName();

    double getPrice();
}

class FlowerPlant implements Plant {
    private String name;
    private double price;

    public FlowerPlant(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}

class Nursery {
    private List<Plant> plants;

    public Nursery() {
        this.plants = new ArrayList<>();
    }

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public Plant getCheapestPlant() throws Exception {
        if (plants.isEmpty()) {
            throw new Exception("No plants available in the nursery");
        }
        return Collections.min(plants, (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
    }
}

public class RealTimeApp {
    public static void main(String[] args) {
        Nursery nursery = new Nursery();
        nursery.addPlant(new FlowerPlant("Rose", 10.0));
        nursery.addPlant(new FlowerPlant("Tulip", 8.0));
        nursery.addPlant(new FlowerPlant("Jasmine", 12.0));
        nursery.addPlant(new FlowerPlant("Lily", 9.0));

        try {
            Plant cheapestPlant = nursery.getCheapestPlant();
            System.out.println("The cheapest plant is: " + cheapestPlant.getName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
