import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * CCC '17 S1 - Sum Game
 * Question URL: Implementation
 * 15/15 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc17s1
 * @author Tommy Pang
 */
public class CCC17S1 {
    static StringTokenizer st1, st2;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        int K = 0, Swifts = 0, Semaphores = 0;
        st1 = new StringTokenizer(br.readLine());
        st2 = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            Swifts += Integer.parseInt(st1.nextToken());
            Semaphores += Integer.parseInt(st2.nextToken());
            if (Swifts == Semaphores) K=i;
        }
        System.out.println(K);
    }
}
