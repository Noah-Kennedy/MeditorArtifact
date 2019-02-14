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

        mediator.addColleague(javan);
        mediator.addColleague(ursus);
        mediator.addColleague(gerlind);
        mediator.addColleague(solveiga);

        javan.send("Hi Ursus!", "Ursus");
        ursus.send("Hey Javan, what's up?", "Javan");
        gerlind.send("wXQ4gyqC6IkWEbo7+46ivw==", "Solveiga");
        solveiga.send("Wut?", "Gerlind");
        solveiga.send("Guys I think Gerlind's hacked", "Javan");
        solveiga.send("Guys I think Gerlind's hacked", "Ursus");
    }
}
