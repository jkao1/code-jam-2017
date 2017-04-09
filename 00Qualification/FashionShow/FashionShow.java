import java.util.*;import java.util.*;
import java.io.*;

public class FashionShow {

    public static void main(String[] args) {
        Scanner in = new Scanner( new BufferedReader( new InputStreamReader( System.in )));
        int testCases = in.nextInt();
        int caseNumber = 1;
        while (caseNumber <= testCases && in.hasNext()) {
            try {
                long stalls = in.nextLong();
                long people = in.nextLong();
                bathroomTime( stalls, people, caseNumber );
                caseNumber++;
            } catch (NoSuchElementException e) {}
        }
    }

}

