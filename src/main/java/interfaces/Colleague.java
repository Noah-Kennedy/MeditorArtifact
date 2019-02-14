package interfaces;

import impl.Message;

public interface Colleague {
    void send(String content, String recipient);
    void receive(Message message);
    String getUsername();
}
