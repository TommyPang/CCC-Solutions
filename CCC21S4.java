import java.io.*;
import java.util.*;
/**
 * CCC '21 S4 - Daily Commute
 * Question type: Graph Theory
 * 7/15 on DMOJ, TLE on Batch 5
 * Question URL: https://dmoj.ca/problem/ccc21s4
 * @author Tommy Pang
 */
public class CCC21S4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7, MM = 200005, N, W, D;
    static Map<Integer, Integer>[] disToDest = new Map[MM];
    static int[] permutation = new int[MM];
    static List<Integer> [] walk = new List[MM];
    static {
        for (int i = 0; i < MM; i++) walk[i] = new ArrayList<>();
        for (int i = 0; i < MM; i++) disToDest[i] = new HashMap<>();
    }
    public static void main(String[] args) throws IOException {
        N = readInt(); W = readInt(); D = readInt();
        for (int i = 0; i < W; i++) walk[readInt()].add(readInt());
        for (int i = 1; i <= N; i++) permutation[i] = readInt();
        for (int i = 1; i <= N ; i++) {
            BFS(i);
        }
        for (int i = 0; i < D; i++) {
            int fir = readInt(), sec = readInt();
            int temp = permutation[fir];
            permutation[fir] = permutation[sec];
            permutation[sec] = temp;
            int ans = Integer.MAX_VALUE;
            for (int j = 1; j <= N; j++) {
                if (permutation[j]==N) {
                    ans = Math.min(ans, j-1);
                }
                else ans = Math.min(ans, j-1+disToDest[permutation[j]].getOrDefault(N, Integer.MAX_VALUE/2));
            }
            System.out.println(ans);
        }

    }
    public static void BFS(int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i); disToDest[i].put(i, 0);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int nxt : walk[cur]) {
                if (disToDest[i].get(cur)+1<disToDest[i].getOrDefault(nxt, Integer.MAX_VALUE/2)) {
                    queue.add(nxt);
                    disToDest[i].put(nxt, disToDest[i].get(cur)+1);
                }
            }
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
}
