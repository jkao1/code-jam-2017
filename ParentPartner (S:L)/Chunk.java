import java.util.*;

public class Chunk implements Comparable<Chunk> {

    public int s, e;
    char n;

    public Chunk(int start, int end, char name) {
        s = start;
        e = end;
        n = name;
    }

    public boolean isJamie() {
        return n == 'j';
    }

    public boolean isCameron() {
        return n == 'c';
    }

    public String toString() {
        return s + "-" + n + "-" + e;
    }

    public int compareTo(Chunk b) {
        return this.s - b.s;
    }
}
