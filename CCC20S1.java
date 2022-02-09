import java.io.*;
import java.util.*;
/**
 * CCC '20 S1 - Surmising a Sprinter's Speed
 * Question type: Implementation
 * 15/15 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc20s1
 * @author Tommy Pang
 */
public class CCC20S1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7, n;
    public static void main(String[] args) throws IOException {
        n = readInt();
        List<info> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new info(readInt(), readInt()));
        }
        Collections.sort(list);
        double ans = 0;
        for (int i = 0; i < n-1; i++) {
            info cur = list.get(i), nxt = list.get(i+1);
            ans = Math.max(((double) Math.abs(cur.X - nxt.X)) / Math.abs(cur.T-nxt.T), ans);
        }
        System.out.println(ans);
    }
    public static class info implements Comparable<info> {
        int T, X;
        info(int time, int dis) {
            T = time; X = dis;
        }

        @Override
        public int compareTo(info o) {
            return T-o.T; // sort by time
        }
    }




    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong() throws IOException {
        return Long.parseLong(next());
    }
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
}
