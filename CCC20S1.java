import java.io.*;
import java.util.*;
/**
 * CCC '20 S1 - Surmising a Sprinter's Speed
 * Question type: Implementation
 * 15/15 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc20s1
 * @author Tommy Pang
 */
public class CCC20S1 {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long [] time, dis;
    static double ans = 0;
    public static void main(String[] args) throws IOException {
        Map<Long, Long> map = new HashMap<>();
        int cases = Integer.parseInt(br.readLine());
        time = new long[cases]; dis = new long[cases];
        for (int i = 0; i < cases; i++) {
            st = new StringTokenizer(br.readLine());
            long t = Long.parseLong(st.nextToken());
            long d = Long.parseLong(st.nextToken());
            time[i] = t;
            dis[i] = d;
            map.put(t, d);
        }
        Arrays.sort(time);
        long pre_time = -1, pre_dis = -1;
        for (int i = 0; i < cases; i++) {
            if (pre_time==-1) {
                pre_time = time[i];
                pre_dis = map.get(pre_time);
            }
            else {
               double res = Math.abs((double) map.get(time[i]) - pre_dis)/Math.abs((double) time[i] - pre_time);
               ans = Math.max(res, ans);
               pre_dis = map.get(time[i]); pre_time = time[i];
            }
        }
        System.out.println(ans);
    }
}
