package Low_Level_Design.practice.MovieBooking.models.Bookings;

import java.time.LocalDateTime;
import java.util.List;

import Low_Level_Design.practice.ConcertBookingSystem.enums.BookingStatusEnum;
import Low_Level_Design.practice.MovieBooking.models.Theater.ShowSeat;
import Low_Level_Design.practice.MovieBooking.models.Users.User;

public class Booking {
    private final String bookingId;
    private final LocalDateTime bookingDate;
    private final User user;
    private final String showId;
    private final List<ShowSeat> bookedSeats;
    private final double totalAmount;
    private BookingStatusEnum status;

    public Booking(String bookingId, User user, String showId, List<ShowSeat> bookedSeats, double totalAmount) {
        this.bookingId = bookingId;
        this.bookingDate = LocalDateTime.now();
        this.user = user;
        this.showId = showId;
        this.bookedSeats = bookedSeats;
        this.totalAmount = totalAmount;
        this.status = BookingStatusEnum.CONFIRMED;
    }

    public String getBookingId() { return bookingId; }
    public User getUser() { return user; }
    public String getShowId() { return showId; }
    public List<ShowSeat> getBookedSeats() { return bookedSeats; }
    public double getTotalAmount() { return totalAmount; }
    public BookingStatusEnum getStatus() { return status; }
    
}
