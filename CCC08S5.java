import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * CCC '08 S5 - Nukit
 * Question type: Dynamic Programming, Game Theory
 * 7/7 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc08s5
 * @author Tommy Pang
 */
public class CCC08S5 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7, T, A, B, C, D;
    static int [][][][] dp;
    public static void main(String[] args) throws IOException {
        T = readInt();
        for (int i = 0; i < T; i++) {
            dp = new int[31][31][31][31];
            init();
            A = readInt(); B = readInt(); C = readInt(); D = readInt();
            if (win(A, B, C, D)) System.out.println("Patrick");
            else System.out.println("Roland");
        }
    }
    public static boolean win(int A, int B, int C, int D) {
        if (dp[A][B][C][D]!=-1) return dp[A][B][C][D] == 1;
        if (!canMove(A, B, C, D)) {
            dp[A][B][C][D] = 0;
            return false; // loses
        }
        // 1.AABDD
        if (A>=2 && B>=1 && D>=2) {
            if (!win(A-2, B-1, C, D-2)) {
                dp[A][B][C][D] = 1;
                return true;
            }
        }
        // 2.ABCD
        if (A>=1 && B>=1 && C>=1 && D>=1) {
            if (!win(A-1, B-1, C-1, D-1)) {
                dp[A][B][C][D] = 1;
                return true;
            }
        }
        // 3.CCD
        if (C>=2 && D>=1) {
            if (!win(A, B, C-2, D-1)) {
                dp[A][B][C][D] = 1;
                return true;
            }
        }
        // 4.BBB
        if (B>=3) {
            if (!win(A, B-3, C, D)) {
                dp[A][B][C][D] = 1;
                return true;
            }
        }
        // 5.AD
        if (A>=1 && D>=1) {
            if (!win(A-1, B, C, D-1)) {
                dp[A][B][C][D] = 1;
                return true;
            }
        }
        dp[A][B][C][D] = 0;
        return false;
    }
    public static boolean canMove(int A, int B, int C, int D) {
        boolean ret = A>=2 && B>=1 && D>=2;
        ret |= A>=1 && B>=1 && C>=1 && D>=1;
        ret |= C>=2 && D>=1;
        ret |= B>=3;
        ret |= A>=1 && D>=1;
        return ret;
    }
    public static void init() {
        for (int i = 0; i < 31; i++) {
            for (int j = 0; j < 31; j++) {
                for (int k = 0; k < 31; k++) {
                    for (int l = 0; l < 31; l++) {
                        dp[i][j][k][l] = -1;
                    }
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
