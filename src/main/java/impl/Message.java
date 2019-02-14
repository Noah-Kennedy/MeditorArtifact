package impl;

public class Message {
    private final String content;
    private final String receiver;
    private final String sender;

    public Message(String content, String receiver, String sender) {
        this.content = content;
        this.receiver = receiver;
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getSender() {
        return sender;
    }

    @Override
    public String toString() {
        return getSender() + " -> " + getReceiver() + ":\n" + getContent();
    }
}
