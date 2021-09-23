import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
/**
 * CCC '05 S5 - Pinball Ranking
 * Question type: Data Structures, Divide and Conquer
 * 15/15 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc05s5
 * @author Tommy Pang
 */
public class CCC05S5 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7;
    static int [] bit, arr; 
    public static void main(String[] args) throws IOException{
        int t = readInt(); bit = new int[100002];
        List<Integer> list;
        long tot = 0; arr = new int[100002];
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= t; i++) {
            int v = readInt();
            set.add(v);
            arr[i] = v;
        }
        list = new ArrayList<>(set);
        Collections.sort(list);
        for (int i = 1; i <= t; i++) {
            int p = Collections.binarySearch(list, arr[i])+1;
            update(p); tot+=(i-query(p)+1);
        }
        NumberFormat formatter = new DecimalFormat("#0.00");
        System.out.println(formatter.format((double) tot/t));
    }
    static void update(int idx) {
        for (int i = idx; i < bit.length; i+=(i&-i)) {
            bit[i]+=1;
        }
    }
    static int query(int idx) {
        int ret = 0;
        for (int i = idx; i > 0; i-=(i&-i)) {
            ret+=bit[i];
        }
        return ret;
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
}
