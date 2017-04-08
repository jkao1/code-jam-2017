import java.util.*;
import java.io.*;

public class TidyNumbers {

    private static void makeTidy(long num, int caseNumber)
    {
        int[] ary = longToArray(num);
        int trackedDigit = -1;
        int repeated = 0;
        for (int i = 0; i < ary.length - 1; i++) {
            if (ary[i] == trackedDigit) {
                repeated++;
            } else {
                trackedDigit = ary[i];
                repeated = 0;
            }
            if (ary[i] > ary[i + 1]) {
                ary[i - repeated]--;
                sweep9(ary, i - repeated + 1);
            }
        }
        String output = print(ary);
        System.out.println("Case #" + caseNumber + ": " + output);
    }

    private static int[] longToArray(long n)
    {
        String number = String.valueOf(n);
        int[] output = new int[ number.length() ];
        for (int i = 0; i < output.length; i++) {
            output[i] = number.charAt(i) - '0';
        }
        return output;
    }

    private static void sweep9(int[] ary, int index)
    {
        for (int i = index; i < ary.length; i++) {
            ary[i] = 9;
        }
    }

    private static long arrayToLong(int[] ary)
    {
        long output = 0;
        int place = 0;
        for (int i = ary.length - 1; i >= 0; i--) {
            output += ary[i] * Math.pow(10, place);
            place++;
        }
        return output;
    }

    private static String print(int[] ary)
    {
        String o = "";
        for (int i : ary) {
            o += i + "";
        }
        return o;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner( new BufferedReader( new InputStreamReader( System.in )));
        int testCases = in.nextInt();
        int caseNumber = 1;
        while (in.hasNext()) {
            long num = in.nextLong();
            makeTidy(num, caseNumber);
            caseNumber++;
        }
    }

}
