import java.io.*;
import java.util.StringTokenizer;
/**
 * CCC '11 S3 - Alice Through the Looking Glass
 * Question type: Recursion
 * 50/50 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc11s3
 * @author Tommy Pang
 */
public class CCC11S3V2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7;
    public static void main(String[] args) throws IOException {
        int T = readInt();
        for (int i = 0; i < T; i++) {
            int m = readInt(), x = readInt(), y = readInt();
            if (recursion(x, y, m)) System.out.println("crystal");
            else System.out.println("empty");
        }
    }
    public static boolean recursion(int x, int y, int level) {
        if (level==1) {
            if (y==0 && (x==1 || x==2 || x==3)) return true;
            else if (y==1 && x==2) return true;
            else return false;
        }
        int scale = (int) Math.pow(5, level-1);
        int X = x/scale, Y = y/scale;
        if (X<1 || X>3 || Y>2) return false;
        else if (Y==0) return true; // bottom 3 boxes
        else if (X==2 && Y==1) return true; // the forth box above
        int lX = scale*X, lY = scale*Y;
        return recursion((x-lX), (y-lY), level-1);
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
