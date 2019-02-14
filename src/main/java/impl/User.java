package impl;

import interfaces.Mediator;
import interfaces.Colleague;

import java.util.Collections;
import java.util.List;

public class User implements Colleague {

    private String username;
    private Mediator mediator;

    public User(String username, Mediator mediator) {
        this.username = username;
        this.mediator = mediator;
    }

    @Override
    public void send(String content, String recipient) {
        mediator.postMessage(new Message(content, recipient, username));
    }

    @Override
    public void receive(Message message) {
        System.out.println(message);
    }

    @Override
    public String getUsername() {
        return username;
    }
}
