package impl;

import interfaces.Colleague;
import interfaces.Mediator;

public class Main {

    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();

        Colleague javan = new User("Javan", mediator);
        Colleague ursus = new User("Ursus", mediator);
        Colleague gerlind = new User("Gerlind", mediator);
        Colleague solveiga = new User("Solveiga", mediator);

        javan.send("Hi Ursus!", "Ursus");
        ursus.receive();
        ursus.send("Hey Javan, what's up?", "Javan");
        javan.receive();
        gerlind.send("wXQ4gyqC6IkWEbo7+46ivw==", "Solveiga");
        solveiga.receive();
        solveiga.send("Wut?", "Gerlind");
        gerlind.receive();
        solveiga.send("Guys I think Gerlind's hacked", "Javan");
        javan.receive();
        solveiga.send("Guys I think Gerlind's hacked", "Ursus");
        ursus.receive();
    }
}
