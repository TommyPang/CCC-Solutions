import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * CCC '18 S2 - Sunflowers
 * Question URL: Implementation
 * 15/15 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc18s2
 * @author Tommy Pang
 */
public class CCC18S2 {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int [][] table, sectable;
    static int N;
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        table = new int[N][N];
        sectable = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if (validateRow(table) && validateCol(table)) {
            printTable(table);
            return;
        }
        else {
            rotate(sectable, table);
        }
        if (validateRow(sectable) && validateCol(sectable)) {
            printTable(sectable);
            return;
        }
        else {
            rotate(table, sectable);
        }
        if (validateRow(table) && validateCol(table)) {
            printTable(table);
            return;
        }
        else {
            rotate(sectable, table);
        }
        if (validateRow(sectable) && validateCol(sectable)) printTable(sectable);
    }
    static void rotate(int [][] toFill, int [][] original){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                toFill[j][N-1-i] = original[i][j];
            }
        }
    }
    static boolean validateRow(int [][] t){
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (t[i][j] < t[i][j-1]) return false;
            }
        }
        return true;
    }
    static boolean validateCol(int [][] t){
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (t[j][i] < t[j-1][i]) return false;
            }
        }
        return true;
    }
    static void printTable(int [][] t){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
    }
}
