package impl;

import interfaces.Mediator;
import interfaces.Colleague;

import java.util.List;

public class User implements Colleague {

    private String username;
    private Mediator mediator;

    public User(String username, Mediator mediator) {
        this.username = username;
        this.mediator = mediator;
    }

    @Override
    public void send(String content, String recipients...) {
        for(String recipient : recipients) {
            mediator.postMessage(new Message(content, recipient, username));
        }
    }

    @Override
    public void receive() {
        mediator.getMessages(username).forEach(System.out::println);
    }
}
