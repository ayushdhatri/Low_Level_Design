package Low_Level_Design.practice.ConcertBookingSystem.models;

import java.time.LocalDateTime;
import java.util.List;

import Low_Level_Design.practice.ConcertBookingSystem.enums.BookingStatusEnum;

public class Booking {
    private final String bookingId;

    private final LocalDateTime bookingDate;

    private final User user;

    private final String concertId;

    private final List<Seat> bookedSeats;

    private final double totalAmount;
    
    private BookingStatusEnum status;

    public Booking(String bookingId, User user, String concertId, List<Seat> bookedSeats, double totalAmount) {
        this.bookingId = bookingId;
        this.bookingDate = LocalDateTime.now();
        this.user = user;
        this.concertId = concertId;
        this.bookedSeats = bookedSeats;
        this.totalAmount = totalAmount;
        this.status = BookingStatusEnum.CONFIRMED;
    }

    public String getBookingId() { return bookingId; }
    public User getUser() { return user; }
    public String getConcertId() { return concertId; }
    public List<Seat> getBookedSeats() { return bookedSeats; }
    public double getTotalAmount() { return totalAmount; }
    public BookingStatusEnum getStatus() { return status; }
    
}
