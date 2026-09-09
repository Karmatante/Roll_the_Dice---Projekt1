package se.iths.katharina.dice_v01;

public class Player {
    private String firstName;
    private String lastName;
    private int score;


    public Player(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public int getScore() {
        return score;
    }

    public void addToScore(int score) {
        this.score = this.score + score;
    }

}
