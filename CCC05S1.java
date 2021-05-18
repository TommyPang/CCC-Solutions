import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
/**
 * CCC '05 S1 - Snow Calls
 * Question type: Implementation
 * 1/1 on DMOJ
 * @author Tommy Pang
 */
public class CCC05S1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException{
        map.put("A", 2); map.put("B", 2); map.put("C", 2);
        map.put("D", 3); map.put("E", 3); map.put("F", 3);
        map.put("G", 4); map.put("H", 4); map.put("I", 4);
        map.put("J", 5); map.put("K", 5); map.put("L", 5);
        map.put("M", 6); map.put("N", 6); map.put("O", 6);
        map.put("P", 7); map.put("Q", 7); map.put("R", 7); map.put("S", 7);
        map.put("T", 8); map.put("U", 8); map.put("V", 8);
        map.put("W", 9); map.put("X", 9); map.put("Y", 9); map.put("Z", 9);
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            String [] temp = input.split("-");
            String before = "";
            for (String nxt : temp) {
                before+=nxt;
            }
            String [] a = new String[10];
            for (int j = 0; j < 10; j++) {
                if (map.containsKey(String.valueOf(before.charAt(j)))){
                    a[j] = String.valueOf(map.get(String.valueOf(before.charAt(j))));
                }
                else a[j] = String.valueOf(before.charAt(j));
            }
            String ans = "";
            for (int k = 0; k < 3; k++) {
                ans+=a[k];
            }
            ans+="-";
            for (int j = 3; j < 6; j++) {
                ans+=a[j];
            }
            ans+="-";
            for (int j = 6; j < 10; j++) {
                ans+=a[j];
            }
            System.out.println(ans);
        }

    }
}
