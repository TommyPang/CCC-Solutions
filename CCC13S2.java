import java.io.*;
import java.util.StringTokenizer;
/**
 * CCC '13 S2 - Bridge Transport
 * Question type: Simple Math
 * 130/130 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc13s2
 * @author Tommy Pang
 */
public class CCC13S2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7, T, n;
    public static void main(String[] args) throws IOException {
        T = readInt(); n = readInt();
        int [] cars = new int[n];
        for (int i = 0; i < n; i++) {
            cars[i] = readInt();
        }
        int sum = 0;
        for (int i = 0; i < Math.min(4, n); i++) {
            sum+=cars[i];
            if (sum>T) {
                System.out.println(i);
                return;
            }
        }
        for (int i = 4; i < n; i++) {
            sum-=cars[i-4];
            sum+=cars[i];
            if (sum>T) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(n);
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

}
