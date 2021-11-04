package com.udacity.jwdnd.c1.review.controller;

import com.udacity.jwdnd.c1.review.model.User;
import com.udacity.jwdnd.c1.review.service.MessageService;
import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import com.udacity.jwdnd.c1.review.service.UserService;
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
    private final UserService userService;
    private final List<String> flaggedWords = new ArrayList();

    public ChatController(MessageService messageService, UserService userService) {
        this.messageService = messageService;
        this.userService = userService;
    }

    @GetMapping("/chat")
    public String chat(@ModelAttribute("chat")ChatForm chatForm,Model model) {
        model.addAttribute("chats", this.messageService.getChats());
        model.addAttribute("flagged", this.messageService.getFlagged());
        return "chat";
    }

    @PostMapping("/chat")
    public String addChat(@ModelAttribute("chat")ChatForm chatForm, Model model) {

        chatForm.getChatMessage().setUsername(userService.currentUser().getName());
        chatForm.getChatMessage().setMessage(messageService.messageMode(chatForm));//set mode

        //add message
        String errorMsg = null;
        int rowsAdded = messageService.addMessage(chatForm.getChatMessage());
        if(rowsAdded < 1) {
            errorMsg = "Could not save message. Please try again";
            model.addAttribute("errorMessage", errorMsg);
        }
        model.addAttribute("chats", messageService.getChats());
        model.addAttribute("flagged", messageService.getFlagged());
        chatForm.setMode("");
        chatForm.setChatMessage(new ChatMessage());
        return "chat";
    }
}
