package ro.sit.course.course03_04;

import com.sun.deploy.security.SelectableSecurityManager;

import java.awt.*;

public class Car {

    private CarBrands carBrand;
    private float fuelLevel;
    private int gear = 0;
    private float speed;
    private Color color;

    private boolean engineOn;

    public Car(CarBrands carBrand, Color color) {
        this.carBrand = carBrand;
        this.color = color;
    }

    public Car(float maxSpeed, int maxGear, String brand, String model, String fuelType, Color color) {
        this.carBrand = new CarBrands(maxSpeed, maxGear, brand, model, fuelType);
        this.color = color;
    }

    public CarBrands getCarBrand() {
        return carBrand;
    }

    public float getFuelLevel() {
        return fuelLevel;
    }

    public int getGear() {
        return gear;
    }

    public float getSpeed() {
        return speed;
    }

    public Color getColor() {
        return color;
    }

    public boolean isEngineOn() {
        return engineOn;
    }

    public void accelerate(float speedDelta) {
        if (fuelLevel > 1) {
            if (isEngineOn()) {
                if (speedDelta + speed < carBrand.getMaxSpeed())
                    speed += speedDelta;
                else
                    speed = carBrand.getMaxSpeed();
                gearUp();
            } else {
                engineOn = true;
                gearUp();
                speed = speedDelta;
            }
            fuelLevel--;
        } else {
            System.out.println("Please add fuel to use Car");
        }
    }

    public void steer(float angle) {
    }

    public void gearUp() {
        if (gear == -1)
            gear = 1;
        else if (gear < carBrand.getMaxGear())
            gear++;
    }

    public void gearDown() {
        if (gear > 1)
            gear--;
    }

    public void revereGear() {
        gear = -1;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setFuelLevel(float fuelLevel) {
        if (fuelLevel <= 100 && fuelLevel >= 1)
            this.fuelLevel = fuelLevel;
        else if (fuelLevel < 1)
            System.out.println("Please add fuel value bigger than 0");
        else
            this.fuelLevel = 100;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carBrand=" + carBrand +
                ", fuelLevel=" + fuelLevel +
                ", gear=" + gear +
                ", speed=" + speed +
                ", color=" + color +
                ", engineOn=" + engineOn +
                '}';
    }
}