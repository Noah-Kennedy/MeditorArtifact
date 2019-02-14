package impl;

import interfaces.ChatBot;
import interfaces.Mediator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RespondingBot implements ChatBot {
    private String message;
    private String username;
    private Mediator mediator;

    public RespondingBot(Mediator mediator, String username, String message) {
        this.mediator = mediator;
        this.username = username;
        this.message = message;
    }

    @Override
    public void setSpamMessage(String message) {
        this.message = message;
    }

    @Override
    public void spam() {
        findUnfortunateSouls()
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
}
