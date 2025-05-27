package com.hotel.reservas.service.chatbot;

import org.springframework.stereotype.Service;

@Service
public class ChatbotService {

    public String procesarMensaje(String mensaje) {
        if (mensaje.toLowerCase().contains("hola") || mensaje.toLowerCase().contains("buenos días")) {
            return "¡Hola! ¿En qué puedo ayudarte hoy?";
        } else if (mensaje.toLowerCase().contains("precio")) {
            return "El precio de una habitación estándar es $100 por noche.";
        } else if (mensaje.toLowerCase().contains("disponibilidad")) {
            return "¿Para qué fecha te gustaría hacer la reserva?";
        } else {
            return "Lo siento, no entiendo esa pregunta. ¿Puedo ayudarte con algo más?";
        }
    }
}
