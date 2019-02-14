package badness;

public class Main {

    public static void main(String[] args) {
        User javan = new User("Javan");
        User ursus = new User("Ursus");
        User gerlind = new User("Gerlind");
        User solveiga = new User("Solveiga");

        javan.sendMessage("Hi Ursus!", ursus);
        ursus.sendMessage("Hey Javan, what's up?", javan);
        gerlind.sendMessage("wXQ4gyqC6IkWEbo7+46ivw==", solveiga);
        solveiga.sendMessage("Wut?", gerlind);
        solveiga.sendMessage("Guys I think Gerlind's hacked", javan);
        solveiga.sendMessage("Guys I think Gerlind's hacked", ursus);
    }
}
