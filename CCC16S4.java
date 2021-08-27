import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * CCC '16 S4 - Combining Riceballs
 * Question type: Dynamic Programming
 * 15/15 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc16s4
 * @author Tommy Pang
 */
public class CCC16S4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int [] psa = new int[N+1];
        int ans = 0;
        boolean [][] dp = new boolean[N+1][N+1];
        for (int i = 1; i <= N; i++) {
           psa[i] = Integer.parseInt(st.nextToken());
           ans = Math.max(psa[i], ans);
           psa[i]+=psa[i-1]; dp[i][i] = true;
        }
        for (int len = 1; len < N; len++) {
            for (int l = 1; l+len <= N; l++) {
                int r = l+len;
                for (int p = l, q = r; p <= q;) {
                    int sumL = psa[p] - psa[l-1];
                    int sumR = psa[r] - psa[q-1];
                    if (sumL==sumR && p+1==q && dp[l][p] && dp[q][r]){
                        dp[l][r] = true;
                    }
                    else if (sumL==sumR && dp[l][p] && dp[q][r] && dp[p+1][q-1]){
                        dp[l][r] = true;
                    }
                    if (dp[l][r]){
                        ans = Math.max(ans, psa[r]-psa[l-1]);
                    }
                    if (sumL<sumR) p++;
                    else q--;
                }
            }
        }
        System.out.println(ans);
    }
}
