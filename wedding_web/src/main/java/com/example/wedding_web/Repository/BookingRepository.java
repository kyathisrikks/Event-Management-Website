package com.example.wedding_web.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.wedding_web.Model.Booking;
import com.example.wedding_web.Model.User;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findAllByUser(User user);

    // Optionally, fetch bookings sorted by most recent first
    List<Booking> findAllByUserOrderByIdDesc(User user);
}
