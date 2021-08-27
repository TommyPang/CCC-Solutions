import java.io.*;
import java.util.*;
/**
 * CCC '20 S4 - Swapping Seats
 * Question type: Greedy Algorithms
 * 8/15 on DMOJ, WA on Batch 3 and 4
 * Question URL: https://dmoj.ca/problem/ccc20s4
 * @author Tommy Pang
 */
public class CCC20S4 {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int a_num, b_num, c_num;

    public static void main(String[] args) throws IOException {
        // Only Works if there's no C character
        String seats = br.readLine();
        int [] preSumB = new int[seats.length()+1];
        for (int i = 1; i <= seats.length(); i++) {
            if (seats.charAt(i-1)=='B') preSumB[i] = preSumB[i-1]+1;
            else preSumB[i] = preSumB[i-1];
            if (seats.charAt(i-1)=='A') a_num+=1;
        }
        int ans = 1000000;
        for (int i = 0; i <= seats.length()-a_num; i++) {
            int cnt = preSumB[a_num+i]-preSumB[i];
            ans = Math.min(ans, cnt);
        }
        for (int i = seats.length()-a_num+1; i < seats.length(); i++) {
            int cnt = preSumB[seats.length()] + preSumB[a_num-(seats.length()-i)] - preSumB[i];
            ans = Math.min(ans, cnt);
        }
        System.out.println(ans);
    }
}
