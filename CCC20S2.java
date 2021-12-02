import java.io.*;
import java.util.*;
/**
 * CCC '20 S2 - Escape Room
 * Question type: Graph Theory
 * 15/15 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc20s2
 * @author Tommy Pang
 */
public class CCC20S2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7;
    public static void main(String[] args) throws IOException{
        int n = readInt(), m = readInt();
        int [][] room = new int[n+1][m+1];
        List<pi> adj[] = new List[1000001];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                room[i][j] = readInt();
                adj[room[i][j]].add(new pi(i, j));
            }
        }
        boolean[][] vis = new boolean[n+1][m+1];
        vis[n][m] = true;
        Queue<pi> queue = new LinkedList<>();
        queue.add(new pi(n, m));
        while (!queue.isEmpty()) {
            pi cur = queue.poll();
            for (pi nxt : adj[cur.r*cur.c]) {
                if (!vis[nxt.r][nxt.c]) {
                    vis[nxt.r][nxt.c] = true;
                    queue.add(nxt);
                }
            }
        }
        if (vis[1][1]) System.out.println("yes");
        else System.out.println("no");

    }
    static class pi {
        int r, c;
        pi(int i, int j) { r = i; c = j; }
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
    static int readLongLineInt() throws IOException{
        int x = 0, c;
        while((c = br.read()) != ' ' && c != '\n')
            x = x * 10 + (c - '0');
        return x;
    }
    static long pow (long x, long exp){
        if (exp==0) return 1;
        long t = pow(x, exp/2);
        t = t*t %mod;
        if (exp%2 == 0) return t;
        return t*x%mod;
    }
    static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
    static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    // find first one grater, return list.size() if everything is smaller than or equal to v
    static int upperBound(List<Integer> list, int v) {
        int lo = 0, hi = list.size()-1;
        while (lo<=hi) {
            int mid = (lo+hi)/2;
            if (list.get(mid)>v) {
                hi = mid-1;
            }
            else lo = mid+1;
        }
        return lo;
    }
    // find first one smaller, return -1 if everything is greater then or equal to v
    static int lowerBound(List<Integer> list, int v) {
        int lo = 0, hi = list.size()-1;
        while (lo<=hi) {
            int mid = (lo+hi)/2;
            if (list.get(mid)>=v) {
                hi = mid-1;
            }
            else lo = mid+1;
        }
        return hi;
    }
}
