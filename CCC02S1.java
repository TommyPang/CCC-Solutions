import java.util.*;
import java.io.*;
/**
 * CCC '02 S1 - The Students' Council Breakfast
 * Question type: Implementation
 * 3/3 on DMOJ
 * @author  Tommy Pang
 */
public class CCC02S1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int total = 0;
    public static void main(String[] args) throws IOException {
        int P = Integer.parseInt(br.readLine());
        int G = Integer.parseInt(br.readLine());
        int R = Integer.parseInt(br.readLine());
        int O = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int min = 100000, combination = 0;
        for (int i = 0; i < N/P + 1; i++) {
            for (int j = 0; j < N/G + 1; j++) {
                for (int k = 0; k < N/R + 1; k++) {
                    for (int l = 0; l < N/O + 1; l++) {
                        total += (i*P + j*G + k*R + l*O);
                        if (total == N) {
                            System.out.println("# of PINK is " + i + " # of GREEN is " + j + " # of RED is " + k + " # of ORANGE is " +l);
                            min = Math.min(min, i+j+k+l);
                            combination+=1;
                            total=0;
                        }
                        total=0;
                    }
                    total=0;
                }
                total=0;
            }
            total=0;
        }
        System.out.println("Total combinations is " + combination + ".");
        System.out.println("Minimum number of tickets to print is " + min + ".");
    }
}
