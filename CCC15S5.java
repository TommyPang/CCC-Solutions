import java.io.*;
import java.util.*;
/**
 * CCC '15 S5 - Greedy For Pies
 * Question URL: Dynamic Programming
 * 9/15 on DMOJ, IR for case 9-14
 * Question URL: https://dmoj.ca/problem/ccc15s5
 * @author Tommy Pang
 */
public class CCC15S5 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7, n, m;
    static int[] A = new int[3005], B = new int[105];
    static long[][][] dp;
    public static void main(String[] args) throws IOException {
        n = readInt(); for (int i = 0; i < n; i++) A[i] = readInt();
        m = readInt(); for (int i = 0; i < m; i++) B[i] = readInt();
        dp = new long[n+1][1<<m][2]; // 1<<m will overflow for larger m
        System.out.println(recursion(0, 0, false));
    }

    public static long recursion(int i, int msk, boolean taken) {
        if (i==n && msk==(1<<m)-1) return 0;
        int k = taken?1:0;
        if (dp[i][msk][k]!=0) return dp[i][msk][k];
        long ret = 0;
        if (taken) {
            if (i<n) ret = Math.max(ret, recursion(i+1, msk, false)); // waste element A
            for (int j = 0; j < m; j++) {
                if ((msk>>j & 1) == 0) {
                    ret = Math.max(ret, recursion(i, msk | (1<<j), false)); // waste element B
                }
            }
        }
        else {
            if (i<n) {
                ret = Math.max(ret, recursion(i + 1, msk, true) + A[i]); // take element A
                ret = Math.max(ret, recursion(i + 1, msk, false)); // skip element A
            }
            for (int j = 0; j < m; j++) {
                if ((msk>>j & 1) == 0) {
                    ret = Math.max(ret, recursion(i, msk | (1<<j), true) + B[j]); // take element B
                    ret = Math.max(ret, recursion(i, msk | (1<<j), false)); // skip element B
                }
            }
        }
        dp[i][msk][k] = ret;
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