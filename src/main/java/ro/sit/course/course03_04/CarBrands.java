package ro.sit.course.course03_04;

public class CarBrands {
    private float maxSpeed = 240;
    private int maxGear = 6;
    private String brand;
    private String model;
    private String fuelType;


    public CarBrands(String brand, String model, String fuelType) {
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
    }

    public CarBrands(float maxSpeed, int maxGear, String brand, String model, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.maxGear = maxGear;
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
    }

    public String getBrand() {
        return this.brand;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public int getMaxGear() {
        return maxGear;
    }

    public String getModel() {
        return model;
    }

    public String getFuelType() {
        return fuelType;
    }

    @Override
    public String toString() {
        return "{" +
                "maxSpeed=" + maxSpeed +
                ", maxGear=" + maxGear +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }
}