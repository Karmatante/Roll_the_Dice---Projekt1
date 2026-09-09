package se.iths.katharina.dice_v01;

public class Game {

    public void playGame() {

        String firstName1 = IO.readln("Ditt förnamn: ");
        String lastName1 = IO.readln("Ditt efternamn: ");
        Player player1 = new Player(firstName1, lastName1);


        String firstName2 = IO.readln("Ditt förnamn: ");
        String lastName2 = IO.readln("Ditt efternamn: ");
        Player player2 = new Player(firstName2, lastName2);

        int player1FirstRoll = Dice.rollDice();
        IO.println(player1.getFirstName() + ", din första kast ger: " + player1FirstRoll);
        player1.addToScore(player1FirstRoll);

        int player1SecondRoll = Dice.rollDice();
        IO.println(player1.getFirstName() + ", din andra kast ger: " + player1SecondRoll);
        player1.addToScore(player1SecondRoll);

        int player2FirstRoll = Dice.rollDice();
        IO.println(player2.getFirstName() + ", din första kast ger: " + player2FirstRoll);
        player2.addToScore(player2FirstRoll);

        int player2SecondRoll = Dice.rollDice();
        IO.println(player2.getFirstName() + ", din andra kast ger: " + player2SecondRoll);
        player2.addToScore(player2SecondRoll);

        IO.println(player1.getFullName() + " - din totala poäng är: " + player1.getScore());
        IO.println(player2.getFullName() + " - din totala poäng är: " + player2.getScore());

        if (player1.getScore() > player2.getScore()) {
            IO.println(player1.getFullName() + ", du vinner.");
        } else if (player2.getScore() > player1.getScore()) {
            IO.println(player2.getFullName() + ", du vinner.");
        } else {
            IO.println("Det är oavgjort.");
        }
    }
}