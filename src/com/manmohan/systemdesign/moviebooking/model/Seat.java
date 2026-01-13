package com.manmohan.systemdesign.moviebooking.model;


import com.manmohan.systemdesign.moviebooking.constants.SeatStatus;

public class Seat {
    String seatId;
    SeatStatus status;

    Seat(String seatId) {
        this.seatId = seatId;
        this.status = SeatStatus.AVAILABLE;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }
}
