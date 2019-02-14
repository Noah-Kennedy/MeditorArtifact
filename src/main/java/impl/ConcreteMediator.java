package impl;

import interfaces.Mediator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        List<Message> userMessages = messages.stream()
                .filter(message -> message.getReceiver()
                        .equals(username)).collect(Collectors.toList());

        messages.removeAll(userMessages);

        return userMessages;
    }
}
