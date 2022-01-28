import java.io.*;
import java.util.*;
/**
 * CCC '13 S3 - Chances of Winning
 * Question type: Recursion
 * 80/80 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc13s3
 * @author Tommy Pang
 */
public class CCC13S3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7, T, G, ans = 0;
    static int[][] score = new int[5][5];
    static boolean[][] played = new boolean[5][5];
    public static void main(String[] args) throws IOException {
        T = readInt(); G = readInt();
        for (int i = 0; i < G; i++) {
            int a = readInt(), b = readInt(), sa = readInt(), sb = readInt();
            int point = sa==sb?1:3;
            score[a][b] = sa>=sb?point:0; score[b][a] = sb>=sa?point:0;
            played[a][b] = true; played[b][a] = true;
        }
        List<int[]> toPlay = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            for (int j = i+1; j <= 4; j++) {
                if (!played[i][j]) {
                    toPlay.add(new int[]{i, j});
                }
            }
        }
        winning(toPlay, 0);
        System.out.println(ans);
    }
    public static void winning(List<int[]> toPlay, int idx) {
        if (idx==toPlay.size()) {
            cnt();
            return;
        }
        int [] cur = toPlay.get(idx);
        // wins
        score[cur[0]][cur[1]] = 3;
        score[cur[1]][cur[0]] = 0;
        winning(toPlay, idx+1);
        // loses
        score[cur[0]][cur[1]] = 0;
        score[cur[1]][cur[0]] = 3;
        winning(toPlay, idx+1);
        // ties
        score[cur[0]][cur[1]] = 1;
        score[cur[1]][cur[0]] = 1;
        winning(toPlay, idx+1);
    }
    public static void cnt() {
        int fav_score = 0;
        for (int i = 1; i <= 4; i++) {
            fav_score+=score[T][i];
        }
        for (int i = 1; i <= 4; i++) {
            if (i==T) continue;
            int temp = 0;
            for (int j = 1; j <= 4; j++) {
                temp+=score[i][j];
            }
            if (temp>=fav_score) return;
        }
        ans++;
    }
    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong() throws IOException {
        return Long.parseLong(next());
    }
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
}

