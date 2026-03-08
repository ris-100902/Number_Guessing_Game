import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Start {
    public int intro() throws IOException, NumberFormatException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        IO.print("Enter your choice:  ");
        String difficulty = reader.readLine();
        int difficultyLevel = Integer.parseInt(difficulty.trim());
        String levelString = """

Great! You have selected the %s difficulty level.
Let's start the game!""";
        IO.println(String.format(levelString, levelIntro(difficultyLevel)));
        return difficultyLevel;
    }

    String levelIntro(int level) {
        return switch (level) {
            case 1 -> {
                yield("Easy");
            }
            case 2 -> {
                yield("Medium");
            }
            case 3 -> {
                yield ("Hard");
            }
            default ->{
                throw new AssertionError("Invalid Number");
            }
        };
    }

    public void printIntroduction() {
        IO.println("""
Welcome to the Number Guessing Game!
I'm thinking of a number between 1 and 100.
You have 5 chances to guess the correct number.

Please select the difficulty level:
1. Easy (10 chances)
2. Medium (5 chances)
3. Hard (3 chances)
                """);
    }
}