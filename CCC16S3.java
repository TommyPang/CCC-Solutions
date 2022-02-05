import java.io.*;
import java.util.*;
/**
 * CCC '16 S3 - Phonomenal Reviews
 * Question URL: Graph Theory
 * 15/15 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc16s3
 * @author Tommy Pang
 */
public class CCC16S3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7, n, m, MM = (int) 1e5+5;
    static List<Integer> [] adj = new ArrayList[MM];
    static boolean[] isRest = new boolean[MM];
    static int max, u, total_node;
    static int[] dis = new int[MM];
    static boolean[] vis = new boolean[MM];
    static {
        for (int i = 0; i < MM; i++) {
            adj[i] = new ArrayList<>();
        }
    }
    public static void main(String[] args) throws IOException {
        input(); total_node = n;
        dfs(u, -1);
        System.out.println((total_node-1)*2-FindDiameter(u));
    }
    static int FindDiameter(int i) {
        dis = new int[MM];
        vis = new boolean[MM];
        max = 1; u = -1;
        BFS(i);
        dis = new int[MM];
        vis = new boolean[MM];
        max = 1;
        BFS(u);
        return max;
    }

    static void BFS(int i){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i); vis[i] = true; dis[i] = 0; u = i; max = 0;
        while (!queue.isEmpty()){
            int cur = queue.poll();
            for (int nxt : adj[cur]) {
                if (!vis[nxt] && isRest[nxt]) {
                    queue.add(nxt);
                    vis[nxt] = true;
                    dis[nxt] = dis[cur]+1;
                    if (dis[nxt]>max) {
                        u = nxt;
                        max = dis[nxt];
                    }
                }
            }
        }
    }

    static boolean dfs(int v, int pa) {
        for (int nxt : adj[v]) {
            if (nxt!=pa) {
                isRest[v] |= dfs(nxt, v);
            }
        }
        if (!isRest[v]) total_node--;
        return isRest[v];
    }

    static void input() throws IOException {
        n = readInt(); m = readInt();
        for (int i = 0; i < m; i++) {
            u = readInt();
            isRest[u] = true;
        }
        for (int i = 0; i < n-1; i++) {
            int a = readInt(), b = readInt();
            adj[a].add(b); adj[b].add(a);
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
}
