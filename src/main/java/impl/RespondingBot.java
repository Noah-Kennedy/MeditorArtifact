package impl;

import interfaces.ChatBot;
import interfaces.Mediator;

import java.util.LinkedList;
import java.util.List;

public class RespondingBot implements ChatBot {
    private final String username;
    private final Mediator mediator;
    private final List<String> fools;
    private String message;

    public RespondingBot(Mediator mediator, String username, String message) {
        this.mediator = mediator;
        this.username = username;
        this.message = message;
        fools = new LinkedList<>();
    }

    @Override
    public void setSpamMessage(String message) {
        this.message = message;
    }

    @Override
    public void spam() {
        fools
                .stream()
                .map(idiot -> new Message(message, idiot, username))
                .forEach(mediator::postMessage);
    }

    @Override
    public void send(String content, String recipient) {

    }

    @Override
    public void receive(Message message) {
        fools.add(message.getSender());
    }

    @Override
    public String getUsername() {
        return username;
    }
}
