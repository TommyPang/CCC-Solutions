import java.util.*;
import java.io.*;
/**
 * CCC '05 S4 - Pyramid Message Scheme
 * Question type: Graph Theory
 * 1/1 on DMOJ
 * @author Tommy Pang
 */
public class CCC05S4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int old_sum = N*10;
            String s[] = new String[N];
            for(int nxt=0; nxt<N; nxt++) {
                s[nxt] = br.readLine();
            }
            Map<String, Integer> mp = new HashMap<>();
            int cur = 0, dep = 0;
            mp.put(s[N-1], 0);
            for (int j = 0; j < N; j++) {
                if (!mp.containsKey(s[j])) {
                    cur +=1;
                    mp.put(s[j], cur); dep = Math.max(dep, cur);
                }
                else {
                    cur = mp.get(s[j]);
                }
            }
            System.out.println(old_sum - dep*20);
        }
    }
}
