package impl;

import interfaces.ChatBot;
import interfaces.Mediator;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class MemoryBot implements ChatBot {
    private String message;
    private String username;
    private Mediator mediator;
    private Set<String> usernamesOfTheDamned;

    public MemoryBot(Mediator mediator, String username, String message) {
        this.mediator = mediator;
        this.username = username;
        this.message = message;
        this.usernamesOfTheDamned = new TreeSet<>();
    }

    @Override
    public void setScamMessage(String message) {
        this.message = message;
    }

    @Override
    public void spam() {
        usernamesOfTheDamned.addAll(findUnfortunateSouls());
        usernamesOfTheDamned
                .stream()
                .map(fool -> new Message(message, fool, username))
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
