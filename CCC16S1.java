import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * CCC '16 S1 - Ragaman
 * Question URL: Implementation
 * 15/15 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc16s1
 * @author Tommy Pang
 */
public class CCC16S1 {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int [] cntA = new int[26], cntB = new int[26];
    static int dif = 0, mark = 0;
    public static void main(String[] args) throws IOException{
        String a = br.readLine();
        String b = br.readLine();
        for (int i = 0; i < a.length(); i++) {
            if (String.valueOf(b.charAt(i)).equals("*")) {
                mark+=1;
                cntA[a.charAt(i) - 'a'] += 1;
                continue;
            }
            cntA[a.charAt(i) - 'a'] += 1;
            cntB[b.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < 26; i++) {
            if (cntA[i]!=cntB[i]) dif+=Math.abs(cntA[i] - cntB[i]);
        }
        if (dif==mark) System.out.println("A");
        else System.out.println("N");
    }
}
