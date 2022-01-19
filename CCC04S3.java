import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * CCC '04 S3 - Spreadsheet
 * Question type: Graph Theory
 * 5/5 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc04s3
 * @author Tommy Pang
 */
public class CCC04S3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7;
    static String[][] grid = new String[10][10];
    static boolean[][] vis = new boolean[10][10];
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
            String [] cols = readLine().split(" ");
            for (int j = 1; j <= 9; j++) {
                grid[i][j] = cols[j-1];
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 1; j <= 9; j++) {
                vis = new boolean[10][10];
                dfs(i, j);
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int dfs(int r, int c) {
        if (isNumeric(grid[r][c])) return Integer.parseInt(grid[r][c]);
        if (vis[r][c] || grid[r][c].equals("*")) return -1;
        vis[r][c] = true;
        String [] depend = grid[r][c].split("\\+");
        int sum = 0;
        for (int i = 0; i < depend.length; i++) {
            int ret = dfs(depend[i].charAt(0)-'A', depend[i].charAt(1)-'0');
            if (ret==-1) {
                grid[r][c] = "*";
                return -1;
            }
            else sum+=ret;
        }
        grid[r][c] = String.valueOf(sum);
        return sum;
    }
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        }
        catch (NumberFormatException nfe) {
            return false;
        }
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
