package interfaces;

import impl.Message;

public interface Mediator {
    void postMessage(Message message);

    void addColleague(Colleague colleague);
}
