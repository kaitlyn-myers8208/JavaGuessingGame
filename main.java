import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String userResponse = "yes";
        while (userResponse.equals("yes")) {
      System.out.println("Welcome to the number guessing game!");
      System.out.println("Easy: unlimited guesses");
      System.out.println("Hard: only three guesses allowed");
      System.out.println("What mode to do you want to play? (easy/hard)");
      String userMode = System.console().readLine();
      System.out.println("What is the highest you want our random num to go? ");
      String userRangeStr = System.console().readLine();
      int userRange = Integer.parseInt(userRangeStr);

      System.out.println("Picking the random number");
      // cute timing animation
      Random rand = new Random();
      int randomNum1 = rand.nextInt(userRange);
      System.out.println(randomNum1);
    //   System.out.println(userMode);

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
                System.out.println("That's incorrect. Guess a new number between 0 and " + userRange);
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
            System.out.println("You have " + remainingGuesses + " guesses left. Guess a number between 0 and " + userRange);
            String userGuessStr = System.console().readLine();
            int userGuess = Integer.parseInt(userGuessStr);
            tries++;
            remainingGuesses--;
        
            if (userGuess == randomNum1) {
                System.out.println("You guessed it after " + tries + " tries! Nice job!");
                remainingGuesses = 0;
                System.out.println("Do you want to play again? (yes/no)");
                userResponse = System.console().readLine();
            }
            // else {
            //     // System.out.println("That's incorrect. You have " + remainingGuesses + " guess(es) left. Guess a new number between 0 and " + userRange);
            //     // userGuessStr = System.console().readLine();
            //     // userGuess = Integer.parseInt(userGuessStr);
            //     tries++;
            //     remainingGuesses--;
            // }
        }
        if (tries >= 3 /*&& userGuess != randomNum1*/) {
            System.out.println("You didn't guess it in time. Too bad. Do you want to try again? (yes/no)");
            userResponse = System.console().readLine();
        }
      }
      else {
        System.out.println("That's an incorrect response");
      }
    }
    System.out.println("Thank you for playing!");

      // add difficulties (hard allows only three guesses or something) DONE
      // add hints
      // add cute loading animation
      // ask if they want to play again and loop DONE? (does easy work?)
      /* add two player mode -> either your friend picks the num then 
        clears console or they race and get different times */



      // picking a number
      // cute loading graphic
      // ask user for a guess
      // check if it's write
      // give hint
      // repeat until correct
      // say how many guesses you got it in
      // congratulate user
      // ask if they want to play again
    }
  }