import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * CCC '07 S1 - Federal Voting Age
 * Question type: Simple Math
 * 4/4 on DMOJ
 * @author Tommy Pang
 */
public class CCC07S1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if (2007-y > 18) System.out.println("Yes");
            else if (2007-y < 18) System.out.println("No");
            else {
                if (m<2) System.out.println("Yes");
                else if (m>2) System.out.println("No");
                else {
                    if (d==27) System.out.println("Yes");
                    else if (d<27) System.out.println("Yes");
                    else System.out.println("No");
                }
            }
        }
    }
}
