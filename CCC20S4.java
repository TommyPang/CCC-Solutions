import java.io.*;
import java.util.*;
/**
 * CCC '20 S4 - Swapping Seats
 * Question type: Greedy Algorithms
 * 15/15 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc20s4
 * @author Tommy Pang
 */
public class CCC20S4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7, n;
    static int[] A, B, C;
    static int cntA, cntB, cntC, ans= Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        String s = readLine(); n = s.length();
        A = new int[n+1]; B = new int[n+1]; C = new int[n+1];
        for (int i = 1; i <= n; i++) {
            A[i] = A[i-1]; B[i] = B[i-1]; C[i] = C[i-1];
            char c = s.charAt(i-1);
            if (c=='A') A[i]++;
            else if (c=='B') B[i]++;
            else C[i]++;
        }
        cntA = A[n]; cntB = B[n]; cntC = C[n];
        for (int l = 1; l <= n; l++) {
            if (l>=cntA+cntB) {
                compute(A, B, l); compute(B, A, l);
            }
            if (l>=cntA+cntC) {
                compute(A, C, l); compute(C, A, l);
            }
            if (l>=cntB+cntC) {
                compute(B, C, l); compute(C, B, l);
            }
        }
        System.out.println(ans);
    }
    public static void compute(int[] x, int[] y, int i) {
        int nx = x[n], ny = y[n];
        int sum = ny - (y[i]-y[i-ny]) + nx - (x[i-ny] - x[i-ny-nx]);
        int both = Math.min(y[i-ny] - y[i-ny-nx], x[i] - x[i-ny]);
        ans = Math.min(sum-both, ans);
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
