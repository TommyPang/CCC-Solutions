import java.io.*;
import java.util.*;
/**
 * CCC '20 S2 - Escape Room
 * Question type: Graph Theory
 * 11/15 on DMOJ, TLE on Batch 6 and 7
 * Question URL: https://dmoj.ca/problem/ccc20s2
 * @author Tommy Pang
 */
public class CCC20S2 {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int [][] room;
    public static void main(String[] args) throws IOException {
        int r = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        room = new int[r+1][c+1];
        boolean [][] vis = new boolean[r+1][c+1];
        for (int i = 1; i <= r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= c; j++) {
                int v = Integer.parseInt(st.nextToken());
                room[i][j] = v;
            }
        }
        Queue<Integer> queue_row = new LinkedList<>();
        Queue<Integer> queue_col = new LinkedList<>();
        vis[1][1] = true;
        queue_row.add(1); queue_col.add(1);
        while (!queue_row.isEmpty()){
            int cr = queue_row.poll();
            int cc = queue_col.poll();
            int v = room[cr][cc];
            for (int i = 1; i <= v; i++) {
                try {
                    if (v%i==0 && !vis[i][v/i]){
                        queue_row.add(i);
                        queue_col.add(v/i);
                        vis[i][v/i] = true;
                    }
                }
                catch (ArrayIndexOutOfBoundsException e){
                }
            }
        }
        if (vis[r][c]) System.out.println("yes");
        else System.out.println("no");
    }
}
