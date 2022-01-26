import java.io.*;
import java.util.*;
/**
 * CCC '10 S4 - Animal Farm
 * Question type: Graph Theory
 * 50/100 on DMOJ, 50/50 on official data, 0/50 on additional test data(total 200 cases)
 * Question URL: https://dmoj.ca/problem/ccc10s4
 * @author Tommy Pang
 */
public class CCC10S4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7, n, e, MM = 1005, ans = 0;
    static int [] leader = new int[MM], rank = new int[MM];
    public static void main(String[] args) throws IOException {
        make_set(); n = readInt();
        List<edge> edges1 = new ArrayList<>();
        List<edge2> edges2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            e = readInt();
            int [] nodes = new int[e];
            int [] weight = new int[e];
            for (int j = 0; j < e; j++) {
                nodes[j] = readInt();
            }
            for (int j = 0; j < e; j++) {
                weight[j] = readInt();
            }
            for (int j = 0; j < e; j++) {
                boolean paired = false;
                edge cur = new edge(nodes[j], nodes[(j+1)%e], weight[j], i);
                for (edge nxt : edges1) {
                    if ((cur.v==nxt.v && cur.u==nxt.u) || (cur.u==nxt.v && cur.v==nxt.u)) {
                        edges2.add(new edge2(i, nxt.idx, nxt.w));
                        paired = true;
                        edges1.remove(nxt);
                        break;
                    }
                }
                if (!paired) edges1.add(cur);
            }
        }
        for (edge notPaired : edges1) {
            edges2.add(new edge2(notPaired.idx, n, notPaired.w));
        }
        Collections.sort(edges2);
        for (edge2 nxt: edges2) {
            if (connect() && find(nxt.u)!=find(nxt.v)) {
                ans+=nxt.w;
                union(nxt.u, nxt.v);
            }
        }

        System.out.println(ans);
    }
    static boolean connect() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (find(i)!=find(j)) {
                    return true;
                }
            }
        }
        return false;
    }
    static void make_set() {
        for (int i = 0; i < MM; i++) {
            leader[i] = i;
            rank[i] = 0;
        }
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
    public static class edge {
        int u, v, w, idx;

        public edge(int a, int b, int c, int i) {
            u = a; v = b; w = c; idx = i;
        }
    }
    public static class edge2 implements Comparable<edge2> {
        int u, v, w;
        public edge2(int a, int b, int c) {
            u = a; v = b; w = c;
        }

        @Override
        public int compareTo(edge2 o) {
            return w-o.w;
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
