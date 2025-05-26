package com.hotelreserva.reserva_hotel.repository;

import com.hotelreserva.reserva_hotel.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
