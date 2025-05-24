package com.hotel.reservas.service;

import com.tuapp.entity.Booking;
import com.tuapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendBookingConfirmation(User user, Booking booking) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Confirmación de Reserva");
        message.setText("Hola " + user.getFirstName() + ",\n\nGracias por tu reserva. Tu reserva con ID " + booking.getReservationId() + " ha sido registrada con estado " + booking.getStatus() + ".\n\nSaludos,");
        mailSender.send(message);
    }
}
