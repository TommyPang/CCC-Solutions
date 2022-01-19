import java.util.*;
import java.io.*;
/**
 * CCC '02 S3 - Blindfold
 * Question type: Simulation
 * 4/4 on CCC, 4/6 on DMOJ, Case 5, 6 TLE
 * @author  Tommy Pang
 */
public class CCC02S3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int R, C, mod = (int) 1e9 + 7;
    static char[][] grid;
    static List<Character> moves = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        R = readInt();
        C = readInt();
        grid = new char[R][C];
        for (int i = 0; i < R; i++) {
            grid[i] = readLine().toCharArray();
        }
        int v = readInt();
        for (int i = 0; i < v; i++) {
            moves.add(readCharacter());
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 'X') continue;
                Queue<state> queue = new LinkedList<>();
                queue.add(new state(i, j, 0, 'U'));
                queue.add(new state(i, j, 0, 'D'));
                queue.add(new state(i, j, 0, 'L'));
                queue.add(new state(i, j, 0, 'R'));
                while (!queue.isEmpty()) {
                    state cur = queue.poll();
                    if (cur.idx == v) {
                        grid[cur.r][cur.c] = '*';
                        continue;
                    }
                    char op = moves.get(cur.idx);
                    int nr, nc;
                    if (op == 'F') {
                        int[] temp = move(cur.r, cur.c, cur.dir);
                        nr = temp[0];
                        nc = temp[1];
                        if (valid(nr, nc)) {
                            queue.add(new state(nr, nc, cur.idx + 1, cur.dir));
                        }
                    } else {
                        char dir = turn(cur.dir, op);
                        queue.add(new state(cur.r, cur.c, cur.idx + 1, dir));
                    }
                }
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    public static char turn(char cur, char op) {
        if (op == 'L') {
            if (cur == 'U') return 'L';
            else if (cur == 'L') return 'D';
            else if (cur == 'D') return 'R';
            else if (cur == 'R') return 'U';
        } else {
            if (cur == 'U') return 'R';
            else if (cur == 'L') return 'U';
            else if (cur == 'D') return 'L';
            else if (cur == 'R') return 'D';
        }
        return '#';
    }

    public static int[] move(int i, int j, char c) {
        int[] res = new int[]{i, j};
        if (c == 'U') res[0]--;
        else if (c == 'L') res[1]--;
        else if (c == 'R') res[1]++;
        else if (c == 'D') res[0]++;
        return res;
    }

    public static class state {
        int r, c, idx;
        char dir;

        state(int i, int j, int id, char d) {
            r = i;
            c = j;
            idx = id;
            dir = d;
        }
    }

    public static boolean valid(int i, int j) {
        if (i < 0 || i == R || j < 0 || j == C) return false;
        else return grid[i][j] != 'X';
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
