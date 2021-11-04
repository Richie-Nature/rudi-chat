package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.mapper.MessageMapper;
import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class MessageService {
    private String message;
    private MessageMapper messageMapper;
    private List<ChatMessage> chats;
    public List<String> flagged;

    public MessageService(String message, MessageMapper messageMapper) {
        this.message = message;
        this.messageMapper = messageMapper;
    }

    public String upperCase() {
        return this.message.toUpperCase(Locale.ROOT);
    }

    public String lowerCase() {
        return this.message.toLowerCase(Locale.ROOT);
    }

    public String upperCase(String message) {
        return message.toUpperCase(Locale.ROOT);
    }

    public String lowerCase(String message) {
        return message.toLowerCase(Locale.ROOT);
    }

    public int addMessage(ChatMessage chatMessage) {
//        this.chats.add(chatMessage);
        return this.messageMapper.insert(chatMessage);
    }

    public String messageMode(ChatForm chatForm) {
        String mode = chatForm.getMode();
        String message = chatForm.getChatMessage().getMessage();
        if(mode.equals("say")) {
            return message;
        } else if (mode.equals("shout")) {
            return upperCase(message);
        } else {
            return lowerCase(message);
        }
    }

    public List<ChatMessage> getChats() {
        return this.messageMapper.findAll();
    }

    public List<String> getFlagged() {
        System.out.println(this.flagged);
        return this.flagged;
    }

    @PostConstruct
    public void postConstruct() {//after MessageService has been instantiated and added to context
        System.out.println(this.message);
        this.chats = new ArrayList<>();
        this.flagged = new ArrayList<>();
                flagged.add("hate");
                flagged.add("speech");
                flagged.add("ode");
    }
}