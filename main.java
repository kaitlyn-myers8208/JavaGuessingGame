import java.util.Random;
import java.time.Duration;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {
      String userResponse = "yes";
      while (userResponse.equals("yes")) {
        System.out.println("Welcome to the number guessing game!");
        System.out.println("Easy: unlimited guesses");
        System.out.println("Hard: only three guesses allowed");
        System.out.println("2-Player: compete against a friend to see who gets the fastest time");
        System.out.println("What mode to do you want to play? (easy/hard/two)");
        String userMode = System.console().readLine();
        System.out.println("What is the highest you want our random num to go? ");
        String userRangeStr = System.console().readLine();
        int userRange = Integer.parseInt(userRangeStr);

        System.out.println("Picking the random number");
        // cute timing animation
        Random rand = new Random();
        int randomNum1 = rand.nextInt(userRange);
        // TESTS
        // System.out.println(randomNum1);
        // System.out.println(userMode);

        if (userMode.toLowerCase().equals("easy")) {
            System.out.println("Guess a number between 0 and " + userRange);
            String userGuessStr = System.console().readLine();
            int userGuess = Integer.parseInt(userGuessStr);
            int count = 1;
      
            if (userGuess == randomNum1) {
              System.out.println("You guessed it on the first try! Nice job!");
              System.out.println("Do you want to play again? (yes/no)");
              userResponse = System.console().readLine();
            }
            else {
              while (userGuess != randomNum1) {
                if (userGuess > randomNum1) {
                  System.out.println("That's incorrect. Your guess is too high");
                }
                else if (userGuess < randomNum1) {
                  System.out.println("That's incorrect. Your guess is too low");
                }
                  System.out.println("Guess a new number between 0 and " + userRange);
                  userGuessStr = System.console().readLine();
                  userGuess = Integer.parseInt(userGuessStr);
                  count++;
              }
              System.out.println("Nice job! You guessed it! It took you " + count + " tries");
              System.out.println("Do you want to play again? (yes/no)");
              userResponse = System.console().readLine();
            }

        }
        else if (userMode.toLowerCase().equals("hard")) {
          int tries = 0;
          int remainingGuesses = 3;
          while (remainingGuesses != 0) {
              System.out.println("You have " + remainingGuesses + " guess(es) left. Guess a number between 0 and " + userRange);
              String userGuessStr = System.console().readLine();
              int userGuess = Integer.parseInt(userGuessStr);
              tries++;
              remainingGuesses--;
          
              if (userGuess == randomNum1) {
                  System.out.println("You guessed it after " + tries + " tries! Nice job!");
                  tries = 0;
                  remainingGuesses = 0;
                  System.out.println("Do you want to play again? (yes/no)");
                  userResponse = System.console().readLine();
              }
              else {
                if (userGuess > randomNum1) {
                  System.out.println("That's incorrect. Your guess is too high");
                }
                else if (userGuess < randomNum1) {
                  System.out.println("That's incorrect. Your guess is too low");
                }
              }
          }
          if (tries >= 3) {
              System.out.println("You didn't guess it in time. Too bad. Do you want to try again? (yes/no)");
              userResponse = System.console().readLine();
          }
        }
        else if (userMode.equals("two")) {
          System.out.println("Enter Player 1's name");
          String playerOneName = System.console().readLine();
          System.out.println("Enter Player 2's name");
          String playerTwoName = System.console().readLine();
          System.out.println("Ready " + playerOneName + "? GO!");
          System.out.println();

          // PLAYER ONE
          Instant playerOneStartTime = Instant.now();
          System.out.println("Guess a number between 0 and " + userRange);
          String userGuessStr = System.console().readLine();
          int userGuess = Integer.parseInt(userGuessStr);
          int playerOneTries = 1;
    
          if (userGuess == randomNum1) {
            System.out.println("You guessed it on the first try! Nice job!");
          }
          else {
            while (userGuess != randomNum1) {
              if (userGuess > randomNum1) {
                System.out.println("That's incorrect. Your guess is too high");
              }
              else if (userGuess < randomNum1) {
                System.out.println("That's incorrect. Your guess is too low");
              }
                System.out.println("Guess a new number between 0 and " + userRange);
                userGuessStr = System.console().readLine();
                userGuess = Integer.parseInt(userGuessStr);
                playerOneTries++;
            }
            System.out.println("Nice job! You guessed it! It took you " + playerOneTries + " tries");
          }
          Instant playerOneEndTime = Instant.now();

          // PLAYER TWO
          System.out.println("Now it's " + playerTwoName + "'s turn. Ready? GO!");

          int randomNum2 = rand.nextInt(userRange);
          System.out.println(randomNum2);
          Instant playerTwoStartTime = Instant.now();
          System.out.println("Guess a number between 0 and " + userRange);
          userGuessStr = System.console().readLine();
          userGuess = Integer.parseInt(userGuessStr);
          int playerTwoTries = 1;
    
          if (userGuess == randomNum2) {
            System.out.println("You guessed it on the first try! Nice job!");
          }
          else {
            while (userGuess != randomNum2) {
              if (userGuess > randomNum2) {
                System.out.println("That's incorrect. Your guess is too high");
              }
              else if (userGuess < randomNum2) {
                System.out.println("That's incorrect. Your guess is too low");
              }
                System.out.println("Guess a new number between 0 and " + userRange);
                userGuessStr = System.console().readLine();
                userGuess = Integer.parseInt(userGuessStr);
                playerTwoTries++;
            }
            System.out.println("Nice job! You guessed it! It took you " + playerTwoTries + " tries");
          }
          Instant playerTwoEndTime = Instant.now();

          // Calculate times
          Duration playerOneTime = Duration.between(playerOneStartTime, playerOneEndTime);
          Duration playerTwoTime = Duration.between(playerTwoStartTime, playerTwoEndTime);

          if (playerOneTime.toSeconds() == playerTwoTime.toSeconds()) {
            System.out.println("You both tied! Your time was " + playerOneTime.toSeconds() + " seconds");
          }
          else if (playerOneTime.toSeconds() < playerTwoTime.toSeconds()) {
            System.out.println(playerOneName + " won!!");
            System.out.println(playerOneName + "'s time: " + playerOneTime.toSeconds() + " seconds");
            System.out.println(playerTwoName + "'s time: " + playerTwoTime.toSeconds() + " seconds");
          }
          else if (playerOneTime.toSeconds() > playerTwoTime.toSeconds()) {
            System.out.println(playerTwoName + " won!!");
            System.out.println(playerTwoName + "'s time: " + playerTwoTime.toSeconds() + " seconds");
            System.out.println(playerOneName + "'s time: " + playerOneTime.toSeconds() + " seconds");
          }

          System.out.println("Do you want to play again? (yes/no)");
          userResponse = System.console().readLine();
        }
        else {
          System.out.println("That's an incorrect response");
        }
    }
    System.out.println("Thanks for playing!");
  }
}

// BASIC FUNCTIONALITY

// picking a number
// cute loading graphic
// ask user for a guess
// check if it's write
// give hint
// repeat until correct
// say how many guesses you got it in
// congratulate user
// ask if they want to play again


// EXTRA

// add cute animation for loading/picking a number
// add the ability to save results
// add the ability to keep score across several games of two player mode
// better hints?

// TO DO

// (DONE) add difficulties (hard allows only three guesses or something)
// (DONE) add hints
// (DONE) ask if they want to play again and loop
/* (DONE) add two player mode -> either your friend picks the num then 
          clears console or they race and get different times */