package Lesson9.homeWork;

public class Passenger extends Car {
    private int places;

    public Passenger(int year, String manufacturer, CartState cartState) {
        super(year, manufacturer, cartState);
    }



    public int getPlaces() {
        return places;
    }
}
