import java.io.*;
import java.util.*;

/**
 * CCC '03 S5 - Trucking Troubles
 * Question type: Graph Theory
 * 100/100 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc03s5
 * @author Tommy Pang
 */


public class CCC03S5 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7, C, R, D, MM = (int) 1e4+5;
    static int [] rank = new int[MM], leader = new int[MM];
    static List<edge2> [] adj = new List[MM];
    static List<Integer> dest = new ArrayList<>();
    static List<edge> edges = new ArrayList<>();
    static List<edge> MST = new ArrayList<>();
    static int[] dis = new int[MM];
    public static void main(String[] args) throws IOException {
        // first build MST then run Dijkstra on the MST
        readInput();
        int ans = Integer.MAX_VALUE;
        Collections.sort(edges);
        for (edge e : edges) {
            if (find(e.u)!=find(e.v)) {
                union(e.u, e.v);
                MST.add(e);
            }
        }
        for (edge e : MST) {
            adj[e.u].add(new edge2(e.v, e.w));
            adj[e.v].add(new edge2(e.u, e.w));
        }
        PriorityQueue<edge2> pq = new PriorityQueue<>();
        Arrays.fill(dis, Integer.MIN_VALUE);
        pq.add(new edge2(1, Integer.MAX_VALUE));
        while (!pq.isEmpty()) {
            edge2 cur = pq.poll();
            if (cur.w<=dis[cur.v]) continue;
            dis[cur.v] = cur.w;
            for (edge2 nxt : adj[cur.v]) {
                pq.add(new edge2(nxt.v, Math.min(nxt.w, cur.w)));
            }
        }
        for (int d : dest) {
            ans = Math.min(dis[d], ans);
        }
        System.out.println(ans);
    }
    static void union(int a, int b){
        a = find(a); b = find(b);
        if(a != b) {
            if (rank[a] > rank[b]) {
                rank[a]++;
                leader[b] = a;
            } else {
                rank[b]++;
                leader[a] = b;
            }
        }
    }
    static int find(int n){
        if (n != leader[n]){
            leader[n] = find(leader[n]);
        }
        return leader[n];
    }
    public static void makeSet() {
        for (int i = 1; i <= C; i++) {
            leader[i] = i;
            rank[i] = 0;
            adj[i] = new ArrayList<>();
        }
    }
    public static class edge implements Comparable<edge> {
        int u, v, w;
        edge(int beg, int dest, int c) { u = beg; v = dest; w = c; }

        @Override
        public int compareTo(edge o) {
            return -Integer.compare(w, o.w);
        }
    }
    public static class edge2 implements Comparable<edge2> {
        int v, w;
        edge2(int dest, int c) { v = dest; w = c; }

        @Override
        public int compareTo(edge2 o) {
            return -Integer.compare(w, o.w);
        }
    }
    public static void readInput() throws IOException {
        C = readInt(); R = readInt(); D = readInt();
        makeSet();
        for (int i = 0; i < R; i++) edges.add(new edge(readInt(), readInt(), readInt()));
        for (int i = 0; i < D; i++) dest.add(readInt());
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
