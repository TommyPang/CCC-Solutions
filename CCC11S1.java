import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * CCC '11 S1 - English or French?
 * Question type: String Algorithms
 * 100/100 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc11s1
 * @author Tommy Pang
 */
public class CCC11S1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int s = 0, S = 0, t = 0, T = 0;
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            while (true) {
                if (st.hasMoreTokens()) {
                    String letters = st.nextToken();
                    for (int j = 0; j < letters.length(); j++) {
                        switch (String.valueOf(letters.charAt(j))) {
                            case "s":
                                s += 1;
                                break;
                            case "S":
                                S += 1;
                                break;
                            case "t":
                                t += 1;
                                break;
                            case "T":
                                T += 1;
                        }
                    }
                }
                else break;
            }
        }
        if (t+T > s+S) System.out.println("English");
        else if (s+S > t+T) System.out.println("French");
        else if (t+T == s+S) System.out.println("French");
    }
}
