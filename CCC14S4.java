import java.io.*;
import java.util.*;

/**
 * CCC '14 S4 - Tinted Glass Window
 * Question URL: Data Structures, Geometry
 * 150/150 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc14s4
 * @author Tommy Pang
 */
public class CCC14S4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7, n, T, x1, y1, x2, y2, v;
    static long ans = 0;
    static long[][] dif;
    static Map<Integer, Integer> xs = new TreeMap<>();
    static Map<Integer, Integer> ys = new TreeMap<>();
    static Set<Integer> distinctX = new TreeSet<>();
    static Set<Integer> distinctY = new TreeSet<>();
    static int[][] pair;
    static int[] trueX, trueY;
    public static void main(String[] args) throws IOException {
        n = readInt(); T = readInt();
        pair = new int[n][5]; trueX = new int[2*n+1]; trueY = new int[2*n+1];
        for (int i = 0; i < n; i++) {
            x1 = readInt(); y1 = readInt(); x2 = readInt(); y2 = readInt(); v = readInt();
            pair[i] = new int[] {x1, y1, x2, y2, v};
            distinctX.add(x1); distinctX.add(x2); distinctY.add(y1); distinctY.add(y2);
        }
        dif = new long[2*distinctX.size()+2][2*distinctY.size()+2];
        int idx = 0; for (int nxt : distinctX) { xs.put(nxt, ++idx); trueX[idx] = nxt; }
        idx = 0; for (int nxt : distinctY) { ys.put(nxt, ++idx); trueY[idx] = nxt; }
        for (int[] nxt : pair) {
            dif[xs.get(nxt[0])][ys.get(nxt[1])]+=nxt[4];
            dif[xs.get(nxt[2])][ys.get(nxt[3])]+=nxt[4];
            dif[xs.get(nxt[0])][ys.get(nxt[3])]-=nxt[4];
            dif[xs.get(nxt[2])][ys.get(nxt[1])]-=nxt[4];
        }
        for (int i = 1; i < distinctX.size(); i++) {
            for (int j = 1; j < distinctY.size(); j++) {
                dif[i][j] += dif[i-1][j] + dif[i][j-1] - dif[i-1][j-1];
                if (dif[i][j]>=T) {
                    long x = trueX[i+1]-trueX[i], y = trueY[j+1]-trueY[j];
                    ans += x*y;
                }
            }
        }
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
