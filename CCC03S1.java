import java.util.*;
import java.io.*;
/**
 * CCC '03 S1 - Snakes and Ladders
 * Question type: Implementation
 * 2/2 on DMOJ
 * @author Tommy Pang
 */
public class CCC03S1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(99, 77); map.put(90, 48); map.put(54, 19);
        map.put(9, 34); map.put(40, 64); map.put(67, 86);
        int cur = 1;
        while (true){
            int dice = Integer.parseInt(br.readLine());
            if (dice==0) {
                System.out.println("You Quit!");
                return;
            }
            else {
                if (cur+dice<=100) cur+=dice;
                else {
                    System.out.println("You are now on square "+cur);
                    continue;
                }
                if (map.containsKey(cur)) cur = map.get(cur);
                System.out.println("You are now on square "+cur);
                if (cur == 100) {
                    System.out.println("You Win!");
                    return;
                }
            }
        }
    }
}
