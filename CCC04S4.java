import java.io.*;
import java.text.DecimalFormat;
import java.util.StringTokenizer;
/**
 * CCC '04 S4 - Space Turtle
 * Question type: Geometry
 * 100/100 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc04s4
 * @author Tommy Pang
 */
public class CCC04S4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7;
    static double sx, sy, sz;
    static double tx, ty, tz;
    static double x, y, z, nxtX, temp, len;
    static char c;
    static double dis = Double.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        sx = readDouble(); sy = readDouble(); sz = readDouble();
        tx = readDouble(); ty = readDouble(); tz = readDouble();
        x = tx-sx; y = ty-sy; z = tz-sz;
        dis = x*x + y*y + z*z;
        do {
            len = readDouble(); c = readCharacter();
            nxtX = x - len;
            if (nxtX * x < 0) dis = Math.min (dis, y * y + z * z);
            else dis = Math.min (dis, nxtX * nxtX + y * y + z * z);
            x = nxtX;
            temp = x;
            if (c == 'L') {
                x = y;
                y = -temp;
            }
            else if (c == 'R') {
                x = -y;
                y = temp;
            }
            else if (c == 'U') {
                x = z;
                z = -temp;
            }
            else {
                x = -z;
                z = temp;
            }
        }
        while (c!='E');
        DecimalFormat df = new DecimalFormat("#0.00");
        System.out.println(df.format(Math.sqrt(dis)));
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
