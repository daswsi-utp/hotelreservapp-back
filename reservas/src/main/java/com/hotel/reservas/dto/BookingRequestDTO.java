package com.hotel.reservas.dto;

import com.tuapp.entity.BookingStatus;
import java.time.LocalDate;

public class BookingRequestDTO {
    @NotNull
    private Integer roomId;
    @NotNull
    @FutureOrPresent
    private LocalDate checkInDate;
    @NotNull
    @FutureOrPresent
    private LocalDate checkOutDate;

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
}