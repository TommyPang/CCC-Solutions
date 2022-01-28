import java.io.*;
import java.util.*;
/**
 * CCC '13 S4 - Who is Taller?
 * Question URL: Graph Theory
 * 300/300 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc13s4
 * @author Tommy Pang
 */
public class CCC13S4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7, n, m;
    static List<Integer> [] adj;
    static boolean[] vis;
    public static void main(String[] args) throws IOException {
        n = readInt(); m = readInt();
        adj = new List[n+1]; vis = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            adj[readInt()].add(readInt());
        }
        int p = readInt(), q = readInt();
        if (BFS(p, q)) System.out.println("yes");
        else if (BFS(q, p)) System.out.println("no");
        else System.out.println("unknown");
    }
    static boolean BFS(int p, int q) {
        Queue<Integer> queue = new LinkedList<>(); vis = new boolean[n+1];
        queue.add(p);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int nxt : adj[cur]) {
                if (!vis[nxt]) {
                    vis[nxt] = true;
                    queue.add(nxt);
                }
            }
        }
        return vis[q];
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
