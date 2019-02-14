package interfaces;

public interface ChatBot extends Colleague {
    void setSpamMessage(String message);
    void spam();
}
