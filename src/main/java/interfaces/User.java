package interfaces;

import impl.Message;

import java.util.List;

public interface User {
    void send(String content, String recipient);
    List<Message> receive();
}
