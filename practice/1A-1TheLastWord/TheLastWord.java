import java.util.*;
import java.io.*;

public class TheLastWord {

    public static void lastWord(String word, int caseNumber)
    {
        char firstChar = word.charAt(0);
        String output = "" + firstChar;

        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) < firstChar) {
                output += word.charAt(i);
            } else {
                output = word.charAt(i) + output;
                firstChar = word.charAt(i);
            }
        }

        System.out.print("Case #" + caseNumber + ": " + output + "\n");
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner( new BufferedReader( new InputStreamReader( System.in )));
        int numCases = in.nextInt();
        int caseNumber = 1;
        while (in.hasNext()) {
            String word = in.next();
            lastWord(word, caseNumber);
            caseNumber++;
        }
    }
}
