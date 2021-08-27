import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
/**
 * CCC '18 S4 - Balanced Trees
 * Question URL: Dynamic Programming
 * 15/15 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc18s4
 * @author Tommy Pang
 */
public class CCC18S4 {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Map<Integer, Long> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        long W = Long.parseLong(br.readLine());
        map.put(1, 1L);
        System.out.println(fun(W));
    }
    static long fun(long i){
        if (map.containsKey((int) i)) return map.get((int) i);
        long ans = 0;
        for (int j = 2; j <= i;) {
            int w = (int) (i/j);
            int nxt = (int) (i/w) +1;
            ans += (nxt-j) * fun(w);
            // consider simple cases: N = 3 or N = 4
            j=nxt;
        }
        map.put((int) i, ans);
        return ans;
    }
}
