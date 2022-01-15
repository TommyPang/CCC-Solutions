import java.io.*;
import java.util.*;
/**
 * CCC '13 S5 - Factor Solitaire
 * Question type: Greedy Algorithms, Intermediate Math
 * 150/150 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc13s5
 * @author Tommy Pang
 */

public class CCC13S5 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7, n, ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        n = readInt();
        dfs(n, 0);
        System.out.println(ans);
    }
    public static void dfs(int v, int cost) {
        if (v==1) {
            ans = Math.min(cost, ans);
            return;
        }
        if (v<0 || cost>ans) return;
        int half = v/2;
        for (int i = half; i >= 1; i--) {
            int c = v-i;
            if (c%i==0) {
                dfs(v - i, cost + (c / i));
                break;
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
