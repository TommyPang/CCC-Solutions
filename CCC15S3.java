import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/**
 * CCC '15 S3 - Gates
 * Question Type: Data Structures
 * 15/15 on CCC, 30/30 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc15s3
 * @author Tommy Pang
 */
public class CCC15S3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7;

    public static void main(String[] args) throws IOException {
        int G = readInt(), N = readInt(), ans = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= G; i++) {
            list.add(i);
        }
        for (int i = 0; i < N; i++) {
            int P = readInt();
            int lo = 0, hi = list.size()-1, id = -1;
            while (lo<=hi) {
                int mid = (lo+hi)/2;
                int v = list.get(mid);
                if (v==P) {
                    id = mid;
                    break;
                }
                else if (v<P) {
                    id = mid;
                    lo = mid+1;
                }
                else hi = mid-1;
            }
            if (id!=-1) {
                ans++;
                list.remove(id);
            }
            else break;
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
