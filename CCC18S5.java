import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
/**
 * CCC '18 S5 - Maximum Strategic Savings
 * Question URL: Graph Theory
 * 15/15 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc18s5
 * @author Tommy Pang
 */
public class CCC18S5 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7;
    static int N, M, P, Q;
    static long sumCost = 0L, MST = 0L;
    public static void main(String[] args) throws IOException {
        N = readInt(); M = readInt(); P = readInt(); Q = readInt();
        List<edge> edges = new ArrayList<>();
        for (int i = 1; i <= P; i++) {
            int a = readInt(), b = readInt(), c = readInt();
            sumCost += (long)c*N;
            edges.add(new edge(a, b, c, false));
        }
        for (int i = 1; i <= Q; i++) {
            int a = readInt(), b = readInt(), c = readInt();
            sumCost += (long)c*M;
            edges.add(new edge(a, b, c, true));
        }
        Collections.sort(edges);
        DS cities = new DS(N);
        DS planets = new DS(M);
        for (edge nxt : edges) {
            if (!nxt.v) {
                if (planets.n!= 0 && planets.find(nxt.a) != planets.find(nxt.b)) {
                    MST+=(long) cities.n * nxt.c;
                    planets.union(planets.find(nxt.a), planets.find(nxt.b));
                    planets.n--;
                }
            }
            else {
                if (cities.n!= 0 && cities.find(nxt.a) != cities.find(nxt.b)) {
                    MST+=(long)planets.n * nxt.c;
                    cities.union(cities.find(nxt.a), cities.find(nxt.b));
                    cities.n--;
                }
            }
        }
        System.out.println(sumCost-MST);
    }
    static class edge implements Comparable<edge> {
        int a, b, c;
        boolean v;
        public edge(int start, int end, int w, boolean portal){
            a = start; b = end; c = w; v = portal;
        }

        @Override
        public int compareTo(edge o) {
            return Long.compare (c, o.c);
        }
    }
    static class DS {
        int [] leader;
        int n;
        public DS(int len) {
            n = len;
            leader = new int[len+1];
            for (int i = 1; i <= n; i++) {
                leader[i] = i;
            }
        }
        void union(int a, int b){
            leader[a] = b;
        }
        int find(int n) {
            if (n != leader[n]){
                leader[n] = find(leader[n]);
            }
            return leader[n];
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
