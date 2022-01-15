import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * CCC '12 S5 - Mouse Journey
 * Question type: Dynamic Programming
 * 70/70 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc12s5
 * @author Tommy Pang
 */
public class CCC12S5 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7;
    static int [][] dp;
    static boolean [][] hasCat, vis;
    static int R, C, K;
    public static void main(String[] args) throws IOException {
        R = readInt(); C = readInt(); K = readInt();
        hasCat = new boolean[R+1][C+1]; dp = new int[R+1][C+1]; vis = new boolean[R+1][C+1];
        for (int i = 1; i <= K; i++) {
            hasCat[readInt()][readInt()] = true;
        }
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        System.out.println(dfs(1, 1));
    }
    public static int dfs(int r, int c) {
        if (r<1 || c<1 || r>R || c>C || hasCat[r][c] || vis[r][c]) return 0;
        if (r==R && c==C) return 1;
        if (dp[r][c]!=-1) return dp[r][c];
        int ret = 0;
        vis[r][c] = true;
        ret += dfs(r, c+1);
        ret += dfs(r+1, c);
        dp[r][c] = ret;
        vis[r][c] = false;
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
