import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * CCC '15 S3 - Gates
 * Question URL: Data Structures
 * 15/15 on CCC, 15/30 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc15s3
 * @author Tommy Pang
 */
public class CCC15S3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        boolean [] used = new boolean[G+1];
        int total = 0;
        for (int i = 0; i < P; i++) {
            int gate = Integer.parseInt(br.readLine());
            for (int j = gate; j > 0; j--) {
                if (!used[j]) {
                    total+=1;
                    used[j] = true;
                    break;
                }
                if (j==1){
                    if (!used[j]) {
                        total+=1;
                        used[j] = true;
                        break;
                    }
                    else {
                        System.out.println(total);
                        return;
                    }
                }
            }
        }
        System.out.println(total);
    }
}
