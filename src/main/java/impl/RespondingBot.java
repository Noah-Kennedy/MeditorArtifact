package impl;

import interfaces.ChatBot;
import interfaces.Mediator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class RespondingBot implements ChatBot {
    private String message;
    private String username;
    private Mediator mediator;
    private List<String> fools;

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

    private List<String> findUnfortunateSouls() {
        return mediator
                .getMessages(username)
                .stream()
                .map(Message::getSender)
                .collect(Collectors.toList());
    }

    @Override
    public void send(String content, String recipient) {

    }

    @Override
    public void receive() {
        fools.addAll(findUnfortunateSouls());
    }
}
