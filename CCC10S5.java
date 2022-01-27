import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/**
 * CCC '10 S5 - Nutrient Tree
 * Question type: Dynamic Programming
 * 80/80 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc10s5
 * @author Tommy Pang
 */
public class CCC10S5 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7;
    public static void main(String[] args) throws IOException {
        String s = readLine(); int X = readInt();
        TreeNode root = buildTree(s);
        solve(root, X);
        System.out.println(root.dp[X]);
    }
    static void solve(TreeNode cur, int growth) {
        if (cur.l == null) {
            cur.dp = new int[growth+1];
            for (int i = 0; i <= growth; i++) {
                cur.dp[i] = cur.val + i;
            }
            return;
        }
        solve(cur.l, growth);
        // L[i] -> for the left tree, given i growth agents
        // what is the maximum amount of nutrients that can arrive at the current node
        int [] L = new int[growth+1];
        for (int i = 0; i <= growth; i++) {
            int max = 0;
            for (int j = 0; j <= i; j++) {
                int temp = Math.min((1+j)*(1+j), cur.l.dp[i-j]);
                if (temp>max) max = temp;
            }
            L[i] = max;
        }
        solve(cur.r, growth);
        int [] R = new int[growth+1];
        for (int i = 0; i <= growth; i++) {
            int max = 0;
            for (int j = 0; j <= i; j++) {
                int temp = Math.min((1+j)*(1+j), cur.r.dp[i-j]);
                if (temp>max) max = temp;
            }
            R[i] = max;
        }
        cur.dp = new int[growth+1];
        for (int i = 0; i <= growth; i++) {
            int max = 0;
            for (int j = 0; j <= i; j++) {
                int temp = L[j]+R[i-j];
                if (temp>max) max = temp;
            }
            cur.dp[i] = max;
        }

    }
    static TreeNode buildTree(String s) {
        s = s.trim(); // avoid any white space
        if (s.charAt(0)!='(') return new TreeNode(Integer.parseInt(s)); // create leaf node
        s = s.substring(1, s.length()-1).trim(); // get rid of otter brackets
        int idx = -1, l = -1; // l -> number of left bracket, idx is where the tree splits
        if (s.charAt(0)=='(') { // if start with left brackets then get the string for the whole subtree
            l = 1; idx = 1;
            while (l>0) {
                if (s.charAt(idx)=='(') l++;
                else if (s.charAt(idx)==')') l--;
                idx++;
            }
        }
        else {
            idx = s.indexOf(' ');
        }
        return new TreeNode(buildTree(s.substring(0, idx)), buildTree(s.substring(idx+1)));

    }

    static class TreeNode {
        int [] dp;
        TreeNode l, r;
        int val;
        TreeNode(int v) {
            val = v;
        }
        TreeNode(TreeNode left, TreeNode right) {
            l = left; r = right;
        }
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
