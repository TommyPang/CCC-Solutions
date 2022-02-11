import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/**
 * CCC '21 S2 - Modern Art
 * Question type: Implementation
 * 15/15 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc21s2
 * @author Tommy Pang
 */
public class CCC21S2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7, m, n, k;
    static int[] row, col;
    public static void main(String[] args) throws IOException {
        m = readInt(); n = readInt(); k = readInt();
        row = new int[m+1]; col = new int[n+1];
        for (int i = 0; i < k; i++) {
            char c = readCharacter();
            int idx = readInt();
            if (c=='R') {
                row[idx]++;
            }
            else {
                col[idx]++;
            }
        }
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int painted = row[i]+col[j];
                if (painted%2==1) {
                    ans++;
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
}
