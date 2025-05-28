package com.hotel.reservas.service.chatbot;

import org.springframework.stereotype.Service;

@Service
public class ChatbotService {

    public String procesarMensaje(String mensaje) {
        if (mensaje.toLowerCase().contains("hola") || mensaje.toLowerCase().contains("buenos días")) {
            return "¡Hola! ¿En qué puedo ayudarte hoy?";
        } else if (mensaje.toLowerCase().contains("precio estandar")) {
            return "El precio de una habitación estándar es S/.100 ó $25 por noche.";
        else if (mensaje.toLowerCase().contains("precio matrimonial")) {
                return "El precio de una habitación matrimonial es S/.150 ó $40 por noche.";
        else if (mensaje.toLowerCase().contains("precio deluxe")) {
                    return "El precio de una habitación deluxe es S/.200 ó $50 por noche.";
        } else if (mensaje.toLowerCase().contains("disponibilidad")) {
            return "¿Para qué fecha te gustaría hacer la reserva?";
        } else {
            return "Lo siento, no entiendo esa pregunta. ¿Puedo ayudarte con algo más?";
        }
    }
}
