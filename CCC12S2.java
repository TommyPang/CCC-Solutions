import java.io.*;
import java.util.*;
/**
 * CCC '12 S2 - Aromatic Numbers
 * Question type: Simple Math
 * 50/50 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc12s2
 * @author Tommy Pang
 */
public class CCC12S2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7;
    static Map<Character, Integer> map = new HashMap<>();
    static int[] A;
    static char[] R;
    public static void main(String[] args) throws IOException {
        map.put('I', 1); map.put('V', 5); map.put('X', 10); map.put('L', 50);
        map.put('C', 100); map.put('D', 500); map.put('M', 1000);
        String s = readLine();
        A = new int[s.length()/2];
        R = new char[s.length()/2];
        for (int i = 0; i < s.length(); i+=2) {
            A[i/2] = s.charAt(i)-'0';
            R[i/2] = s.charAt(i+1);
        }
        int ans = 0;
        for (int i = 0; i < s.length()/2; i++) {
            int v = A[i]*map.get(R[i]);
            if (add(i+1, map.get(R[i]))) {
                ans+=v;
            }
            else ans-=v;
        }
        System.out.println(ans);
    }
    public static boolean add(int i, int v) {
        if (i>=R.length) return true;
        return v>=map.get(R[i]);
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
