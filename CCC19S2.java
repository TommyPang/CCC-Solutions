import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * CCC '19 S2 - Pretty Average Primes
 * Question type: Simple Math
 * 15/15 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc19s2
 * @author Tommy Pang
 */
public class CCC19S2 {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean success = false;
    public static void main(String[] args) throws IOException {
        int cases = Integer.parseInt(br.readLine());
        for (int i = 0; i < cases; i++) {
            int N = Integer.parseInt(br.readLine());
            success = false;
            for (int j = 2; j < N; j++) {
                if (success) continue;
                if (Prime(j) && Prime(2*N-j)){
                    System.out.println(j + " " + (2*N-j));
                    success = true;
                }
            }
        }
    }
    static boolean Prime(int i){
        for (int j = 2; j < (int) Math.sqrt(i)+1; j++) {
            if (i%j==0) return false;
        }
        return true;
    }

}
