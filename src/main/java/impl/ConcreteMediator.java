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
        return IntStream
                .range(0, messages.size())
                .filter(i -> messages.get(i).getReceiver().equals(username))
                .mapToObj(i -> messages.remove(i))
                .collect(Collectors.toList());
    }
}
