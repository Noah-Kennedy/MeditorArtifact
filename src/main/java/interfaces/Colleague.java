package interfaces;

import impl.Message;

import java.util.List;

public interface Colleague {
    void send(String content, String... recipients);
    void receive();
}
