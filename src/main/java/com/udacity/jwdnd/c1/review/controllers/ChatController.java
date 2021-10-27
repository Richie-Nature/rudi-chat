package com.udacity.jwdnd.c1.review.controllers;

import com.udacity.jwdnd.c1.review.MessageService;
import com.udacity.jwdnd.c1.review.models.ChatForm;
import com.udacity.jwdnd.c1.review.models.ChatMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ChatController {
    private final MessageService messageService;
    private final List<String> flaggedWords = new ArrayList();

    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/chat")
    public String chat(@ModelAttribute("chat")ChatForm chatForm,Model model) {
        model.addAttribute("chats", this.messageService.getChats());
        model.addAttribute("flagged", this.messageService.getFlagged());
        return "chat";
    }

    @PostMapping("/chat")
    public String addChat(@ModelAttribute("chat")ChatForm chatForm, Model model) {
        chatForm.getChatMessage().setMessage(this.messageService.messageMode(chatForm));
        this.messageService.addMessage(chatForm.getChatMessage());
        model.addAttribute("chats", this.messageService.getChats());
        model.addAttribute("flagged", this.messageService.getFlagged());
        chatForm.setMode("");
        chatForm.setChatMessage(new ChatMessage());
        return "chat";
    }
}
