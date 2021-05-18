import java.util.*;
import java.io.*;
/**
 * CCC '00 S2 - Babbling Brooks
 * Question type: Simulation
 * 5/5 on DMOJ
 * @author  Tommy Pang
 */
public class CCC00S2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final int MAX = 100;
    static int[] result = new int[MAX];
    static List<Integer> temp = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            result[i] = Integer.parseInt(br.readLine());
        }
        int operation = Integer.parseInt(br.readLine());
        while (operation != 77) {
            babblingAlg(operation);
            operation = Integer.parseInt(br.readLine());
        }
        for (int nxt : result) {
            if (nxt != 0) System.out.print(nxt+" ");
        }
    }

    static void babblingAlg(int operation) throws IOException {
        switch (operation) {
            case (99):
                int idx = Integer.parseInt(br.readLine());
                int percentage = Integer.parseInt(br.readLine());
                split(idx - 1, percentage);
                break;
            case (88):
                idx = Integer.parseInt(br.readLine());
                join(idx - 1);
                break;
            default:
                break;
        }

    }

    private static void split(int idx, int percentage) {
        int[] suf = result.clone();
        if (percentage == 0) return;
        int left = Math.round(result[idx] * ((float) percentage / 100));
        int right = Math.round(result[idx] * (float) (100 - percentage) / 100);
        result[idx] = left;
        result[idx + 1] = right;
        for (int i = idx + 2; i < MAX; i++) {
            result[i] = suf[i - 1];
        }
    }

    private static void join(int idx) {
        int[] suf = result.clone();
        result[idx] = result[idx] + result[idx + 1];
        for (int i = idx + 1; i < MAX-1; i++) {
            result[i] = suf[i + 1];
        }
    }
}
