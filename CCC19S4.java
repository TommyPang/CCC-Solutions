import java.io.*;

import java.util.List;
import java.util.StringTokenizer;
/**
 * CCC '19 S4 - Tourism
 * Question type: Implementation
 * 30/30 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc19s4
 * @author Tommy Pang
 */
public class CCC19S4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7;
    public static void main(String[] args) throws IOException {
        int N = readInt(), K = readInt(), MM = (int)1e6+3;
        int[] a= new int[MM], pmx = new int[MM], day = new int[MM];
        for (int i = 1; i <= N; i++) {
            a[i] = readInt();
            day[i] = (i+K-1)/K;
        }
        long[] dp = new long[MM], dp1 = new long[MM], dp2 = new long[MM];
        for (int i = 1; i <= K; i++) {
            dp[i] = pmx[i] = Math.max(pmx[i-1],  a[i]);
        }
        for (int i = K+1; i <= N; i+=K) {
            int smx = 0;
            for (int j = (day[i]-1)*K; j > (day[i]-2)*K; j--) {
                dp1[j] = Math.max(dp1[j+1], dp[j]);
                dp2[j] = Math.max(dp2[j+1], dp[j] + smx);
                smx = Math.max(smx, a[j]);
            }
            for (int j = i; j <= Math.min(i+K, N); j++) {
                if(day[j] == day[j-1]) pmx[j] = Math.max(pmx[j-1], a[j]);
                else pmx[j] = a[j];
                dp[j] = Math.max(dp1[j-K] + pmx[j],  dp2[j-K]);
            }
        }
        System.out.println(dp[N]);
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
    // find first one grater, return list.size() if everything is smaller than or equal to v
    static int upperBound(List<Integer> list, int v) {
        int lo = 0, hi = list.size()-1;
        while (lo<=hi) {
            int mid = (lo+hi)/2;
            if (list.get(mid)>v) {
                hi = mid-1;
            }
            else lo = mid+1;
        }
        return lo;
    }
    // find first one smaller, return -1 if everything is greater then or equal to v
    static int lowerBound(List<Integer> list, int v) {
        int lo = 0, hi = list.size()-1;
        while (lo<=hi) {
            int mid = (lo+hi)/2;
            if (list.get(mid)>=v) {
                hi = mid-1;
            }
            else lo = mid+1;
        }
        return hi;
    }

}
