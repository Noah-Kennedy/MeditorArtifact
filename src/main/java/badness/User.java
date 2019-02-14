package badness;

import java.util.ArrayList;

public class User {

    private static final ArrayList<User> users = new ArrayList<>();
    private String name;

    public User(String name) {
        this.name = name;
        users.add(this);
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String message, String userTo) {
        for(User user : users) {
            if(user.getName().equals(userTo)) {
                user.receiveMessage(message, this);
            }
        }
    }

    public void receiveMessage(String message, User from) {
        System.out.println(from.getName() + " -> " + name + ":\n" + message);
    }
}
