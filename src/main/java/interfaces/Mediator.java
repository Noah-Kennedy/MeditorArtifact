package interfaces;

import impl.Message;

import java.util.List;

public interface Mediator {
    void postMessage(Message message);
    void addColleague(Colleague colleague);
}
