import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer> rs = new ArrayList<>(), cs = new ArrayList<>();
    static boolean [] r, c;
    public static void main(String[] args) throws IOException {
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        r = new boolean[M+1]; c = new boolean[N+1];
        int K = Integer.parseInt(br.readLine());
        int ans = 0;
        int rs_size = 0, cs_size = 0;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            String o = st.nextToken();
            int v = Integer.parseInt(st.nextToken());
            if (o.equals("R")){
                if (!r[v]) {
                    r[v] = true;
                    rs_size+=1;
                }
                else {
                    rs_size -= 1;
                    r[v] = false;
                }
            }
            else {
                if (!c[v]) {
                    c[v] = true;
                    cs_size+=1;
                }
                else {
                    cs_size -= 1;
                    c[v] = false;
                }
            }
        }
        ans+=(rs_size*N);
        ans-=(cs_size*rs_size);
        ans+=((M-rs_size)*cs_size);
        System.out.println(ans);
    }
}