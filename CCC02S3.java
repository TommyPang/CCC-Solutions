import java.util.*;
import java.io.*;
/**
 * CCC '02 S3 - Blindfold
 * Question type: Simulation
 * 3/4 on DMOJ, case 3 tle
 * @author  Tommy Pang
 */
public class CCC02S3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int step;
    static String[] ope;
    static int row, col;
    static String[][] map;
    public static void main(String[] args) throws IOException {
        row = Integer.parseInt(br.readLine());
        col = Integer.parseInt(br.readLine());
        map = new String[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 1; j <= col; j++) {
                map[i][j] = String.valueOf(line.charAt(j - 1));
            }
        }
        step = Integer.parseInt(br.readLine());
        ope = new String[step];
        for (int i = 0; i < step; i++) {
            ope[i] = br.readLine();
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (map[i][j].equals("X")) continue;
                for (int k = 0; k < 4; k++) {
                    if (k == 0) move("N", i, j);
                    else if (k == 1) move("S", i, j);
                    else if (k == 2) move("E", i, j);
                    else if (k == 3) move("W", i, j);

                }
            }
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    static void move(String dir, int r, int c) {
        while (true) {
            for (int i = 0; i < step; i++) {
                switch (ope[i]) {
                    case "L":
                        switch (dir) {
                            case "N" :
                                dir = "W";
                                break;
                            case "S" :
                                dir = "E";
                                break;
                            case "W" :
                                dir = "S";
                                break;
                            case "E" :
                                dir = "N";
                        }
                        break;
                    case "R":
                        switch (dir) {
                            case "N" :
                                dir = "E";
                                break;
                            case "S" :
                                dir = "W";
                                break;
                            case "W" :
                                dir = "N";
                                break;
                            case "E" :
                                dir = "S";
                        }
                        break;
                    case "F":
                        switch (dir) {
                            case "N" :
                                r -= 1;
                                break;
                            case "S" :
                                r += 1;
                                break;
                            case "W" :
                                c -= 1;
                                break;
                            case "E" :
                                c += 1;
                        }
                        break;
                }
                if (r < 1 || r > row || c < 1 || c > col || map[r][c].equals("X")) {
                    return;
                }
            }
            map[r][c] = "*";
        }
    }
}
