package org.example;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @PostConstruct
    public void init() {
        System.out.println("Start");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Stop");
    }
}
