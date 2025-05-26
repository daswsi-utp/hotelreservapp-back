package com.hotel.reservas.service;

import com.tuapp.dto.BookingRequestDTO;
import com.tuapp.dto.BookingResponseDTO;
import com.tuapp.entity.*;
import com.tuapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public BookingResponseDTO createBooking(BookingRequestDTO dto, Integer userId) {
        Booking booking = new Booking();
        booking.setUser(userRepository.findById(userId).orElseThrow());
        booking.setRoom(roomRepository.findById(dto.getRoomId()).orElseThrow());
        booking.setCheckInDate(dto.getCheckInDate());
        booking.setCheckOutDate(dto.getCheckOutDate());
        booking.setStatus(BookingStatus.PENDING);
        bookingRepository.save(booking);

        return mapToDTO(booking);
    }

    @Override
    public void cancelBooking(Integer bookingId, Integer userId) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow();
        if (!booking.getUser().getUserId().equals(userId)) {
            throw new RuntimeException("No autorizado para cancelar esta reserva");
        }
        booking.setStatus(BookingStatus.CANCELLED);
        bookingRepository.save(booking);
    }

    @Override
    public List<BookingResponseDTO> getBookingsByUser(Integer userId) {
        return bookingRepository.findByUserUserId(userId).stream()
                .map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<BookingResponseDTO> getAllBookings() {
        return bookingRepository.findAll().stream()
                .map(this::mapToDTO).collect(Collectors.toList());
    }

    private BookingResponseDTO mapToDTO(Booking booking) {
        BookingResponseDTO dto = new BookingResponseDTO();
        dto.setReservationId(booking.getReservationId());
        dto.setRoomNumber(booking.getRoom().getRoomNumber().toString());
        dto.setCheckInDate(booking.getCheckInDate());
        dto.setCheckOutDate(booking.getCheckOutDate());
        dto.setStatus(booking.getStatus());
        return dto;
    }
}
