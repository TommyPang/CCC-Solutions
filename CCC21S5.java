import java.io.*;
import java.util.*;
import java.util.StringTokenizer;
/**
 * CCC '21 S5 - Math Homework
 * Question type: Data Structures, Intermediate Math
 * 15/15 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc21s5
 * @author Tommy Pang
 */
public class CCC21S5 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7;
    static int [] segTree;
    public static void main(String[] args) throws IOException{
        int n = readInt(), m = readInt();
        int height = (int) Math.ceil(Math.log(n)/Math.log(2))+1;
        int size = (int) pow(2, height)-1; segTree = new int[size+1];
        int [] x = new int[m], y = new int[m], z = new int[m]; int [][] dif = new int[17][n+5];
        for (int i = 0; i < m; i++) {
            x[i] = readInt(); y[i] = readInt(); z[i] = readInt();
            dif[z[i]][x[i]]++; dif[z[i]][y[i]+1]--;
        }
        int [] res = new int[n+1];
        Arrays.fill(res, 1);
        for (int i = 1; i <= 16; i++) {
            for (int j = 1; j <= n; j++) {
                dif[i][j] += dif[i][j-1];
                if (dif[i][j]>0) {
                    // i is a divisor
                    res[j] = res[j]*i/gcd(res[j], i);
                }
            }
        }
        construct(1, n, 1, res);
        for (int i = 0; i < m; i++) {
            if (query(x[i], y[i], 1, n, 1)!=z[i]) {
                System.out.println("Impossible");
                return;
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(res[i] + " ");
        }

    }
    static int query(int qs, int qe, int s, int e, int idx) {
        if (qe<s || qs>e) return 0;
        if (qs<=s && qe>=e) return segTree[idx];
        int mid = (s+e)/2;
        return gcd(query(qs, qe, s, mid, 2*idx), query(qs, qe, mid+1, e, 2*idx+1));
    }
    static int construct(int s, int e, int idx, int [] arr) {
        if (s==e) {
            segTree[idx] = arr[s];
            return segTree[idx];
        }
        int mid = (s+e)/2;
        int v1 = construct(s, mid, 2*idx, arr), v2 = construct(mid+1, e, 2*idx+1, arr);
        segTree[idx] = gcd(v1, v2);
        return segTree[idx];
    }
    static int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
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
}