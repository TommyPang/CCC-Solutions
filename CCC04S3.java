import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * CCC '04 S3 - Spreadsheet
 * Question type: Graph Theory
 * 3/5 on DMOJ, case 3, 4 WA
 * @author Tommy Pang
 */
public class CCC04S3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Map<String, Integer> map = Stream.of(new Object[][]{
            {"A", 0},
            {"B", 1},
            {"C", 2},
            {"D", 3},
            {"E", 4},
            {"F", 5},
            {"G", 6},
            {"H", 7},
            {"I", 8},
            {"J", 9},
    }).collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));
    static String[][] elements = new String[10][9];
    static boolean[][] defined = new boolean[10][9];
    static int[][] result = new int[10][9];

    static {
        for (int[] arr1 : result)
            Arrays.fill(arr1, -1);
    }

    public static void main(String[] args) throws IOException {
        readInput();
        traverseArray();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                if (result[i][j] != -1) {
                    System.out.print(elements[i][j] + " ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    private static void readInput() throws IOException {
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                String s = st.nextToken();
                elements[i][j] = s;
                try {
                    int num = Integer.parseInt(s);
                    if (!(num < 0)) {
                        result[i][j] = num;
                    } else {
                        throw new IOException();
                    }
                } catch (NumberFormatException e) {
                }
            }
        }
    }

    private static void traverseArray() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                if (result[i][j] == -1) {
                    List<String> pre = new ArrayList<>();
                    pre.add(elements[i][j]);
                    int temp = calculateCell(elements[i][j], pre);
                    if (temp != 0) {
                        result[i][j] = temp;
                        elements[i][j] = String.valueOf(temp);
                    }
                }
            }
        }
    }

    private static int calculateCell(String toCalculate, List pre) {
        String[] temp = toCalculate.split("\\+");
        int val = 0;
        for (int k = 0; k < temp.length; k++) {
            String letter = String.valueOf(temp[k].charAt(0));
            String num = String.valueOf(temp[k].charAt(1));
            int v;
            if (result[map.get(letter)][Integer.parseInt(num) - 1] != -1) {
                val = val + Integer.parseInt(elements[map.get(letter)][Integer.parseInt(num)-1]);
            } else {
                if (pre.contains(elements[map.get(letter)][Integer.parseInt(num)-1])) return 0;
                else {
                    pre.add(elements[map.get(letter)][Integer.parseInt(num)-1]);
                    v = calculateCell(elements[map.get(letter)][Integer.parseInt(num)-1], pre);
                }
                val = (v == 0) ? 0 : val + v;
            }
        }
        return val;
    }
}
