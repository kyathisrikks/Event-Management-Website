package com.example.wedding_web.Service;

// import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wedding_web.Model.Booking;
import com.example.wedding_web.Model.User;
import com.example.wedding_web.Repository.BookingRepository;
// import com.example.wedding_web.Repository.UserRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    // @Autowired
    // private UserRepository userRepository;

    public Booking createBooking(Map<String, String> params, User user) {
        // User user = userRepository.findByUsername(principal.getName());

        if (user == null)
            throw new RuntimeException("User not found!");

        Booking booking = new Booking();

        booking.setUser(user);

        booking.setEventDate(params.get("eventDate"));
        booking.setDecor(params.get("decor"));
        booking.setCake(params.get("cake"));
        booking.setFloral(params.get("floral"));
        booking.setFlowerset(params.get("flowerset"));
        booking.setSangeet(params.get("sangeet"));
        booking.setWedding(params.get("wedding"));
        booking.setReception(params.get("reception"));
        booking.setBridalshower(params.get("bridalshower"));
        booking.setMehandi(params.get("mehandi"));
        booking.setVegItems(params.get("vegItems"));
        booking.setNonVegItems(params.get("nonVegItems"));

        return bookingRepository.save(booking);
    }
}