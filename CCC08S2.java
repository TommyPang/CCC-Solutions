import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * CCC '08 S2 - Pennies in the Ring
 * Question type: Geometry
 * 3/3 on DMOJ
 * @author Tommy Pang
 */
public class CCC08S2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        while (true){
            int r = Integer.parseInt(br.readLine());
            if (r==0) break;
            int cnt = 0;
            for (int i = 0; i <= r; i++) {
                cnt += (int) Math.sqrt(r*r-i*i);
            }
            System.out.println(cnt*4+1);
        }
    }

}
