import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * CCC '19 S1 - Flipper
 * Question type: Implementation
 * 15/15 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc19s1
 * @author Tommy Pang
 */
public class CCC19S1 {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int [][] grid = new int[2][2];
    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        grid[0][0] = 1; grid[0][1] = 2; grid[1][0] = 3; grid[1][1] = 4;
        for (int i = 0; i < s.length(); i++) {
            String temp = String.valueOf(s.charAt(i));
            if (temp.equals("V")){
                int temp1 = grid[0][1];
                grid[0][1] = grid[0][0];
                grid[0][0] = temp1;
                int temp2 = grid[1][1];
                grid[1][1] = grid[1][0];
                grid[1][0] = temp2;
            }
            else {
                int temp1 = grid[1][0];
                grid[1][0] = grid[0][0];
                grid[0][0] = temp1;
                int temp2 = grid[1][1];
                grid[1][1] = grid[0][1];
                grid[0][1] = temp2;
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
