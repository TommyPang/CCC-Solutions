import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/**
 * CCC '08 S4 - Twenty-four
 * Question type: Graph Theory
 * 5/5 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc08s4
 * @author Tommy Pang
 */
public class CCC08S4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7, T, largest;
    static List<Integer> cards;
    public static void main(String[] args) throws IOException {
        T = readInt();
        for (int i = 0; i < T; i++) {
            cards = new ArrayList<>();
            largest = 0;
            for (int j = 0; j < 4; j++) {
                cards.add(readInt());
            }
            recursion(cards);
            System.out.println(largest);
        }
    }
    public static void recursion(List<Integer> list) {
        if (list.size()==1) {
            if (list.get(0)<=24) largest = Math.max(largest, list.get(0));
            return;
        }
        List<Integer> nxt = new ArrayList<>(list);
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if (i==j) continue;
                int v1 = list.get(i), v2 = list.get(j);
                // addition
                list.remove(i); list.remove(j-1);
                list.add(v1+v2);
                recursion(list);
                list = new ArrayList<>(nxt);
                // subtraction 1
                list.remove(i); list.remove(j-1);
                list.add(v1-v2);
                recursion(list);
                list = new ArrayList<>(nxt);
                // subtraction 2
                list.remove(i); list.remove(j-1);
                list.add(v2-v1);
                recursion(list);
                list = new ArrayList<>(nxt);
                // multiplication
                list.remove(i); list.remove(j-1);
                list.add(v1*v2);
                recursion(list);
                list = new ArrayList<>(nxt);
                // division
                if (v2!=0 && v1%v2==0) {
                    list.remove(i); list.remove(j-1);
                    list.add(v1/v2);
                    recursion(list);
                    list = new ArrayList<>(nxt);
                }
                else if (v1!=0 && v2%v1==0) {
                    list.remove(i); list.remove(j-1);
                    list.add(v2/v1);
                    recursion(list);
                    list = new ArrayList<>(nxt);
                }
            }
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
