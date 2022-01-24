import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
/**
 * CCC '09 S2 - Lights Going On and Off
 * Question type: Implementation
 * 5/5 on DMOJ
 * @author Tommy Pang
 */
public class CCC09S2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7, R, L;
    public static void main(String[] args) throws IOException {
        R = readInt(); L = readInt();
        Set<Integer> cur = new HashSet<>();
        Set<Integer> nxt = new HashSet<>();
        int cur_mask;
        for (int i = 0; i < R; i++) {
            cur_mask = 0;
            for (int j = 0; j < L; j++) {
                cur_mask = (cur_mask<<1) | readInt();
            }
            nxt.add(cur_mask);
            for (int nxt_mask : cur) {
                nxt.add(cur_mask^nxt_mask);
            }
            cur = nxt;
            nxt = new HashSet<>();
        }
        System.out.println(cur.size());
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
