import java.io.*;
import java.util.*;
/**
 * CCC '18 S3 - RoboThieves
 * Question URL: Graph Theory
 * 15/15 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc18s3
 * @author Tommy Pang
 */
public class CCC18S3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7, n, m, startR, startC;
    static boolean[][] camera;
    static boolean[][] robot;
    static boolean[][] convey;
    static Queue<int[]> queue;
    static char[][] grid;
    static int[][] dis;
    static List<int[]> cameras = new ArrayList<>();
    static List<int[]> exits = new ArrayList<>();
    static int[] dr = new int[] {0, 0, -1, 1}, dc = new int[] {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        n = readInt(); m = readInt();
        grid = new char[n][m]; convey = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (grid[i][j]=='S') {
                    startR = i; startC = j;
                }
                else if (grid[i][j]=='C') {
                    cameras.add(new int[] {i, j});
                }
                else if (grid[i][j]=='.') {
                    exits.add(new int[]{i, j});
                }
                else if (grid[i][j]!='W'){
                    convey[i][j] = true;
                }
            }
        }
        cameraBFS();
        robotBFS();
        for (int[] e : exits) {
            int ans = dis[e[0]][e[1]];
            System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
        }

    }
    public static void robotBFS() {
        queue = new LinkedList<>();
        queue.add(new int[]{ startR, startC });
        robot = new boolean[n][m];
        robot[startR][startC] = true;
        dis = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(dis[i], Integer.MAX_VALUE);
        dis[startR][startC] = 0;
        if (camera[startR][startC]) return;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row = cur[0], col = cur[1];
            int[] conveyed = conveyors(row, col);
            if (conveyed.length!=0) {
                if (valid(conveyed[0], conveyed[1], row, col, 0)) {
                    robot[conveyed[0]][conveyed[1]] = true;
                    dis[conveyed[0]][conveyed[1]] = dis[row][col];
                    queue.add(new int[] {conveyed[0], conveyed[1]});
                }
            }
            else {
                for (int i = 0; i < 4; i++) {
                    if (valid(row+dr[i], col+dc[i], row, col, 1)) {
                        robot[row+dr[i]][col+dc[i]] = true;
                        dis[row+dr[i]][col+dc[i]] = dis[row][col]+1;
                        queue.add(new int[] {row+dr[i], col+dc[i]});
                    }
                }
            }
        }
    }
    public static void cameraBFS() {
        queue = new LinkedList<>();
        camera = new boolean[n][m];
        for (int[] c : cameras) {
            for (int i = 0; i < 4; i++) {
                int tempR = c[0], tempC = c[1];
                while (grid[tempR][tempC]!='W') {
                    if (!convey[tempR][tempC]) camera[tempR][tempC] = true;
                    tempR+=dr[i]; tempC+=dc[i];
                }
            }
        }
    }
    public static boolean valid(int i, int j, int curi, int curj, int v) {
        return (!camera[i][j] && grid[i][j]!='W' && dis[i][j]>dis[curi][curj]+v);
    }
    public static int[] conveyors (int i, int j) {
        if (grid[i][j]=='U') {
            return new int[] {i-1, j};
        }
        else if (grid[i][j]=='D') {
            return new int[] {i+1, j};
        }
        else if (grid[i][j]=='L') {
            return new int[] {i, j-1};
        }
        else if (grid[i][j]=='R') {
            return new int[] {i, j+1};
        }
        return new int[0];
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
    static int readLongLineInt() throws IOException{
        int x = 0, c;
        while((c = br.read()) != ' ' && c != '\n')
            x = x * 10 + (c - '0');
        return x;
    }
    static long pow (long x, long exp){
        if (exp==0) return 1;
        long t = pow(x, exp/2);
        t = t*t %mod;
        if (exp%2 == 0) return t;
        return t*x%mod;
    }
    static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
    static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
