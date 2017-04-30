import java.util.*;
import java.io.*;

public class Parent {

    public static int switches = 0;

    public static void schedule(Chunk[] c, int cAct, int jAct)
    {
        int startTime = 0;
        int t = startTime;
        int cLeft = 720;
        int jLeft = 720;
        int timeOn = 'c';
        int upTo = 0;
        switches = 0;
        while (t < startTime + 1440) {

            if (t == c[upTo].s && c[upTo].n == timeOn && c[upTo].isCameron()) {
                timeOn = 'j';
                switches++;
            }
            if (t == c[upTo].s && c[upTo].n == timeOn && c[upTo].isJamie()) {
                timeOn = 'c';
                switches++;
            }
            if (timeOn == 'c') {
                cLeft--;
            }
            if (timeOn == 'j') {
                jLeft--;
            }
            t++;

        }
    }


    public static void print(Chunk[] c) {
        String output = "[ ";
        for (Chunk ch : c) {
            output += ch + ", ";
        }
        System.out.println(output + "]");
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner( new BufferedReader( new InputStreamReader( System.in )));
        int numCases = in.nextInt();
        int caseNumber = 1;
        while (in.hasNext()) {
            int Ac = in.nextInt();
            int Aj = in.nextInt();
            System.out.println(Ac + ", " + Aj);
            Chunk[] c = new Chunk[Ac + Aj];
            int timeC = 0, timeJ = 0;
            for (int i = 0; i < Ac; i++) {
                c[i] = new Chunk(in.nextInt(), in.nextInt(), 'c');
                timeC += c[i].e - c[i].s;
            }
            for (int i = Ac; i < Ac + Aj; i++) {
                c[i] = new Chunk(in.nextInt(), in.nextInt(), 'c');
                System.out.println("chunk: " + c[i].s + " " + c[i].e);
                timeJ += c[i].e - c[i].s;
            }
            Arrays.sort(c);
            schedule(c, timeC, timeJ);
            print(c);
            System.out.println("Case #" + caseNumber + ": " + switches);
            caseNumber++;
        }
    }
}
