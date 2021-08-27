import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
/**
 * CCC '16 S2 - Tandem Bicycle
 * Question URL: Greedy Algorithms, Implementation
 * 15/15 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc16s2
 * @author Tommy Pang
 */
public class CCC16S2 {
    static StringTokenizer D, P;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int question = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        D = new StringTokenizer(br.readLine());
        P = new StringTokenizer(br.readLine());
        Integer [] d = new Integer[N], p = new Integer[N];
        for (int i = 0; i < N; i++) {
            d[i] = Integer.parseInt(D.nextToken());
            p[i] = Integer.parseInt(P.nextToken());
        }
        if (question==1) {
            Arrays.sort(d);
            Arrays.sort(p);
            int total = 0;
            for (int i = 0; i < N; i++) {
                total+=Math.max(d[i], p[i]);
            }
            System.out.println(total);
        }
        else {
            Arrays.sort(d, Collections.reverseOrder());
            Arrays.sort(p);
            int total = 0;
            for (int i = 0; i < N; i++) {
                total+=Math.max(d[i], p[i]);
            }
            System.out.println(total);
        }
    }
}
