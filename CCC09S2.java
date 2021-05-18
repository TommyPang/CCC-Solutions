import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
/**
 * CCC '09 S2 - Lights Going On and Off
 * Question type: Implementation
 * 5/5 on DMOJ
 * @author Tommy Pang
 */
public class CCC09S2_BitOperation {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int [] row;
    static int R, L;
    public static void main(String[] args) throws IOException{
        R = Integer.parseInt(br.readLine());
        row = new int[R];
        L = Integer.parseInt(br.readLine());
        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<L; j++) {
                row[i] = row[i]<<1 | Integer.parseInt(st.nextToken());
            }
        }
        Set<Integer> pattern[] = new HashSet[R];
        for(int i=0; i<R; i++) pattern[i] = new HashSet();
        pattern[0].add(row[0]);
        for(int i=1; i<R; i++) {
            pattern[i].add(row[i]);
            for(int x: pattern[i-1]) pattern[i].add(row[i] ^ x);
        }
        System.out.println(pattern[R-1].size());
    }
}
