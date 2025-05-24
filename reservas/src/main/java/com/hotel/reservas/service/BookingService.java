package com.hotel.reservas.service;

import com.tuapp.dto.BookingRequestDTO;
import com.tuapp.dto.BookingResponseDTO;
import java.util.List;

public interface BookingService {
    BookingResponseDTO createBooking(BookingRequestDTO dto, Integer userId);
    List<BookingResponseDTO> getBookingsByUser(Integer userId);
    List<BookingResponseDTO> getAllBookings();

    void cancelBooking(Integer bookingId, Integer userId);
}