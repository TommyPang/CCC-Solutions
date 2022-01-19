import java.io.*;
import java.util.*;

/**
 * CCC '03 S4 - Substrings
 * Question type: String Algorithms
 * 80/100 on DMOJ, TLE on case 6,8
 * Question URL: https://dmoj.ca/problem/ccc03s4
 * @author Tommy Pang
 */

public class CCC03S4_TrieSolution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7;
    public static void main(String[] args) throws IOException {
        int t = readInt();
        for (int i = 0; i < t; i++) {
            String s = readLine();
            System.out.println(distinctSubstringCount(s)+1);
        }
    }
    public static int distinctSubstringCount(String str){
        int cnt = 0;
        TrieNode root = new TrieNode();
        for (int i = 0; i < str.length(); i++){
            TrieNode temp = root;
            for (int j = i; j < str.length(); j++){
                char ch = str.charAt(j);
                if(temp.children[ch - '0'] == null){
                    temp.children[ch - '0'] = new TrieNode();
                    temp.isEnd = true;
                    cnt++;
                }
                temp = temp.children[ch - '0'];
            }
        }
        return cnt;
    }
    static class TrieNode {
        TrieNode children[];
        boolean isEnd;

        TrieNode(){
            this.children = new TrieNode[100];
            this.isEnd = false;
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
    // find first one grater, return list.size() if everything is smaller than or equal to v
    static int upperBound(List<Integer> list, int v) {
        int lo = 0, hi = list.size()-1;
        while (lo<=hi) {
            int mid = (lo+hi)/2;
            if (list.get(mid)>v) {
                hi = mid-1;
            }
            else lo = mid+1;
        }
        return lo;
    }
    // find first one smaller, return -1 if everything is greater then or equal to v
    static int lowerBound(List<Integer> list, int v) {
        int lo = 0, hi = list.size()-1;
        while (lo<=hi) {
            int mid = (lo+hi)/2;
            if (list.get(mid)>=v) {
                hi = mid-1;
            }
            else lo = mid+1;
        }
        return hi;
    }
}
