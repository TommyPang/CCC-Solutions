import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * CCC '13 S2 - Bridge Transport
 * Question type: Simple Math
 * 130/130 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc13s2
 * @author Tommy Pang
 */
public class CCC13S2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int cnt = 0;
    public static void main(String[] args) throws IOException{
        int W = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int [] weights = new int[N+1];
        for (int i = 1; i <= N; i++) {
            weights[i] = Integer.parseInt(br.readLine());
        }
        boolean [] vis = new boolean[N+1];
        int total = 0;
        for (int i = 1; i <= N-4+1; i++) {
            for (int j = i; j < i+4; j++) {
                if (!vis[j]) {
                    total += weights[j];
                    if (total <= W) {
                        cnt += 1;
                        vis[j] = true;
                    }
                    else {
                        System.out.println(cnt);
                        return;
                    }
                }
            }
            total-=weights[i];
        }
        System.out.println(cnt);
    }
}
