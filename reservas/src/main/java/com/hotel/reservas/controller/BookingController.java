package com.hotel.reservas.controller;

import com.tuapp.dto.BookingRequestDTO;
import com.tuapp.dto.BookingResponseDTO;
import com.tuapp.service.BookingService;
import com.tuapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('GUEST')")
    @PostMapping
    public ResponseEntity<BookingResponseDTO> createBooking(@Valid @RequestBody BookingRequestDTO dto, Principal principal) {
        Integer userId = userService.findIdByEmail(principal.getName());
        return ResponseEntity.ok(bookingService.createBooking(dto, userId));
    }

    @PreAuthorize("hasRole('GUEST')")
    @PatchMapping("/{id}/cancel")
    public ResponseEntity<Void> cancelBooking(@PathVariable Integer id, Principal principal) {
        Integer userId = userService.findIdByEmail(principal.getName());
        bookingService.cancelBooking(id, userId);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasRole('GUEST')")
    @GetMapping("/my")
    public ResponseEntity<List<BookingResponseDTO>> getMyBookings(Principal principal) {
        Integer userId = userService.findIdByEmail(principal.getName());
        return ResponseEntity.ok(bookingService.getBookingsByUser(userId));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<BookingResponseDTO>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }
}
