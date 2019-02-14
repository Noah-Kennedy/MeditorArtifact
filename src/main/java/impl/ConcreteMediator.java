package impl;

import interfaces.Mediator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConcreteMediator implements Mediator {
    private ArrayList<Message> messages;

    public ConcreteMediator() {
        this.messages = new ArrayList<>();
    }

    @Override
    public void postMessage(Message message) {
        messages.add(message);
    }

    @Override
    public List<Message> getMessages(String username) {
        return messages
                .parallelStream()
                .filter(message -> message.getReceiver().equals(username))
                .collect(Collectors.toList());
    }
}
