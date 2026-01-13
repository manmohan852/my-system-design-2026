package com.manmohan.systemdesign.moviebooking.service;

import com.manmohan.systemdesign.moviebooking.constants.BookingStatus;
import com.manmohan.systemdesign.moviebooking.constants.SeatStatus;
import com.manmohan.systemdesign.moviebooking.model.*;
import java.util.*;

public class BookingService {
    public Booking bookSeats(User user, Show show, List<String> seatIds) {
        List<Seat> selectedSeats = new ArrayList<>();

        // Check availability
        for (String seatId : seatIds) {
            Seat seat = findSeat(show.getScreen(), seatId);
            if (seat == null || seat.getStatus() == SeatStatus.BOOKED) {
                throw new RuntimeException("Seat " + seatId + " not available");
            }
            selectedSeats.add(seat);
        }

        // Mark seats booked
        for (Seat seat : selectedSeats) {
            seat.setStatus(SeatStatus.BOOKED);
        }

        Booking booking = new Booking(
                UUID.randomUUID().toString(),
                user,
                show,
                selectedSeats
        );

        booking.setStatus(BookingStatus.CONFIRMED);
        return booking;
    }

    private Seat findSeat(Screen screen, String seatId) {
        for (Seat seat : screen.getSeats()) {
            if (seat.getSeatId().equals(seatId)) {
                return seat;
            }
        }
        return null;
    }

}
