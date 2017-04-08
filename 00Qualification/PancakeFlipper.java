import java.util.*;
import java.io.*;

public class PancakeFlipper {

    private static void organizeTest(String test, int testCaseNum, int paddleSize )
    {
        int[] ary = new int[ test.length() ];
        for (int i = 0; i < test.length(); i++) {
            if (test.charAt(i) == '+') {
                ary[i] = 1;
            } else {
                ary[i] = 0;
            }
        }

        System.out.println( "Case #" + testCaseNum + ": " + flip(ary, 0, paddleSize) );
    }

    private static String flip(int[] ary, int flips, int paddleSize)
    {
        if (goodArray(ary)) {
            return "" + flips;
        }
        for (int i = 0; i < ary.length - paddleSize + 1; i++) {
            if (ary[i] == 0) {
                for (int j = i; j < i + paddleSize; j++) {
                    if (ary[j] == 0) {
                        ary[j] = 1;
                    } else {
                        ary[j] = 0;
                    }
                }
                return flip(ary, flips+1, paddleSize);
            }
        }
        return "IMPOSSIBLE";
    }

    private static boolean goodArray(int[] ary)
    {
        for (int i : ary) {
            if (i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void print(int[] ary) {
        String o = "";
        for ( int i : ary ) {
            if (i == 0) {
                o += '-';
            } else {
                o += '+';
            }
        }
        System.out.println(o);
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner( new BufferedReader( new InputStreamReader( System.in )));
        int testCases = in.nextInt();
        int testCaseNum = 0;
        while ( in.hasNext() ) {
            try {
                String line = in.nextLine();
                Scanner s = new Scanner( line );
                String test = s.next();
                int paddleSize = s.nextInt();
                organizeTest( test, testCaseNum, paddleSize );
            } catch (Exception e) {}
            testCaseNum++;
        }
    }
}
