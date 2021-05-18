import java.util.*;
import java.io.*;
/**
 * CCC '00 S1 - Slot Machines
 * Question type: Simulation
 * 5/5 on DMOJ
 * @author  Tommy Pang
 */
public class CCC00S1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int plays = 0;
        int money = Integer.parseInt(br.readLine());
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        while (money >= 1) {
            money -= 1;
            plays += 1;
            a += 1;
            if (a == 35) {
                money += 30;
                a = 0;
            }
            if (money == 0) break;
            money -= 1;
            plays += 1;
            b += 1;
            if (b == 100) {
                money += 60;
                b = 0;
            }
            if (money == 0) break;
            money -= 1;
            plays += 1;
            c += 1;
            if (c == 10) {
                money += 9;
                c = 0;
            }
            if (money == 0) break;
        }
        System.out.println("Martha plays " + plays + " times before going broke.");
    }
}
