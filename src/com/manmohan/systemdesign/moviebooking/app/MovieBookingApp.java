package com.manmohan.systemdesign.moviebooking.app;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import com.manmohan.systemdesign.moviebooking.model.*;
import com.manmohan.systemdesign.moviebooking.service.BookingService;

public class MovieBookingApp {
    public static void main(String[] args) {
        User user = new User("U1", "Manmohan");

        // Create movie
        Movie movie = new Movie("M1", "Inception", 148);

        // Create screen with seats
        Screen screen = new Screen("Screen1", 10);

        // Create theatre
        Theatre theatre = new Theatre("T1", "PVR Cinemas");
        theatre.screens.add(screen);

        // Create show
        Show show = new Show(
                "SHOW1",
                movie,
                screen,
                LocalDateTime.now().plusHours(2),
                250.0
        );

        // Booking service
        BookingService bookingService = new BookingService();

        // User selects seats
        List<String> seatIds = Arrays.asList("S1", "S2", "S3");

        // Book ticket
        Booking booking = bookingService.bookSeats(user, show, seatIds);

        // Print booking details
        System.out.println("Booking Successful!");
        System.out.println("Booking ID: " + booking.getBookingId());
        System.out.println("User: " + booking.getUser().getName());
        System.out.println("Movie: " + booking.getShow().getMovie().getTitle());
        System.out.println("Seats Booked:");

        for (Seat seat : booking.getBookedSeats()) {
            System.out.println(" - " + seat.getSeatId());
        }
    }
}
