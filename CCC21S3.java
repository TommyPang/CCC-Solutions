import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
/**
 * CCC '21 S3 - Lunch Concert
 * Question type: Data Structures
 * 15/15 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc21s3
 * @author Tommy Pang
 */
public class CCC21S3 {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static friend[] friends;
    public static void main(String[] args) throws IOException{
        int n = readInt();
        friends = new friend[n];
        long max = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            friends[i] = new friend(readLong(), readLong(), readLong());
            max = Math.max(friends[i].P, max); min = Math.min(friends[i].P, min);
        }
        int lo = (int) min, hi = (int) max;
        long ans = Long.MAX_VALUE;
        while (lo<=hi) {
            int mid = (lo+hi)/2;
            long centre = total(mid), l = total(mid-1), r = total(mid+1);
            ans = Math.min(centre, ans);
            if (l<=r) {
                hi = mid-1;
            }else {
                lo = mid+1;
            }
        }
        System.out.println(ans);

    }
    static long total(int v) {
        long ret = 0;
        for (int i = 0; i < friends.length; i++) {
            friend cur = friends[i];
            long dif = Math.abs(cur.P-v);
            if (dif<=cur.D) {
                continue;
            }
            ret += ((dif-cur.D)*cur.W);
        }
        return ret;
    }
    static class friend {
        long P, W, D;
        friend(long idx, long w, long d) { P = idx; W = w; D = d; }
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
    static int readALotInt() throws IOException{
        int x = 0, c;
        while((c = br.read()) != ' ' && c != '\n')
            x = x * 10 + (c - '0');
        return x;
    }

}
