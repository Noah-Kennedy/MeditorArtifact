package impl;

import interfaces.ChatBot;
import interfaces.Mediator;

import java.util.Set;
import java.util.TreeSet;

public class MemoryBot implements ChatBot {
    private final String username;
    private final Mediator mediator;
    private final Set<String> usernamesOfTheDamned;
    private String message;

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
