import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * CCC '05 S2 - Mouse Move
 * Question type: Simple Math
 * 5/5 on DMOJ
 * @author Tommy Pang
 */
public class CCC05S2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int x_max = Integer.parseInt(st.nextToken());
        int y_max = Integer.parseInt(st.nextToken());
        int x = 0, y = 0;
        while (true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a==0 && b==0) return;
            if (x+a<0) x = 0;
            else if (x+a>x_max) x = x_max;
            else x += a;
            if (y+b<0) y = 0;
            else if (y+b>y_max) y = y_max;
            else y+=b;
            System.out.println(x+" "+y);
        }
    }
}
