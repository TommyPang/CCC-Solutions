import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * CCC '09 S5 - Wireless
 * Question type: Data Structures
 * 60/60 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc09s5
 * @author Tommy Pang
 */
public class CCC09S5 {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int M = Integer.parseInt(br.readLine()), N = Integer.parseInt(br.readLine()), K = Integer.parseInt(br.readLine());
        int [][] dif = new int[M+2][N+2];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            for (int j = Math.max(1, x-r); j <= Math.min(N, x+r); j++) {
                int d = (int) Math.sqrt(r*r-(x-j)*(x-j));
                dif[Math.max(1, y-d)][j] += b;
                dif[Math.min(M, y+d)+1][j] -= b;
            }
        }
        int ans = 0, cnt = 0;
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                dif[i][j] += dif[i-1][j];
                if (dif[i][j]>ans) {
                    ans = dif[i][j];
                    cnt=1;
                }
                else if (dif[i][j]==ans){
                    cnt++;
                }
            }
        }
        System.out.println(ans);
        System.out.println(cnt);
    }
}
