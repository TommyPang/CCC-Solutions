import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * CCC '05 S2 - Mouse Move
 * Question type: Simple Math
 * 5/5 on DMOJ
 * @author Tommy Pang
 */
public class CCC05S3 {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
            int [][] first = new int[r][c];
            for (int j = 0; j < r; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < c; k++) {
                    first[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            r = Integer.parseInt(st.nextToken()); c = Integer.parseInt(st.nextToken());
            int [][] second = new int[r][c];
            for (int j = 0; j < r; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < c; k++) {
                    second[j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
    }
}
