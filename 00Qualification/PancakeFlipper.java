import java.util.*;
import java.io.*;

public class PancakeFlipper {

    private static void organizeTest(String test)
    {
        int[] ary = new int[ test.length() ];
        int upTo = 0;
        char current = test.charAt(0);
        for ( int i = 0; i < test.length(); i++ ) {
            if ( test.charAt(i) == current ) {
                ary[ upTo ]++;
            } else {
                current = test.charAt(i);
                upTo++;
                ary[ upTo ]++;
            }
        }
        flip( test, test.charAt(0) == '-' );
    }

    private static void flip(int[] ary, boolean negativeFirst)
    {
        if ( negativeFirst ) {
            int pancakeCount = 0;
            int upTo = 0;
            while ( pancakeCount < 3 ) {
                
            }
        }
    }

    private static void print(int[] ary) {
        String o = "[";
        for ( int i : ary ) {
            o += i + ",";
        }
        System.out.println( o.substring( 0, o.length() - 1 ) + "]" );
    }

    public static void main(String[] args)
    {
        String in = "---+-++-";
        organizeTest( in );
        /*
        Scanner in = new Scanner( new BufferedReader( new InputStreamReader( System.in )));
        int testCases = in.nextInt();
        while ( in.hasNext() ) {
            try {
                String line = in.nextLine();
                Scanner s = new Scanner( line );
                String test = s.next();
                int flips = s.nextInt();
                organizeTest( test );
            } catch (Exception e) {}
        }
        */
    }
}
