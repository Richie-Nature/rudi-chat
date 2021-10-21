package com.udacity.jwdnd.c1.review;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Locale;

@Service
public class MessageService {
    private String message;
    public MessageService(String message) {
        this.message = message;
    }

    String upperCase() {
        return this.message.toUpperCase(Locale.ROOT);
    }

    String lowerCase() {
        return this.message.toLowerCase(Locale.ROOT);
    }

    @PostConstruct
    public void postConstruct() {//after MessageService has been instantiated and added to context
        System.out.println(this.message);
    }
}