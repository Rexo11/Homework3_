package Homework3;

public class CarFactory {

    public static Giguli CreateGiguli(String number) {
        Giguli carG = new Giguli(number);
        return carG;
    }

    public static Toyota CreateToyota(String number) {
        Toyota carT = new Toyota(number);
        return carT;
    }
}
