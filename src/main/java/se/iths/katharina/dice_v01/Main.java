package se.iths.katharina.dice_v01;

public class Main {
    static void main() {


        // -- ANSI COLOR CODING FOR FORMATTING --
        String BOLD = "\u001B[1m";
        String RESET = "\u001B[0m";
        String BRIGHT_PURPLE = "\u001B[95m";


        IO.println(BOLD + BRIGHT_PURPLE + "╔══════════════════════════════════════╗");
        IO.println("║            ROLL THE DICE             ║");
        IO.println("║                                      ║");
        IO.println("║             ┌──────────┐             ║");
        IO.println("║             │  O    O  │             ║");
        IO.println("║             │    O     │             ║");
        IO.println("║             │  O    O  │             ║");
        IO.println("║             └──────────┘             ║");
        IO.println("╚══════════════════════════════════════╝" + RESET);
        IO.println();

        Game game1 = new Game();
        game1.playGame();


    }
}

