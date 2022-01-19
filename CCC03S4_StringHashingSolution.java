import java.io.*;
import java.util.*;

/**
 * CCC '03 S4 - Substrings
 * Question type: String Algorithms
 * 70/100 on DMOJ, TLE on case 6,8,9
 * Question URL: https://dmoj.ca/problem/ccc03s4
 * @author Tommy Pang
 */

public class CCC03S4_StringHashingSolution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7;
    static long [] hsh, pw, hsh2, pw2;;
    public static void main(String[] args) throws IOException {
        int t = readInt();
        for (int i = 0; i < t; i++) {
            String s = readLine();

            int n = s.length(), base = 131, base2 = 137;
            hsh = new long[n+1]; pw = new long[n+1];
            hsh2 = new long[n+1]; pw2 = new long[n+1];
            pw[0] = 1; pw2[0] = 1;
            for (int j = 1; j <= n; j++) {
                hsh[j] = (hsh[j-1]*base + s.charAt(j-1))%mod;
                pw[j] = pw[j-1]*base%mod;
                hsh2[j] = (hsh2[j-1]*base2 + s.charAt(j-1))%mod;
                pw2[j] = pw2[j-1]*base2%mod;
            }
            Map<Long, String> map = new HashMap<>();
            Set<Long> set = new HashSet<>();
            for (int len = 1; len <= n; len++) {
                for (int l = 1; l+len-1 <= n; l++) {
                    long res = getSubstrHash(l-1, l+len-1);
                    //System.out.println(res);
                    //String cur = s.substring(l, l+len-1);
                    //if (map.containsKey(res)) System.out.println("Collision: " + map.get(res) + " with " + cur);
                    //else map.put(res, cur);
                    set.add(res);
                }
            }
            System.out.println(set.size()+1);
        }
    }
    static long getSubstrHash(int l, int r){
        long h1 = (hsh[r] - hsh[l] * pw[r-l] % mod + mod)%mod;
        long h2 = (hsh2[r] - hsh2[l] * pw2[r-l] % mod + mod)%mod;
        return (h1<<31) | h2;
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
