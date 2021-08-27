import java.io.*;
import java.util.*;
/**
 * CCC '20 S3 - Searching for Strings
 * Question type: Data Structures, String Algorithms
 * 20/20 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc20s3
 * @author Tommy Pang
 */
public class CCC20S3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static long [] hsh, hsh2, pw, pw2;
    static int mod = (int) 1e9 + 7;
    public static void main(String[] args) throws IOException{
        String N = readLine(), H = readLine();
        int n = N.length(); int m = H.length();
        hsh = new long[m+1]; hsh2 = new long[m+1];
        pw = new long[m+1]; pw2 = new long[m+1];
        hsh[0] = 0; hsh2[0] = 0;
        pw[0] = 1; pw2[0] = 1;
        int base = 131, base2 = 137;
        int [] freq = new int[26], freq2 = new int[26];
        for (int i = 0; i < n; i++) {
            freq[N.charAt(i)-'a']++;
        }
        for (int i = 1; i <= m; i++) {
            hsh[i] = (hsh[i-1]*base + H.charAt(i-1))%mod;
            pw[i] = pw[i-1]*base % mod;
            hsh2[i] = (hsh2[i-1]*base2 + H.charAt(i-1))%mod;
            pw2[i] = pw2[i-1]*base2 % mod;
        }
        Set<Long> set = new HashSet<>();
        for (int i = 1; i <= m; i++) {
            freq2[H.charAt(i-1)-'a'] ++;
            if (i>n) freq2[H.charAt(i-n-1)-'a']--;
            if (Arrays.equals(freq, freq2)) {
                set.add(getSubstrHash(i - n - 1, i));
            }
        }
        System.out.println(set.size());
    }
    static long getSubstrHash(int l, int r){
        long h1 = (hsh[r] - hsh[l+1] * pw[r-l-1] % mod + mod)%mod, h2 = (hsh2[r] - hsh2[l+1] * pw2[r-l-1] % mod + mod)%mod;
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
