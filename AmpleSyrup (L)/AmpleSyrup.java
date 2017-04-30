import java.util.*;
import java.io.*;

public class AmpleSyrup {

    public static double maxO = 0.0;

    private static void sumPancakes(int[][] p, double sum, int upTo, int i, int k)
    {
        if (upTo == k) {
            if (sum > maxO) {
                maxO = sum;
            }
            return;
        }
        if (i == p.length) {
            return;
        }

        sumPancakes(p, sum, upTo, i + 1, k);

        sum += getSA(p[i]);
        if (upTo > 0) {
            sum -= getArea(p[i][0]);
        }

        sumPancakes(p, sum, upTo + 1, i + 1, k);
    }

    private static double getArea(int r) {
        return Math.PI * r * r;
    }

    private static double getSA(int[] x) {
        return getArea(x[0]) + Math.PI * 2 * x[0] * x[1];
    }

    public static void printPancakes(int[][] p)
    {
        String output = "[ ";
        for (int[] cake : p) {
            output += "[";
            for (int i : cake) {
                output += i + ",";
            }
            output += "]";
        }
        System.out.println(output);
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner( new BufferedReader( new InputStreamReader( System.in )));
        int numCases = in.nextInt();
        int caseNumber = 1;
        while (in.hasNext()) {
            int pancakes = in.nextInt();
            int ordered = in.nextInt();
            int[][] p = new int[pancakes][2];
            for (int i = 0; i < pancakes; i++) {
                int[] hi = { in.nextInt(), in.nextInt() };
                p[i] = hi;
            }
            Arrays.sort(p, new Comparator<int[]>() {
                    public int compare(int[] a, int[] b) {
                        return Integer.compare(a[0], b[0]) * -1;
                    }
                });
            sumPancakes(p, 0.0, 0, 0, ordered);
            System.out.println("Case #" + caseNumber + ": " + maxO);
            maxO = 0.0;
            // function call
            caseNumber++;
        }
    }


}
