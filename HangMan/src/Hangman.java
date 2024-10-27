import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Hangman {
    public static void main(String[] args) {
        String[] words = {
            "apple", "banana", "computer", "programming", "java", "python", "keyboard", "monitor", "internet", "phone",
            "laptop", "mouse", "battery", "window", "browser", "coffee", "mountain", "river", "forest", "language",
            "library", "teacher", "student", "school", "university", "science", "medicine", "hospital", "doctor", "engineer",
            "airplane", "airport", "travel", "station", "museum", "guitar", "piano", "trumpet", "violin", "clarinet",
            "skateboard", "bicycle", "tractor", "firetruck", "ambulance", "calendar", "festival", "holiday", "trip", "route",
            "galaxy", "planet", "universe", "asteroid", "satellite", "climate", "weather", "rain", "sun", "lightning",
            "flower", "garden", "forest", "desert", "tropical", "island", "volcano", "earthquake", "hurricane", "typhoon",
            "football", "basketball", "cricket", "baseball", "tennis", "badminton", "chess", "puzzle", "domino", "race",
            "painting", "sculpture", "architecture", "design", "drawing", "cartoon", "comedy", "theater", "cinema", "film",
            "robot", "machine", "engine", "turbine", "generator", "laser", "rocket", "spaceship", "satellite", "galaxy",
            "ender"
        };

        Random rand = new Random();
        
        String chosenWord = words[rand.nextInt(words.length)];
        char[] hiddenWord = new char[chosenWord.length()];
        Arrays.fill(hiddenWord, '*');
        int attempts = chosenWord.length() * 2; 
        
        Scanner scanner = new Scanner(System.in);
        
        Set<Character> guessedLetters = new HashSet<>();

        while (attempts > 0) {
            System.out.print("Word: " + new String(hiddenWord));
            System.out.print("\nEnter your guessed letter (lowercase only): ");
            char guess = scanner.next().charAt(0);
            
            if (guessedLetters.contains(guess)) {
                System.out.println("You have already guessed this letter! Try another letter.");
                continue; 
            }
            
            guessedLetters.add(guess);

            boolean found = false;
            for (int i = 0; i < chosenWord.length(); i++) {
                if (chosenWord.charAt(i) == guess) {
                    hiddenWord[i] = guess;
                    found = true;
                }
            }

            if (!found) {
                attempts--;
                System.out.println("Incorrect guess! Remaining attempts: " + attempts);
            }

            if (new String(hiddenWord).equals(chosenWord)) {
                System.out.println("Congratulations! You guessed the word correctly: " + chosenWord);
                break;
            } 
            else if (attempts <= 0) {
                System.out.println("You lost! The word was: " + chosenWord);
                break;
            }
        }
    }
}
