import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * CCC '13 S1 - From 1987 to 2013
 * Question type: Implementation
 * 150/150 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc13s1
 * @author Tommy Pang
 */
public class CCC13S1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        while (true){
            N++;
            int [] count = new int[10];
            boolean isAns = true;
            String s = String.valueOf(N);
            for (int i = 0; i < s.length(); i++) {
                count[Integer.parseInt(String.valueOf(s.charAt(i)))] += 1;
            }
            for (int nxt : count) {
                if (!(nxt==1 || nxt == 0)) {
                    isAns = false;
                    break;
                }
            }
            if (isAns) {
                System.out.println(s);
                return;
            }
        }
    }
}
