package impl;

import interfaces.Mediator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    public List<Message> receive() {
        return mediator.getMessages(username);
    }
}
