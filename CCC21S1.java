import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.*;
/**
 * CCC '21 S1 - Crazy Fencing
 * Question type: Simple Math
 * 15/15 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc21s1
 * @author Tommy Pang
 */
public class CCC21S1 {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int [] heights;
    static int [] width;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        heights = new int[N+1]; width = new int[N];
        for (int i = 0; i < N+1; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            width[i] = Integer.parseInt(st.nextToken());
        }
        double ans = 0;
        DecimalFormat format = new DecimalFormat("0.#");
        for (int i = 0; i < N; i++) {
            double v =(double)((heights[i]+heights[i+1])*width[i])/2;
            ans+=v;
        }
        System.out.println(format.format(ans));
    }
}
