package Homework3;

public abstract class Car {
    String numberCar;

    public Car(String numberCar) {
        this.numberCar = numberCar;
    }

    public String getNumberCar() {
        return numberCar;
    }

    public void setNumberCar(String numberCar) {
        this.numberCar = numberCar;
    }

    public void Start() {
        System.out.println("Начинаем движение");
    }

    public void Stop() {
        System.out.println("Останавливаемся");
    }

    public void TurnOnHeadlights() {
        System.out.println("Включаем фары");
    }

}