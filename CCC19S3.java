import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/**
 * CCC '19 S3 - Arithmetic Square
 * Question type: Implementation
 * 4/16 on DMOJ, WA on Batch 2-6
 * Question URL: https://dmoj.ca/problem/ccc19s3
 * @author Tommy Pang
 */
public class CCC19S3 {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[][] grid = new String[3][3];
    static int max = 0;
    static List<Integer> filledR = new ArrayList<>(), toFillR = new ArrayList<>();
    static List<Integer> filledC = new ArrayList<>(), toFillC = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                String v = st.nextToken();
                grid[i][j] = v;
                if (!(v.equals("X"))) max = Math.max(Integer.parseInt(v), max);
            }
        }
        for (int i = 0; i < 3; i++) {
            fillingRow();
            fillingCol();
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j].equals("X")) {
                    toFillR.add(i);
                    toFillC.add(j);
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void fillingRow(){
        for (int i = 0; i < 3; i++) {
            int cnt = 0;
            for (int j = 0; j < 3; j++) {
                if (!grid[i][j].equals("X")) cnt+=1;
            }
            switch (cnt){
                case 3:
                    continue;
                case 2:
                    if (grid[i][0].equals("X")){
                        grid[i][0] = String.valueOf(Integer.parseInt(grid[i][1]) - (Integer.parseInt(grid[i][2]) - Integer.parseInt(grid[i][1])));
                        filledR.add(i); filledC.add(0);
                    }
                    else if (grid[i][1].equals("X")){
                        grid[i][1] = String.valueOf((Integer.parseInt(grid[i][0]) + Integer.parseInt(grid[i][2]))/2);
                        filledR.add(i); filledC.add(1);
                    }
                    else {
                        grid[i][2] = String.valueOf(Integer.parseInt(grid[i][1]) + (Integer.parseInt(grid[i][1]) - (Integer.parseInt(grid[i][0]))));
                        filledR.add(i); filledC.add(2);
                    }
                    break;
            }
        }
    }
    static void fillingCol() {
        for (int i = 0; i < 3; i++) {
            int cnt = 0;
            for (int j = 0; j < 3; j++) {
                if (!grid[j][i].equals("X")) cnt += 1;
            }
            switch (cnt) {
                case 3:
                    continue;
                case 2:
                    if (grid[0][i].equals("X")) {
                        grid[0][i] = String.valueOf(Integer.parseInt(grid[1][i]) - (Integer.parseInt(grid[2][i]) - Integer.parseInt(grid[1][i])));
                        filledR.add(0); filledC.add(i);
                    } else if (grid[1][i].equals("X")) {
                        grid[1][i] = String.valueOf((Integer.parseInt(grid[0][i]) + Integer.parseInt(grid[2][i])) / 2);
                        filledR.add(1); filledC.add(i);
                    } else {
                        grid[2][i] = String.valueOf(Integer.parseInt(grid[1][i]) + (Integer.parseInt(grid[1][i]) - (Integer.parseInt(grid[0][i]))));
                        filledR.add(2); filledC.add(i);
                    }
                    break;
            }
        }
    }

}