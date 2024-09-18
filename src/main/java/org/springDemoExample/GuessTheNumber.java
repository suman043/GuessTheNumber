package org.springDemoExample;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxRounds = 3;  // Number of rounds
        int maxAttempts = 5;  // Maximum number of attempts per round
        int totalScore = 0;

        System.out.println("Welcome to the Guess the Number Game!");

        for (int round = 1; round <= maxRounds; round++) {
            int randomNumber = random.nextInt(100) + 1;  // Random number between 1 and 100
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + round);
            System.out.println("Guess a number between 1 and 100:");

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Attempt " + (attempts + 1) + ": ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    guessedCorrectly = true;
                    int roundScore = (maxAttempts - attempts + 1) * 10;  // Points based on attempts left
                    totalScore += roundScore;
                    System.out.println("Congratulations! You guessed the number.");
                    System.out.println("You scored " + roundScore + " points this round.");
                } else if (userGuess < randomNumber) {
                    System.out.println("The number is higher. Try again.");
                } else {
                    System.out.println("The number is lower. Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! You've used all attempts. The number was " + randomNumber + ".");
            }

            System.out.println("Your total score after round " + round + " is " + totalScore + " points.");
        }

        System.out.println("\nGame over! Your final score is " + totalScore + " points.");
        scanner.close();
    }
}

