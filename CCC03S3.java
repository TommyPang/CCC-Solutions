import java.io.*;
import java.util.*;
/**
 * CCC '03 S3 - Floor Plan
 * Question type: Graph Theory
 * 100/100 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc03s3
 * @author Tommy Pang
 */

public class CCC03S3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int R, C, F, mod = (int) 1e9+7;
    static char[][] floor;
    static List<Integer> rooms = new ArrayList<>();
    static int [] dr = new int[] {0, 0, -1, 1}, dc = new int[] {-1, 1, 0, 0};
    static boolean [][] vis;
    public static void main(String[] args) throws IOException {
        F = readInt(); R = readInt(); C = readInt();
        floor = new char[R][C]; vis = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            floor[i] = readLine().toCharArray();
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (floor[i][j]=='.' && !vis[i][j]) {
                    rooms.add(BFS(i, j));
                }
            }
        }
        rooms.sort(Collections.reverseOrder());
        for (int i = 0; i < rooms.size(); i++) {
            if (F>=rooms.get(i)) {
                F-=rooms.get(i);
            }
            else {
                if (i==1) {
                    System.out.println(i + " room, " + F + " square metre(s) left over");
                }
                else System.out.println(i + " rooms, " + F + " square metre(s) left over");
                return;
            }
        }
        System.out.println(rooms.size() + " rooms, " + F + " square metre(s) left over");
    }
    public static int BFS(int r, int c) {
        int cnt = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        vis[r][c] = true;
        while (!queue.isEmpty()) {
            int [] cur = queue.poll();
            int i = cur[0], j = cur[1];
            for (int k = 0; k < 4; k++) {
                if (valid(i+dr[k], j+dc[k])) {
                    queue.add(new int[] {i+dr[k], j+dc[k]});
                    vis[i+dr[k]][j+dc[k]] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static boolean valid(int i, int j) {
        if (i<0 || i==R || j<0 || j==C || vis[i][j] || floor[i][j]=='I') return false;
        return true;
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
    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }
    static char readCharacter() throws IOException {
        return next().charAt(0);
    }
    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}
