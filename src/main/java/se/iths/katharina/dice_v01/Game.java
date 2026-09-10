package se.iths.katharina.dice_v01;

public class Game {

    String BOLD = "\u001B[1m";
    String RESET = "\u001B[0m";
    String GREEN = "\u001B[32m";
    String BLUE = "\u001B[34m";
    String RED = "\u001B[31m";
    String PURPLE = "\u001B[35m";

    public void playGame() {

        boolean playAgain = false;
        //Player 1 input and validation
        do {
            IO.println(BOLD + BLUE + "Välkommen, spelare 1!" + RESET);
            String firstName1 = IO.readln("Skriv in ditt förnamn: ");
            do {
                try {
                    if (firstName1.equals("")) {
                        throw new IllegalArgumentException();
                    }
                } catch (IllegalArgumentException e) {
                    IO.println(RED + "Du måste skriva ditt förnamn." + RESET);
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
                    IO.println(RED + "Du måste skriva ditt efternamn." + RESET);
                    lastName1 = IO.readln("Skriv in ditt efternamn: ");

                }
            } while (lastName1.equals(""));


            Player player1 = new Player(firstName1, lastName1);
            IO.println(GREEN + BOLD + "Trevligt att träffas, " + player1.getFullName() + "! Gör dig redo för första kastet." + RESET);

            //Player 2 input and validation
            IO.println(BOLD + BLUE + "Välkommen, spelare 2!" + RESET);
            String firstName2 = IO.readln("Skriv in ditt förnamn: ");
            do {
                try {
                    if (firstName2.equals("")) {
                        throw new IllegalArgumentException();
                    }
                } catch (IllegalArgumentException e) {
                    IO.println(RED + "Du måste skriva ditt förnamn." + RESET);
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
                    IO.println(RED + "Du måste skriva ditt efternamn." + RESET);
                    lastName2 = IO.readln("Skriv in ditt efternamn: ");

                }
            } while (lastName2.equals(""));

            Player player2 = new Player(firstName2, lastName2);
            IO.println(GREEN + BOLD + "Trevligt att träffas, " + player2.getFullName() + "! Gör dig redo för första kastet." + RESET);

            //Roll the dice and update scores
            int player1FirstRoll = Dice.rollDice();
            IO.println(player1.getFirstName() + ", ditt första kast ger: " + player1FirstRoll);
            player1.addToScore(player1FirstRoll);

            int player1SecondRoll = Dice.rollDice();
            IO.println(player1.getFirstName() + ", ditt andra kast ger: " + player1SecondRoll);
            player1.addToScore(player1SecondRoll);

            int player2FirstRoll = Dice.rollDice();
            IO.println(player2.getFirstName() + ", ditt första kast ger: " + player2FirstRoll);
            player2.addToScore(player2FirstRoll);

            int player2SecondRoll = Dice.rollDice();
            IO.println(player2.getFirstName() + ", ditt andra kast ger: " + player2SecondRoll);
            player2.addToScore(player2SecondRoll);
            //Show total scores
            IO.println(player1.getFullName() + " - din totala poäng är: " + player1.getScore());
            IO.println(player2.getFullName() + " - din totala poäng är: " + player2.getScore());
            //Determine the winner
            if (player1.getScore() > player2.getScore()) {
                IO.println(BOLD + GREEN + player1.getFullName() + ", du vinner." + RESET);
            } else if (player2.getScore() > player1.getScore()) {
                IO.println(BOLD + GREEN + player2.getFullName() + ", du vinner." + RESET);
            } else {
                IO.println(BOLD + BLUE + "Det är oavgjort." + RESET);
            }

            boolean validAnswer = false;
            //Ask if players want another round
            do {

                String answer = IO.readln(BOLD + PURPLE + "Vill du spela igen?" + RESET);
                answer = answer.toLowerCase();

                switch (answer) {
                    case "ja" -> {
                        IO.println("Spela igen.");
                        validAnswer = true;
                        playAgain = true;

                    }
                    case "nej" -> {
                        IO.println(BOLD + RED + "Avsluta Roll the Dice." + RESET);
                        validAnswer = true;
                        playAgain = false;

                    }
                    default -> {
                        IO.println(RED + "Ogiltigt val. Försök igen." + RESET);
                        validAnswer = false;
                    }
                }
            } while (!validAnswer);

        } while (playAgain);
    }
}
