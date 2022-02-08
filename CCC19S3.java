import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/**
 * CCC '19 S3 - Arithmetic Square
 * Question type: Implementation
 * 11/16 on DMOJ, WA on Batch 4-6
 * Question URL: https://dmoj.ca/problem/ccc19s3
 * @author Tommy Pang
 */

public class CCC19S3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7;
    static int[][] grid = new int[3][3];
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 3; i++) {
            String[] lines = readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                grid[i][j] = lines[j].equals("X") ? Integer.MIN_VALUE : Integer.parseInt(lines[j]);
            }
        }
        solve();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean solve() {
        int[][] grid2 = copy();
        easyFill();
        if (done()) {
            return true;
        }
        loop:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j]!=Integer.MIN_VALUE) continue;
                for (int k = -30; k <= 30; k++) { // when input is [-10, 10], we have minimum of -30 and maximum of 30
                    grid[i][j] = k;
                    boolean res = solve();
                    if (res) return true;
                }
                break loop;
            }
        }
        grid = grid2;
        return false;
    }
    public static int[][] copy() {
        int[][] tmp = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tmp[i][j] = grid[i][j];
            }
        }
        return tmp;
    }

    public static void easyFill() {
        // fill rows
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == Integer.MIN_VALUE && grid[i][1] != Integer.MIN_VALUE && grid[i][2] != Integer.MIN_VALUE) {
                grid[i][0] = grid[i][1] - (grid[i][2] - grid[i][1]);
            }
            if (grid[i][1] == Integer.MIN_VALUE && grid[i][0] != Integer.MIN_VALUE && grid[i][2] != Integer.MIN_VALUE) {
                grid[i][1] = (grid[i][0] + grid[i][2]) / 2;
            }
            if (grid[i][2] == Integer.MIN_VALUE && grid[i][0] != Integer.MIN_VALUE && grid[i][1] != Integer.MIN_VALUE) {
                grid[i][2] = grid[i][1] + (grid[i][1] - grid[i][0]);
            }
        }
        // cols
        for (int i = 0; i < 3; i++) {
            if (grid[0][i] == Integer.MIN_VALUE && grid[1][i] != Integer.MIN_VALUE && grid[2][i] != Integer.MIN_VALUE) {
                grid[0][i] = grid[1][i] - (grid[2][i] - grid[1][i]);
            }
            if (grid[1][i] == Integer.MIN_VALUE && grid[0][i] != Integer.MIN_VALUE && grid[2][i] != Integer.MIN_VALUE) {
                grid[1][i] = (grid[0][i] + grid[2][i]) / 2;
            }
            if (grid[2][i] == Integer.MIN_VALUE && grid[0][i] != Integer.MIN_VALUE && grid[1][i] != Integer.MIN_VALUE) {
                grid[2][i] = grid[1][i] + (grid[1][i] - grid[0][i]);
            }
        }
    }
    public static boolean done() {
        int ret = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j]!=Integer.MIN_VALUE) ret++;
            }
        }
        if (ret<9) return false;
        if (grid[2][0]-grid[1][0]!=grid[1][0]-grid[0][0]) return false; // c1
        if (grid[2][1]-grid[1][1]!=grid[1][1]-grid[0][1]) return false; // c2
        if (grid[2][2]-grid[1][2]!=grid[1][2]-grid[0][2]) return false; // c3

        if (grid[0][2]-grid[0][1]!=grid[0][1]-grid[0][0]) return false; // r1
        if (grid[1][2]-grid[1][1]!=grid[1][1]-grid[1][0]) return false; // r2
        if (grid[2][2]-grid[2][1]!=grid[2][1]-grid[2][0]) return false; // r3
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
