import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
/**
 * CCC '12 S3 - Absolutely Acidic
 * Question type: Implementation
 * 50/50 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc12s3
 * @author Tommy Pang
 */
public class CCC12S3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int [] frequency = new int[1001];
    static int cnt = 1;
    static List<Integer> highest = new ArrayList<>(), secondHighest = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int v = Integer.parseInt(br.readLine());
            frequency[v] += 1;
        }
        int max = 1;
        int fre = 0;
        for (int i : frequency) {
            max = Math.max(i, max);
        }
        for (int i : frequency) {
            if (i == max) {
                highest.add(cnt);
                fre+=1;
            }
            cnt+=1;
        }
        int ans = 0;
        if (fre>=2){
            for (int i : highest) {
                for (int j : highest) {
                    ans = Math.max(i-j, ans);
                }
            }
            System.out.println(ans);
            return;
        }
        int cnt = 1;
        int sec_max = 1;
        for (int i : frequency) {
            if (i == max) continue;
            sec_max = Math.max(i, sec_max);
        }
        for (int i : frequency) {
            if (i == sec_max) secondHighest.add(cnt);
            cnt+=1;
        }
        for (int i : highest) {
            for (int j : secondHighest) {
                ans = Math.max(Math.abs(i-j), ans);
            }
        }
        System.out.println(ans);
    }
}
