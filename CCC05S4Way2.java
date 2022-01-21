import java.io.*;
import java.util.*;
/**
 * CCC '05 S4 - Pyramid Message Scheme
 * Question type: Graph Theory
 * 1/1 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc05s4
 * @author Tommy Pang
 */
public class CCC05S4Way2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7;
    static int L, n, total, max_depth = 0;
    static Map<String, List<String>> adj = new HashMap<>();
    public static void main(String[] args) throws IOException {
        L = readInt();
        for (int i = 0; i < L; i++) {
            n = readInt();
            max_depth = 0;
            adj = new HashMap<>();
            total = n*10;
            String [] names = new String[n];
            for (int j = 0; j < n; j++) {
                names[j] = readLine();
            }
            Stack<String> stk = new Stack<>();
            stk.push(names[n-1]);
            for (int j = 0; j < n; j++) {
                String nxt = names[j];
                if (stk.contains(nxt)) {
                    while (!stk.peek().equals(nxt)) stk.pop();
                }
                else {
                    adj.putIfAbsent(stk.peek(), new ArrayList<>());
                    adj.get(stk.peek()).add(nxt);
                }
                if (!stk.peek().equals(nxt)) stk.push(nxt);
            }
            dfs(names[n-1], 0);
            System.out.println(total-20*max_depth);
        }
    }
    public static void dfs(String cur, int dep) {
        max_depth = Math.max(dep, max_depth);
        if (!adj.containsKey(cur)) return;
        for (String nxt : adj.get(cur)) {
            dfs(nxt, dep+1);
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
