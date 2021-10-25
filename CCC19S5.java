import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * CCC '19 S5 - Triangle: The Data Structure
 * Question type: Data Structures
 * 15/15 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc19s5
 * @author Tommy Pang
 */
public class CCC19S5 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7;
    public static void main(String[] args) throws IOException{
        int N = readInt(), K  =readInt(), a[][] = new int[N+1][N+1];
        for(int i=1; i<=N; i++)
            for(int j=1; j<=i; j++)
                a[i][j] = readInt();
        int cur = 0, nxt = 0;
        for(cur=1, nxt=2; nxt <= K; cur=nxt, nxt=(int)(1.5*cur)){
            int d = nxt - cur;
            for(int i=1; i<=N-nxt+1; i++){
                for(int j=1; j<=i; j++){
                    a[i][j] = Math.max(a[i][j], Math.max(a[i+d][j], a[i+d][j+d]));
                }
            }
        }
        int d = K - cur; long ans = 0;
        for(int i=1; i<=N-K+1; i++)
            for(int j=1; j<=i; j++)
                ans += Math.max(a[i][j], Math.max(a[i+d][j], a[i+d][j+d]));
        System.out.println(ans);
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
