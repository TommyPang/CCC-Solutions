import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * CCC '00 S4 - Golf
 * Question type: Dynamic Programming
 * 6/6 on DMOJ
 * @author  Tommy Pang
 */
public class CCC00S4 {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int dis = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int [] clubs = new int[N+1];
        int [] dp = new int[dis+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 1; i <= N; i++) {
            clubs[i] = Integer.parseInt(br.readLine());
            dp[clubs[i]] = 1;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= dis; j++) {
                if (!(j-clubs[i]<0) && dp[j-clubs[i]] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j], dp[j-clubs[i]] + 1);
                }
            }
        }
        if (dp[dis] == Integer.MAX_VALUE) System.out.println("Roberta acknowledges defeat.");
        else System.out.println("Roberta wins in " + dp[dis] + " strokes.");
    }
}