import java.util.*;import java.util.*;
import java.io.*;

public class BathroomStalls {

    private static void bathroomTime(long stalls, long people, int caseNumber)
    {
        if (people > stalls * 2 /3){
            System.out.println("Case #" + caseNumber + ": 0 0");
            return;
        } // fix condition;

        LinkedList<Long> empties = new LinkedList<>();
        empties.add(stalls);

        for (int p = 0; p < people - 1; p++) {
            long shouldSplit = Collections.max(empties);
            int index = empties.indexOf(shouldSplit);
            if (shouldSplit % 2 == 0) {
                empties.set(index, shouldSplit / 2 - 1);
                empties.add(index + 1, shouldSplit / 2);
            } else {
                empties.set(index, shouldSplit / 2);
                empties.add(index + 1, shouldSplit / 2); // rounds down .5 each time, removing emptie a person took
            }
        }
        long shouldSplit = Collections.max(empties);
        int index = empties.indexOf(shouldSplit);
        long left = 0, right = 0;
        if (shouldSplit % 2 == 0) {
            left = shouldSplit / 2 - 1; // accounts for emptie a person took
            right = shouldSplit / 2;
        } else {
            left = shouldSplit / 2;
            right = shouldSplit / 2; // rounds down .5 each time, removing emptie a person took
        }
        System.out.println("Case #" + caseNumber + ": " + Math.max(left, right) + " " + Math.min(left, right));
    }

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

