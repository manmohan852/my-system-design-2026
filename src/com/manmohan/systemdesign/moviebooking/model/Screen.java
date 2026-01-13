package com.manmohan.systemdesign.moviebooking.model;


import java.util.ArrayList;
import java.util.List;

public class Screen {
    String screenId;
    List<Seat> seats;

    public Screen(String screenId, int seatCount) {
        this.screenId = screenId;
        this.seats = new ArrayList<>();
        for (int i = 1; i <= seatCount; i++) {
            seats.add(new Seat("S" + i));
        }
    }

    public String getScreenId() {
        return screenId;
    }

    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
