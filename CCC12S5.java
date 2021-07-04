import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * CCC '12 S5 - Mouse Journey
 * Question type: Dynamic Programming
 * 60/70 on DMOJ, case 5 tle
 * Question URL: https://dmoj.ca/problem/ccc12s5
 * @author Tommy Pang
 */
public class CCC12S5 {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int [][] map;
    static int R, C;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R+1][C+1];
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.MAX_VALUE;
        }
        if (map[R][C]==Integer.MAX_VALUE) System.out.println(0);
        else {
            recursion(1, 1);
            System.out.println(map[R][C]);
        }
    }
    static void recursion(int r, int c){
        if (c+1<=C){
            if (c+1==C && r==R){
                map[r][c+1] += 1;
                return;
            }
            if (map[r][c+1]!=Integer.MAX_VALUE){
                if (map[r][c+1]!=0) map[r][c] += map[r][c+1];
                else {
                    recursion(r, c + 1);
                    map[r][c] += map[r][c+1];
                }
            }
        }
        if (r+1<=R){
            if (r+1==R && c==C){
                map[r+1][c] += 1;
                return;
            }
            if (map[r+1][c]!=Integer.MAX_VALUE){
                if (map[r+1][c]!=0) map[r][c] += map[r+1][c];
                else {
                    recursion(r + 1, c);
                    map[r][c] += map[r+1][c];
                }
            }
        }
    }
}
