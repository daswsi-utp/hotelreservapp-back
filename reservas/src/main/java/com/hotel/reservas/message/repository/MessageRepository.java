package com.hotel.reservas.message.repository;

import com.hotel.reservas.message.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
