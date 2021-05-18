import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * CCC '07 S5 - Bowling for Numbers
 * Question type: Dynamic Programming
 * 5/5 on DMOJ
 * @author Milliken high school -> http://mmhs.ca/ccc/index.htm
 */
public class CCC07S5 {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K, W, ans;
    static int [] balls;
    static int [] sum;
    static int [][] dp;
    public static void main(String[] args) throws IOException {
        int cases = Integer.parseInt(br.readLine());
        for (int i = 0; i < cases; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            dp = new int[K+1][N+1];
            balls = new int[N+1];
            sum = new int[N+1];
            for (int j = 1; j <= N; j++) {
                balls[j] = Integer.parseInt(br.readLine());
            }
            for (int j = 1; j <= N-W+1; j++) {
                for (int k = j; k < j+W; k++) {
                    sum[j]+=balls[k];
                }
            }
            solve();
            System.out.println(dp[K][1]);
        }
    }
    static void solve(){
        for (int i = 0; i < N+1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < K+1; i++) {
            for (int j = 1; j < N+1; j++) {
                dp[i][j] = -1;
            }
        }
        for (int i = 1; i <= K; i++) {
            for (int j = N; j >= 1; j--) {
                if (j>=N-W+1){
                    dp[i][j] = sum[j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j+W] + sum[j], dp[i][j+1]);
                }
            }
        }
    }
}
