import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * CCC '08 S1 - It's Cold Here!
 * Question type: Implementation
 * 3/3 on DMOJ
 * @author Tommy Pang
 */
public class CCC08S1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int temperature = 201;
        String ans = "";
        while (true){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            String s2 = st.nextToken();
            if (s2.contains("-")) {
                int v = Integer.parseInt((s2.split("-"))[1]);
                if (-1 * v < temperature) {
                    temperature = -1 * v;
                    ans = s;
                }
            }
            if (s.equals("Waterloo")){
                System.out.println(ans);
                return;
            }
        }
    }
}
