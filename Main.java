import java.util.Random;
import java.util.Scanner;

class Game {
    private int number;
    private int inputNumber;
    private int noOfGuesses = 0;
    private final int maxGuesses = 5;
    Game() {
        Random rand = new Random();
        this.number = rand.nextInt(100) + 1;
    }
    void takeUserInput() {
        System.out.println("Guess the number:");
        Scanner sc = new Scanner(System.in);
        inputNumber = sc.nextInt();
    }
    boolean isCorrectNumber() {
        noOfGuesses++;
        if (inputNumber == number) {
            System.out.format("Yes, you guessed it right! It was %d.\nYou guessed it in %d attempts.", number, noOfGuesses);
            return true;
        } else if (inputNumber < number) {
            System.out.println("Too low...");
        } else {
            System.out.println("Too high...");
        }
        if (noOfGuesses >= maxGuesses) {
            System.out.println("Sorry, you've used all your attempts! The number was " + number + ".");
            return true;
        } else {
            System.out.println("You have " + (maxGuesses - noOfGuesses) + " attempts left.");
        }

        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Game g = new Game();
        boolean hasGuessedCorrectly = false;

        while (!hasGuessedCorrectly) {
            g.takeUserInput();
            hasGuessedCorrectly = g.isCorrectNumber();
        }
    }
}

