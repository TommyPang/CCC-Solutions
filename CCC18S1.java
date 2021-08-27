import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * CCC '18 S1 - Voronoi Villages
 * Question type: Implementation
 * 15/15 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc18s1
 * @author Tommy Pang
 */
public class CCC18S1 {
    static StringTokenizer st;
    static int [] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        double min = 1e10;
        for (int i = 1; i < N-1; i++) {
            double size = (double) (arr[i] - arr[i-1])/2 + (double) (arr[i+1] - arr[i])/2;
            min = Math.min(size, min);
        }
        System.out.println(String.format("%.1f", min));
    }
}
