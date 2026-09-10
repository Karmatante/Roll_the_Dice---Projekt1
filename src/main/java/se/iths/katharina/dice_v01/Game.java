package se.iths.katharina.dice_v01;

public class Game {

    public void playGame() {

        boolean playAgain = false;
        //Player 1 input and validation
        do {
            IO.println("Välkommen, spelare 1!");
            String firstName1 = IO.readln("Skriv in ditt förnamn: ");
            do {
                try {
                    if (firstName1.equals("")) {
                        throw new IllegalArgumentException();
                    }
                } catch (IllegalArgumentException e) {
                    IO.println("Du måste skriva ditt förnamn.");
                    firstName1 = IO.readln("Skriv in ditt förnamn: ");
                }
            } while (firstName1.equals(""));

            String lastName1 = IO.readln("Skriv in ditt efternamn: ");
            do {
                try {
                    if (lastName1.equals("")) {
                        throw new IllegalArgumentException();
                    }
                } catch (IllegalArgumentException e) {
                    IO.println("Du måste skriva ditt efternamn.");
                    lastName1 = IO.readln("Skriv in ditt efternamn: ");

                }
            } while (lastName1.equals(""));


            Player player1 = new Player(firstName1, lastName1);
            IO.println("Trevligt att träffas, " + player1.getFullName() + "! Gör dig redo för första kastet.");

            //Player 2 input and validation
            IO.println("Välkommen, spelare 2!");
            String firstName2 = IO.readln("Skriv in ditt förnamn: ");
            do {
                try {
                    if (firstName2.equals("")) {
                        throw new IllegalArgumentException();
                    }
                } catch (IllegalArgumentException e) {
                    IO.println("Du måste skriva ditt förnamn.");
                    firstName2 = IO.readln("Skriv in ditt förnamn: ");
                }
            } while (firstName2.equals(""));

            String lastName2 = IO.readln("Skriv in ditt efternamn: ");
            do {
                try {
                    if (lastName2.equals("")) {
                        throw new IllegalArgumentException();
                    }
                } catch (IllegalArgumentException e) {
                    IO.println("Du måste skriva ditt efternamn.");
                    lastName2 = IO.readln("Skriv in ditt efternamn: ");

                }
            } while (lastName2.equals(""));

            Player player2 = new Player(firstName2, lastName2);
            IO.println("Trevligt att träffas, " + player2.getFullName() + "! Gör dig redo för första kastet.");

            //Roll the dice and update scores
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
            //Show total scores
            IO.println(player1.getFullName() + " - din totala poäng är: " + player1.getScore());
            IO.println(player2.getFullName() + " - din totala poäng är: " + player2.getScore());
            //Determine the winner
            if (player1.getScore() > player2.getScore()) {
                IO.println(player1.getFullName() + ", du vinner.");
            } else if (player2.getScore() > player1.getScore()) {
                IO.println(player2.getFullName() + ", du vinner.");
            } else {
                IO.println("Det är oavgjort.");
            }

            boolean validAnswer = false;
            //Ask if players want another round
            do {

                String answer = IO.readln("Vill du spela igen? ");
                answer = answer.toLowerCase();

                switch (answer) {
                    case "ja" -> {
                        IO.println("Spela igen.");
                        validAnswer = true;
                        playAgain = true;

                    }
                    case "nej" -> {
                        IO.println("Avsluta Roll the Dice.");
                        validAnswer = true;
                        playAgain = false;

                    }
                    default -> {
                        IO.println("Ogiltigt val. Försök igen.");
                        validAnswer = false;
                    }
                }
            } while (!validAnswer);

        } while (playAgain);
    }
}
