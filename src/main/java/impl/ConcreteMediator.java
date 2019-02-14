package impl;

import interfaces.Colleague;
import interfaces.Mediator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteMediator implements Mediator {
    private final List<Colleague> colleagues;

    public ConcreteMediator() {
        this.colleagues = new ArrayList<>();
    }

    @Override
    public void postMessage(Message message) {
        colleagues.stream().filter(colleague -> colleague.getUsername().equals(message.getReceiver())).forEach(colleague -> colleague.receive(message));
    }

    @Override
    public void addColleague(Colleague colleague) {
        colleagues.add(colleague);
    }
}
