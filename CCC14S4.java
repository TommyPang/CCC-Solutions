import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * CCC '14 S4 - Tinted Glass Window
 * Question URL: Data Structures, Geometry
 * 70/150 on DMOJ, IR on Case 5-10 and 14-15
 * Question URL: https://dmoj.ca/problem/ccc14s4
 * @author Tommy Pang
 */
public class CCC14S4 {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int [][] factors = new int[2001][2001];
    static boolean [][] counted = new boolean[2001][2001];
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        long ans = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()), y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken()), y2 = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            for (int j = y1; j < y2; j++) {
                int length = 0;
                for (int k = x1+1; k <= x2; k++) {
                    if (!counted[j][k]){
                        if (factors[j][k]+v>=T){
                            length+=1;
                            counted[j][k] = true;
                        }
                        else {
                            factors[j][k]+=v;
                        }
                    }
                }
                ans+=length;
            }

        }
        System.out.println(ans);
    }
}
