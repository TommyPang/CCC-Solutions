import java.io.*;
import java.util.*;
/**
 * CCC '21 S4 - Daily Commute
 * Question type: Graph Theory
 * 4/15 on DMOJ, TLE on Batch 4-5
 * Question URL: https://dmoj.ca/problem/ccc21s4
 * @author Tommy Pang
 */
public class CCC21S4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7, N, W, D;
    static List<Integer> [] adj;
    static int [] permutation;
    public static void main(String[] args) throws IOException{
        N = readInt(); W = readInt(); D = readInt();
        adj = new List[N+1]; permutation = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < W; i++) {
            int a = readInt(), b = readInt();
            adj[a].add(b);
        }
        for (int i = 0; i < N; i++) {
            permutation[i] = readInt();
        }
        for (int i = 0; i < D; i++) {
            int a = readInt(), b = readInt();
            int temp = permutation[a-1];
            permutation[a-1] = permutation[b-1];
            permutation[b-1] = temp;
            Queue<state> queue = new LinkedList<>();
            int time = 0; queue.add(new state(1, 0));
            boolean [] vis = new boolean[N+1]; vis[1] = true;
            loop:
            while (!queue.isEmpty()) {
                //boolean [] temp_vis = vis.clone();
                int size = queue.size();
                while (size>0) {
                    state cur = queue.poll(); size--;
                    if (cur.idx==N) {
                        System.out.println(cur.time);
                        break loop;
                    }
                    for (int nxt : adj[cur.idx]) {
                        if (!vis[nxt]) {
                            queue.add(new state(nxt, time+1));
                            vis[nxt] = true;
                        }
                    }
                    int v = permutation[time];
                    if (cur.idx==v) {
                        if (time+1<N && !vis[permutation[time+1]]) {
                            queue.add(new state(permutation[time+1], cur.time+1));
                            vis[permutation[time+1]] = true;
                        }
                    }
                    else {
                        queue.add(new state(cur.idx, cur.time+1));
                    }
                }
                time++; //vis = temp_vis.clone();
            }
        }


    }
    static class state {
        int idx, time;
        state(int i, int t) {
            idx = i; time = t;
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
}
