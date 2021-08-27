import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * CCC '17 S2 - High Tide, Low Tide
 * Question type: Implementation
 * 10/15 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc17s2
 * @author Tommy Pang
 */
public class CCC17S2 {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Integer [] tides, high, low;
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        tides = new Integer[N]; low = new Integer[N/2];
        List<Integer> high = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tides[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tides);
        if (N%2==0){
            for (int i = 0; i < N/2; i++) {
                low[i] = tides[i];
            }
            for (int i = N/2; i < N; i++) {
                high.add(tides[i]);
            }
            Arrays.sort(low, Collections.reverseOrder());
            for (int i = 0; i < N/2; i++) {
                System.out.print(low[i] + " " + high.get(i) + " ");
            }
        }

        else {
            for (int i = 0; i < N/2; i++) {
                low[i] = tides[i];
            }
            for (int i = N/2; i < N; i++) {
                high.add(tides[i]);
            }
            Arrays.sort(low, Collections.reverseOrder());
            for (int i = 0; i < N/2; i++) {
                System.out.print(low[i] + " " + high.get(i) + " ");
            }
            System.out.print(high.get(N/2) + "\n");
        }
    }
}
