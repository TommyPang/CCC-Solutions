import java.io.*;
import java.util.*;
/**
 * CCC '17 S4 - Minimum Cost Flow
 * Question URL: Graph Theory
 * 17/17 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc17s4
 * @author Tommy Pang
 */
public class CCC17S4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7;
    static int N, M, D;
    static int [] leader, rank;
    static List<edge> pipes = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        N = readInt(); M = readInt(); D = readInt();
        leader = new int[N+1]; rank = new int[N+1];
        make_set();
        for (int i = 1; i <= M; i++) {
            edge pipe = new edge(readInt(), readInt(), readInt(), i);
            pipes.add(pipe);
        }
        Collections.sort(pipes);
        int max = 0, activated = 0, toActivate = 0;
        for (edge nxt : pipes) {
            if (find(nxt.a) != find(nxt.b)) {
                union(nxt.a, nxt.b);
                max = Math.max(max, nxt.c);
                if (nxt.idx>N-1) toActivate++;
                else activated++;
            }
        }
        int cnt = Math.max(toActivate, N-1-activated);
        if (D==0) System.out.println(cnt);
        else {
            make_set();
            for (edge nxt : pipes) {
                if (find(nxt.a) != find(nxt.b)) {
                    if (nxt.c<max || (nxt.idx<=N-1 && nxt.c==max)) {
                        union(nxt.a, nxt.b);
                    }
                    else if (nxt.c<=D && nxt.idx<=N-1) {
                        cnt--;
                        break;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
    static void make_set() {
        for (int i = 1; i <= N; i++) {
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

    static class edge implements Comparable<edge> {
        int a, b, c, idx;
        public edge(int start, int end, int w, int i){
            a = start; b = end; c = w; idx = i;
        }

        @Override
        public int compareTo(edge o) {
            return Long.compare (c, o.c);
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
