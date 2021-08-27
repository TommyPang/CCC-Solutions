import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * CCC '16 S5 - Circle of Life
 * Question type: Simulation
 * 15/15 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc16s5
 * @author Tommy Pang
 */
public class CCC16S5 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long T = Long.parseLong(st.nextToken());
        int[] a = new int[N];
        String s = br.readLine();
        for(int i = 0; i < N; i++)
            a[i] = s.charAt(i) - '0';
        int[] tmp;

        for(int i = 0; i <= 50; i++){
            tmp = new int[N];
            if((T & (1L << i)) != 0){
                int r = (int)((1L << i) % N);
                int l = (N - r) % N;

                for(int j = 0; j < N; j++){
                    tmp[j] = a[(j + r) % N] ^ a[(j + l) % N];
                }
                a = Arrays.copyOf(tmp, a.length);
            }
        }
        for(int x : a)
            System.out.print(x);
        System.out.println();
    }
}
