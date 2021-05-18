import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * CCC '04 S5 - Super Plumber
 * Question type: Dynamic Programming
 * 5/5 on DMOJ
 * @author Tommy Pang, took idea from Milliken high school -> http://mmhs.ca/ccc/index.htm
 */
public class CCC04S5 {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String [][] grid;
    static int [][] coins;
    static int [][] dp;
    static int r, c;
    public static void main(String[] args) throws IOException {
        while (true){
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if (r==0 && c==0) return;
            grid = new String[r][c];
            coins = new int[r][c];
            dp = new int[r][c];
            for (int i = 0; i < r; i++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                for (int j = 0; j < c; j++) {
                    String symbol = String.valueOf(s.charAt(j));
                    if (!symbol.equals(".") && !symbol.equals("*")) {
                        coins[i][j] = Integer.parseInt(symbol);
                    }
                    grid[i][j] = symbol;
                }
            }
            solve();
        }
    }
    static void solve(){
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                dp[i][j] = -1;
            }
        }
        dp[r - 1][0] = coins[r - 1][0];
        for (int i = r - 2 ; i >= 0 ; i--)
        {
            if (!grid[i][0].equals("*")) {
                dp[i][0] = dp[i + 1][0] + coins[i][0];
            }
            else break;
        }

        for (int col = 1 ; col < c ; col++) {
            // going down from each square (0 to rows-1)
            for (int row = 0; row < r; row++) {
                if (!grid[row][col-1].equals("*") && dp[row][col-1]!=-1) // can't go right from a wall or a place that cannot be visited
                {
                    int t = dp[row][col - 1];
                    for (int k = row; k < r; k++) {
                        if (!grid[k][col].equals("*")) {
                            t = t + coins[k][col];
                            if (t > dp[k][col]) dp[k][col] = t;
                        } else break; // get out: hit a wall
                    }
                }
            }
            // going up from each square (rows-1 to 0)
            for (int row = r - 1; row >= 0; row--) {
                if (!grid[row][col-1].equals("*") && dp[row][col-1]!=-1) // can't go right from a wall or a place that cannot be visited
                {
                    int t = dp[row][col - 1];
                    for (int k = row; k >= 0; k--) {
                        if (!grid[k][col].equals("*")) {
                            t = t + coins[k][col];
                            if (t > dp[k][col]) dp[k][col] = t;
                        } else break; // get out: hit a wall
                    }
                }
            }
        }
        System.out.println(dp[r - 1][c - 1]);
    }
}
