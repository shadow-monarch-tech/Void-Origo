import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCounter {

    public static void main(String[] args) throws IOException {

        // Create Input stream & scanner
        FileInputStream fin = new FileInputStream("POEM.txt");
        Scanner fileInput = new Scanner(fin);

        // Create the ArrayLists
        ArrayList<String> words = new ArrayList<String>();
        ArrayList<Integer> count = new ArrayList<Integer>();

        // Create the ArrayLists for numbers
        ArrayList<String> numbers = new ArrayList<String>();
        ArrayList<Integer> numCount = new ArrayList<Integer>();

        // Read through file and find the words and numbers
        while (fileInput.hasNext()) {
            // Get the next word
            String nextWord = fileInput.next();

            // Check if the token is a number
            if (nextWord.matches("[0-9]+")) {
                // Determine if the number is already in the ArrayList
                if (numbers.contains(nextWord)) {
                    int index = numbers.indexOf(nextWord);
                    numCount.set(index, numCount.get(index) + 1);
                } else {
                    numbers.add(nextWord);
                    numCount.add(1);
                }
            } else {
                // Determine if the word is in the ArrayList
                if (words.contains(nextWord)) {
                    int index = words.indexOf(nextWord);
                    count.set(index, count.get(index) + 1);
                } else {
                    words.add(nextWord);
                    count.add(1);
                }
            }
        }

        //  Close AFTER the loop is done
        fileInput.close();
        fin.close();

        // Print out the word results
        for (int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i) + " occurred " + count.get(i) + " times(s)");
        }

        // Print out the number results
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i) + " occurred " + numCount.get(i) + " times(s)");
        }
    }
}
