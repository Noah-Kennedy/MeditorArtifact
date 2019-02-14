package impl;

import interfaces.Colleague;
import interfaces.Mediator;

public class User implements Colleague {

    private final String username;
    private final Mediator mediator;

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
