import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
/**
 * CCC '14 S1 - Party Invitation
 * Question URL: Implementation
 * 500/500  on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc14s2
 * @author Tommy Pang
 */
public class CCC14S2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st1, st2;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Map<String, String> map = new HashMap<>();
        st1 = new StringTokenizer(br.readLine());
        st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            String a = st1.nextToken();
            String b = st2.nextToken();
            if (a.equals(b)){
                System.out.println("bad");
                return;
            }
            if (!map.containsKey(a) && !map.containsKey(b)) {
                map.put(a, b);
                map.put(b, a);
            }
            else {
                if (map.containsKey(a)) {
                    if (!map.get(a).equals(b)) {
                        System.out.println("bad");
                        return;
                    }
                }
                else {
                    if (!map.get(b).equals(a)) {
                        System.out.println("bad");
                        return;
                    }
                }
            }
        }
        System.out.println("good");
    }
}
