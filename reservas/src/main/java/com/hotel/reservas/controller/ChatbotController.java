package com.hotel.reservas.controller;

import com.hotel.reservas.service.chatbot.ChatbotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class ChatbotController {

    @Autowired
    private ChatbotService chatbotService;

    @PostMapping("/enviar")
    public String interactuarConChatbot(@RequestBody String mensajeUsuario) {
        return chatbotService.procesarMensaje(mensajeUsuario);
    }
}
