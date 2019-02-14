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
    public void setSpamMessage(String message) {
        this.message = message;
    }

    @Override
    public void spam() {
        usernamesOfTheDamned
                .stream()
                .map(fool -> new Message(message, fool, username))
                .forEach(mediator::postMessage);
    }

    @Override
    public void send(String content, String recipient) {
        mediator.postMessage(new Message(content, recipient, username));
    }

    @Override
    public void receive(Message message) {
        usernamesOfTheDamned.add(message.getSender());
    }

    @Override
    public String getUsername() {
        return username;
    }
}
