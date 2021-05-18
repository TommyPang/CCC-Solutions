import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * CCC '07 S2 - Boxes
 * Question type: Implementation
 * 5/5 on DMOJ
 * @author Tommy Pang
 */
public class CCC07S2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int [] sizes;
    static String [] s;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        s = new String[N]; sizes = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken(), b = st.nextToken(), c = st.nextToken();
            s[i] = a + " " + b + " " + c;
            sizes[i] = Integer.parseInt(a) * Integer.parseInt(b) * Integer.parseInt(c);
        }
        int cases = Integer.parseInt(br.readLine());
        for (int i = 0; i < cases; i++) {
            boolean found = false;
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken() + " " + st.nextToken() + " " + st.nextToken();
            int ans = Integer.MAX_VALUE;
            for (int j = 0; j < s.length; j++) {
                if (check(temp, s[j])){
                    ans = Math.min(sizes[j], ans);
                    found = true;
                }
            }
            if (!found) System.out.println("Item does not fit.");
            else System.out.println(ans);
        }
    }
    static boolean check(String a, String b){
        String [] first = a.split(" ");
        String [] second = b.split(" ");
        int [] temp1 = new int[3]; int [] temp2 = new int[3];
        for (int i = 0; i < 3; i++) {
            temp1[i] = Integer.parseInt(first[i]);
            temp2[i] = Integer.parseInt(second[i]);
        }
        Arrays.sort(temp1); Arrays.sort(temp2);
        for (int i = 0; i < 3; i++) {
            if (temp1[i]>temp2[i]) return false;
        }
        return true;
    }
}
