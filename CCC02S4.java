import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * CCC '02 S4 - Bridge Crossing
 * Question type: Dynamic Programming
 * 5/5 on DMOJ
 * @author Milliken high school -> http://mmhs.ca/ccc/index.htm
 */
public class CCC02S4 {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        String [] name = new String[N];
        int [] time = new int[N];
        for (int i = 0; i < N; i++) {
            name[i] = br.readLine();
            time[i] = Integer.parseInt(br.readLine());
        }
        int [] best = new int[N+1];
        int [] group = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            best[i] = 1000000;
            group[i] = -1;
        }
        best[0] = 0;
        group[0] = 0;
        for (int i = 0; i < N+1; i++) {
            int cur = 0;
            for (int j = 1; j <= M && i+j - 1 < N; j++) {
                cur = Math.max(cur, time[i + j - 1]);
                if (best [i] + cur < best [i + j]) {
                    best [i + j] = best [i] + cur;
                    group [i + j] = j;
                }
            }
        }
        System.out.println("Total Time: " + best [N]);
        int [] lines = new int [N + 1];
        int k = N;
        int x = 0;
        while (group [k] != 0) {
            lines [x++] = group [k];
            k = k - group [k];
        }
        int z = 0;
        for (int i = x - 1 ; i >= 0 ; i--) {
            for (int j = 0 ; j < lines [i] ; j++) {
                System.out.print(name[z++] + " ");
            }
            System.out.println();
        }

    }
}
