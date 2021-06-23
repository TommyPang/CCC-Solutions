import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * CCC '11 S3 - Alice Through the Looking Glass
 * Question type: Recursion
 * 50/50 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc11s3
 * @author Tommy Pang
 */
public class CCC11S3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (solve(m, x, y)) System.out.println("crystal");
            else System.out.println("empty");
        }
    }
    static boolean solve(int m, int x, int y){
        int x0 = (int) (x / Math.pow(5, m - 1));
        int y0 = (int) (y / Math.pow(5, m - 1));
        if (x0==0) return false;
        if (x0 > 0 && x0 < 4 && y0 == 0) return true;
        if (x0 == 2 && y0 == 1) return true;
        if (((x0==1||x0==3)&&y0==1) || (x0==2&&y0==2))
            return solve(m - 1, x % (int) Math.pow(5, m - 1), y % (int) Math.pow(5, m - 1));
        return false;
    }
}
