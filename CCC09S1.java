import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
/**
 * CCC '09 S1 - Cool Numbers
 * Question type: Simple Math
 * 5/5 on DMOJ
 * @author Tommy Pang
 */
public class CCC09S1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int cnt = 0;
        long sqrt = (long) Math.sqrt(b);
        long cbrt = (long) Math.cbrt(b);
        for (long i = (long) Math.sqrt(a); i <= sqrt; i++) {
            for (long j = (long) Math.cbrt(a); j <= cbrt; j++) {
                if(i * i == j * j * j)
                    cnt+=1;
            }
        }
        System.out.println(cnt);
    }

}
