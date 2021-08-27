import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
/**
 * CCC '15 S2 - Jerseys
 * Question URL: Implementation
 * 15/15 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc15s2
 * @author Tommy Pang
 */
public class CCC15S2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean [] jersey;
    static Map<Integer, String> map = new HashMap<>();
    static int total = 0;
    public static void main(String[] args) throws IOException{
        int J = Integer.parseInt(br.readLine());
        int A = Integer.parseInt(br.readLine());
        jersey = new boolean[J+1];
        for (int i = 1; i <= J; i++) {
            map.put(i, br.readLine());
        }
        for (int i = 0; i < A; i++) {
            st = new StringTokenizer(br.readLine());
            String size = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if (jersey[num]) continue;
            switch (size){
                case "S":
                    if (map.get(num).equals("S") || map.get(num).equals("M") || map.get(num).equals("L")){
                        total+=1;
                        jersey[num] = true;
                    }
                    break;
                case "M":
                    if (map.get(num).equals("M") || map.get(num).equals("L")){
                        total+=1;
                        jersey[num] = true;
                    }
                    break;
                case "L":
                    if (map.get(num).equals("L")){
                        total+=1;
                        jersey[num] = true;
                    }
            }
        }
        System.out.println(total);
    }
}
