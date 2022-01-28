import java.io.*;
import java.util.*;
/**
 * CCC '14 S3 - The Geneva Confection
 * Question URL: Implementation
 * 500/500  on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc14s3
 * @author Tommy Pang
 */
public class CCC14S3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7, T, n;
    static Stack<Integer> stk;
    public static void main(String[] args) throws IOException {
        T = readInt();
        for (int i = 0; i < T; i++) {
            n = readInt();
            stk = new Stack<>();
            int cur = 1, idx = n-1;
            int [] line = new int[n];
            for (int j = 0; j < n; j++) {
                line[j] = readInt();
            }
            while (cur<=n && idx>=0) {
                if (line[idx]==cur) {
                    cur++;
                    idx--;
                }
                else if (!stk.isEmpty() && stk.peek()==cur) {
                    cur++; stk.pop();
                }
                else {
                    stk.push(line[idx]);
                    idx--;
                }

            }
            boolean can = true;
            for (int j = cur; j <= n; j++) {
                if (stk.peek()!=j) {
                    can = false;
                    break;
                }
                stk.pop();
            }
            System.out.println(can?"Y":"N");
        }
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

}
