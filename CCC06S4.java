import java.io.*;
import java.util.StringTokenizer;

/**
 * CCC '06 S4 - Groups
 * Question type: Intermediate Math
 * 30/30 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc06s4
 * @author Tommy Pang
 */

public class CCC06S4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int n, mod = (int) 1e9+7, identity = -1;
    static int[][] table;
    public static void main(String[] args) throws IOException {
        n = readInt();
        do {
            table = new int[n+1][n+1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    table[i][j] = readInt();
                }
            }
            if (identity() && inverse() && associative()) {
                System.out.println("yes");
            }
            else {
                System.out.println("no");
            }
            n = readInt();
        }
        while (n!=0);
    }
    public static boolean associative() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (table[i][table[j][k]] != table[table[i][j]][k]) return false;
                }
            }
        }
        return true;
    }
    public static boolean inverse() {
        for (int i = 1; i <= n; i++) {
            boolean valid = false;
            for (int j = 1; j <= n; j++) {
                if (table[i][j] == identity && table[j][i] == identity) {
                    valid = true;
                    break;
                }
            }
            if (!valid) return false;
        }
        return true;
    }
    public static boolean identity() {
        for (int i = 1; i <= n; i++) {
            int cur = i;
            boolean valid = true;
            for(int j = 1; j <= n; ++j){
                if (table[cur][j] != j || table[j][cur] != j) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                identity = cur;
                return true;
            }
        }
        return false;
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
