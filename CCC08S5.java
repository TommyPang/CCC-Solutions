import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * CCC '08 S5 - Nukit
 * Question type: Dynamic Programming, Game Theory
 * 7/7 on DMOJ
 * @author Tommy Pang, idea taken from http://mmhs.ca/ccc/index.htm
 */
public class CCC08S5 {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String [] dp;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());
            dp = new String[1000000];
            Arrays.fill(dp, "?");
            if (winning(a, b, c, d)) System.out.println("Patrick");
            else System.out.println("Roland");
        }
    }
    static boolean winning(int A, int B, int C, int D){
        int x = 27000*A+900*B+30*C+D;
        if (!dp[x].equals("?")) return dp[x].equals("w");
        // 1
        if (A-2>=0 && B-1>=0 && D-2>=0 && losing(A-2, B-1, C, D-2)) {
            dp[x] = "w";
            return true;
        }
        //2
        if (A-1>=0 && B-1>=0 && C-1>=0 && D-1>=0 && losing(A-1, B-1, C-1, D-1)) {
            dp[x] = "w";
            return true;
        }
        //3
        if (C-2>=0 && D-1>=0 && losing(A, B, C-2, D-1)) {
            dp[x] = "w";
            return true;
        }
        //4
        if (B-3>=0 && losing(A, B-3, C, D)) {
            dp[x] = "w";
            return true;
        }
        //5
        if (A-1>=0 && D-1>=0 && losing(A-1, B, C, D-1)) {
            dp[x] = "w";
            return true;
        }
        dp[x] = "l";
        return false;
    }
    static boolean losing(int A, int B, int C, int D){
        int x = 27000*A+900*B+30*C+D;
        if (!dp[x].equals("?")) return dp[x].equals("l");
        if (!canMove(A, B, C, D)) {
            dp[x] = "l";
            return true;
        }
        else {
            boolean temp = true;
            if (A-2>=0 && B-1>=0 && D-2>=0) temp = temp&&winning(A-2, B-1, C, D-2);
            if (A-1>=0 && B-1>=0 && C-1>=0 && D-1>=0) temp = temp&&winning(A-1, B-1, C-1, D-1);
            if (C-2>=0 && D-1>=0) temp = temp&&winning(A, B, C-2, D-1);
            if (B-3>=0) temp = temp&&winning(A, B-3, C, D);
            if (A-1>=0 && D-1>=0) temp = temp&&winning(A-1, B, C, D-1);
            if (temp){
                dp[x] = "l";
                return true;
            }
            else {
                dp[x] = "w";
                return false;
            }
        }
    }
    static boolean canMove(int A, int B, int C, int D){
        if (A-2>=0 && B-1>=0 && D-2>=0) return true;
        if (A-1>=0 && B-1>=0 && C-1>=0 && D-1>=0) return true;
        if (C-2>=0 && D-1>=0) return true;
        if (B-3>=0) return true;
        if (A-1>=0 && D-1>=0) return true;
        return false;
    }
}
