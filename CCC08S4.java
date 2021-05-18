import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * CCC '08 S4 - Twenty-four
 * Question type: Graph Theory
 * 3/5 on DMOJ, case 1, 3 WA
 * @author Tommy Pang
 */
public class CCC08S4 {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int max;
    static int [] numbers;
    static boolean [] vis;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            max = -1;
            numbers = new int[4]; vis = new boolean[4];
            for (int j = 0; j < 4; j++) {
                numbers[j] = Integer.parseInt(br.readLine());
            }
            for (int j = 0; j < 4; j++) {
                vis[j] = true;
                recursion(numbers[j], 1);
                vis = new boolean[4];
            }
            System.out.println(max);
        }
    }
    static void recursion(int num, int used){
        if (used==4) {
            if (num<=24) {
                max = Math.max(num, max);
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (vis[i]) continue;
            for (int j = 0; j < 4; j++) {
                switch (j){
                    case 0:
                        vis[i] = true;
                        recursion(num+numbers[i], used+1);
                        vis[i] = false;
                        break;
                    case 1:
                        vis[i] = true;
                        recursion(num-numbers[i], used+1);
                        vis[i] = false;
                        break;
                    case 2:
                        vis[i] = true;
                        recursion(num*numbers[i], used+1);
                        vis[i] = false;
                        break;
                    case 3:
                        if (num%numbers[i]==0){
                            vis[i] = true;
                            recursion(num/numbers[i], used+1);
                            vis[i] = false;
                        }
                        break;
                }
            }
        }
    }
}
