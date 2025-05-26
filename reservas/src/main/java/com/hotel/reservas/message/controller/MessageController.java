package com.hotel.reservas.message.controller;

import com.hotel.reservas.message.dto.MessageDTO;
import com.hotel.reservas.message.model.Message;
import com.hotel.reservas.message.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageService service;

    public MessageController(MessageService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Message> sendMessage(@RequestBody MessageDTO messageDTO) {
        Message savedMessage = service.saveFromDTO(messageDTO);
        return ResponseEntity.ok(savedMessage);
    }

    @GetMapping
    public ResponseEntity<List<Message>> getMessages() {
        return ResponseEntity.ok(service.findAll());
    }

    // Nuevo endpoint para marcar un mensaje como leído
    @PutMapping("/{id}/read")
    public ResponseEntity<Message> markAsRead(@PathVariable Long id) {
        Message updatedMessage = service.markMessageAsRead(id);
        if (updatedMessage == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedMessage);
    }
}
