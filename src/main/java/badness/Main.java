package interfaces;

public class Main {

    public static void main(String[] args) {
        User javan = new User("Javan");
        User ursus = new User("Ursus");
        User gerlind = new User("Gerlind");
        User solveiga = new User("Solveiga");

        javan.sendMessage("Hi Ursus!", "Ursus");
        ursus.sendMessage("Hey Javan, what's up?", "Javan");
        gerlind.sendMessage("wXQ4gyqC6IkWEbo7+46ivw==", "Solveiga");
        solveiga.sendMessage("Wut?", "Gerlind");
        solveiga.sendMessage("Guys I think Gerlind's hacked", "Javan");
        solveiga.sendMessage("Guys I think Gerlind's hacked", "Ursus");
    }
}
