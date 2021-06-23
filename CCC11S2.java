import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * CCC '11 S2 - Multiple Choice
 * Question type: Implementation
 * 100/100 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc11s2
 * @author Tommy Pang
 */
public class CCC11S2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String [] correct, student;
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        correct = new String[N]; student = new String[N];
        for (int i = 0; i < N; i++) {
            student[i] = br.readLine();
        }
        for (int i = 0; i < N; i++) {
            correct[i] = br.readLine();
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (correct[i].equals(student[i])) ans+=1;
        }
        System.out.println(ans);
    }
}
