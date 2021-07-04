import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * CCC '12 S1 - Don't pass me the ball!
 * Question type: Simple Math
 * 50/50 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc12s1
 * @author Tommy Pang
 */
public class CCC12S1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        int total = 0;
        if (N<4) {
            System.out.println(0);
            return;
        }
        else {
            int pre = 1;
            for (int i = 2; i < N-4+2; i++) {
                pre = pre+i;
                total+=pre;
            }
            total+=1;
            System.out.println(total);
        }
    }
}
