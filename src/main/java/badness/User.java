package badness;

public class User {

    private final String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String message, User userTo) {
        userTo.receiveMessage(message, this);
    }

    public void receiveMessage(String message, User from) {
        System.out.println(from.getName() + " -> " + name + ":\n" + message);
    }
}
