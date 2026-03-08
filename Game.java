
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Game {
    BufferedReader reader;
    int guessNumber;
    int numberOfAttempt;

    void gameInit(int mode) {
        guessNumber = (int)(Math.random() * (100) + 1);
        numberOfAttempt = switch (mode) {
            case 1 : yield 10;
            case 2 : yield 5;
            case 3 : yield 3;
            default :
                throw new AssertionError("Invalid Number");
        };
    }

    String gamePlay() throws InvalidException, IOException{
        int attempts = 0;
        while (numberOfAttempt>0){
            try {
                int number = takeInputNumber();
                if (number == guessNumber) {
                    IO.println(String.format("Congratulations! You guessed the correct number in %s attempts.", attempts + 1));
                    break;
                }
                else if (number<guessNumber){
                    IO.println(String.format("Incorrect! The number is greater than %d.", number));
                    numberOfAttempt--;
                }
                else {
                    IO.println(String.format("Incorrect! The number is less than %d.", number));
                    numberOfAttempt--;
                }
                attempts++;
            } catch (InvalidException ie) {
                IO.println(ie);
            }
        }
        IO.println("""
\nDo you wanna play again?
Enter q to quit or r to restart
        """);
        String inputAfterEnd;
        while (true) {
            inputAfterEnd = reader.readLine().trim();
            IO.println("input is : " + inputAfterEnd);
            try {
                if (!inputAfterEnd.equals("q") && !inputAfterEnd.equals("r")) {
                    throw new InvalidException("Only q and r accepted");
                }
                else break;
            } catch (InvalidException ie) {
                IO.println(ie + "\nEnter again");
            }
        }
        return inputAfterEnd;
    }

    int takeInputNumber() throws InvalidException{
        while (true) {
            reader = new BufferedReader(new InputStreamReader(System.in));
            IO.print("\nEnter your guess: ");
            int guessedNumber;
            try {
                guessedNumber = Integer.parseInt(reader.readLine().trim());
                if (guessedNumber<=0 || guessedNumber>100) {
                    throw new InvalidException("Number should be between 1 & 100");
                }
                return guessedNumber;
            } catch (IOException | NumberFormatException e) {
                IO.println("Input a valid number");
            }
        }
    }
}