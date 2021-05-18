import java.util.*;
import java.io.*;
/**
 * CCC '01 S2 - Spirals
 * Question type: Implementation
 * 5/5 on DMOJ
 * @author  Tommy Pang
 */
public class CCC01S2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int [][] spiral;
    static int rCur, cCur, n, start, end;
    public static void main(String[] args) throws IOException{
        start = Integer.parseInt(br.readLine());
        end = Integer.parseInt(br.readLine());
        if (start == end) { System.out.println(start); return; }
        spiral = new int[10][10];
        rCur = cCur = 4;
        spiral[rCur][cCur] = start;
        int k =1; int cnt = start;
        downRight(k, cnt);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (spiral[i][j] == 0) System.out.print("   ");
                else System.out.print(spiral[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void downRight(int k, int cnt){
        for (int i = 0; i < k; i++) {
            rCur += 1; cnt+=1;
            spiral[rCur][cCur] = cnt;
            if (cnt==end) return;
        }
        for (int i = 0; i < k; i++) {
            cCur += 1; cnt+=1;
            spiral[rCur][cCur] = cnt;
            if (cnt==end) return;
        }
        upLeft(k+1, cnt);
    }
    static void upLeft(int k, int cnt){
        for (int i = 0; i < k; i++) {
            rCur -= 1; cnt+=1;
            spiral[rCur][cCur] = cnt;
            if (cnt==end) return;
        }
        for (int i = 0; i < k; i++) {
            cCur -= 1; cnt+=1;
            spiral[rCur][cCur] = cnt;
            if (cnt==end) return;
        }
        downRight(k+1, cnt);
    }
}
