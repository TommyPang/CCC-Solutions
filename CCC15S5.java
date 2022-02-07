import java.io.*;
import java.util.*;
/**
 * CCC '15 S5 - Greedy For Pies
 * Question URL: Dynamic Programming
 * 15/15 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc15s5
 * @author Tommy Pang
 */
public class CCC15S5 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7, n, m;
    // dp[i][L][R][0/1] -> we are at position i of the regular(N) pies
    // we have [L, R] that marks the range of the sorted M pies that are still available
    // and we can take(1) or cannot take(0) current one
    static int[][][][] dp = new int[3005][2][105][105];
    static int[] A, B;
    public static void main(String[] args) throws IOException {
        n = readInt(); A = new int[n+1];
        for (int i = 1; i <= n; i++) A[i] = readInt();
        m = readInt(); B = new int[m+1];
        for (int i = 1; i <= m; i++) B[i] = readInt();
        Arrays.sort(B);
        for (int i = 0; i < 3005; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 105; k++) {
                    for (int l = 0; l < 105; l++) {
                        dp[i][j][k][l] = -1;
                    }
                }
            }
        }
        System.out.println(recursion(1, 1, m, 1));
    }
    public static int recursion(int i, int L, int R, int can) {
        if (dp[i][can][L][R]!=-1) return dp[i][can][L][R];
        int ret = 0;
        if (i<=n) {
            // take current one
            if (can==1) ret = Math.max(ret, recursion(i+1, L, R, 0) + A[i]);
            // skip current one
            ret = Math.max(ret, recursion(i+1, L, R, 1));
        }
        if (L<=R) {
            // insert and waste current one
            ret = Math.max(ret, recursion(i, L+1, R, 1));
            // insert and take current one
            if (can==1) ret = Math.max(ret, recursion(i, L, R-1, 0) + B[R]);
        }
        dp[i][can][L][R] = ret;
        return ret;
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
