import java.io.*;
import java.util.*;

/**
 * CCC '02 S4 - Bridge Crossing
 * Question URL: Dynamic Programming
 * 50/50 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc02s4
 * @author Tommy Pang
 */
public class CCC02S4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int M, Q, mod = (int) 1e9+7;
    static int [] dp, path;
    public static void main(String[] args) throws IOException {
        M = readInt(); Q = readInt();
        dp = new int[Q+1]; // dp[i] -> for the first i person, what's the min time required
        path = new int[Q+1]; // the index of the last person in the previous group
        List<person> queue = new ArrayList<>();
        queue.add(null);
        for (int i = 0; i < Q; i++) {
            queue.add(new person(readLine(), readInt()));
        }
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        path[0] = -1;
        for (int i = 1; i <= Q; i++) {
            for (int j = 1; j <= M; j++) {
                if (i-j>=0) {
                    int l = i-j;
                    int max = getMax(queue, l, i);
                    if (dp[l]+max<dp[i]) {
                        path[i] = l;
                        dp[i] = dp[l]+max;
                    }
                }
            }
        }
        int cur = Q;
        List<Integer> order = new ArrayList<>();
        order.add(cur);
        while (path[cur]!=-1) {
            order.add(path[cur]);
            cur = path[cur];
        }
        order.remove(order.size()-1);
        Collections.reverse(order);
        int lst = 1;
        System.out.println("Total Time: " + dp[Q]);
        for (int i = 0; i < order.size(); i++) {
            for (int j = lst; j <= order.get(i); j++) {
                System.out.print(queue.get(j).name + " ");
            }
            lst = order.get(i)+1;
            System.out.println();
        }
    }
    public static int getMax(List<person> q, int l, int r) {
        int max = 0;
        for (int i = l+1; i <= r; i++) {
            max = Math.max(max, q.get(i).time);
        }
        return max;
    }
    public static class person {
        String name;
        int time;
        person(String name, int time) { this.name = name; this.time = time; }
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
    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }
    static char readCharacter() throws IOException {
        return next().charAt(0);
    }
    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}
