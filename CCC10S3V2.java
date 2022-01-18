import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * CCC '10 S3 - Firehose
 * Question type: Data Structures, Implementation
 * 100/100 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc10s3
 * @author Tommy Pang
 */
public class CCC10S3V2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int H, k, mod = (int) 1e9+7;
    static int [] house;
    public static void main(String[] args) throws IOException {
        H = readInt(); house = new int[2*H];
        for (int i = 0; i < H; i++) {
            house[i] = readInt();
            house[i+H] = house[i]+1000000;
        }
        Arrays.sort(house);
        k = readInt();
        int lo = 0, hi = 1000000, ans = Integer.MAX_VALUE;
        // binary search for length
        while (lo<=hi) {
            int mid = (lo+hi)/2;
            if (check(mid)) {
                hi = mid-1;
                ans = mid;
            }
            else lo = mid+1;
        }
        System.out.println(ans);
    }
    static boolean check(int len) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < H; i++) {
            int up_bound = house[i]+2*len;
            int j, required = 1;
            for (j = i+1; j < i+H; j++) {
                if (house[j]>up_bound) {
                    required++;
                    up_bound = house[j]+2*len;
                }
            }
            min = Math.min(required, min);
        }
        return min<=k;
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
