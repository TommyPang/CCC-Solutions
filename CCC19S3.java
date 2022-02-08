import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/**
 * CCC '19 S3 - Arithmetic Square
 * Question type: Implementation
 * 16/16 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc19s3
 * @author Tommy Pang
 */

public class CCC19S3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7;
    public static void main(String[] args) throws IOException {
        int a[][] = new int[3][3], x[][] = new int[3][3], row[] = new int[3], col[] = new int[3], cnt=0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                String s = next();
                if(s.equals("X")) { x[i][j] = 1; row[i]++; col[j]++; cnt++; }
                else a[i][j] = Integer.parseInt(s);
            }
        }
        while(cnt > 0){
            boolean flag = true;
            for(int i=0; i<3 && flag; i++){
                if(row[i] == 1){
                    if(x[i][0] == 1) { a[i][0] = 2*a[i][1] - a[i][2]; x[i][0] = 0; col[0]--; }
                    if(x[i][1] == 1) { a[i][1] = (a[i][0] + a[i][2])/2; x[i][1] = 0; col[1]--; }
                    if(x[i][2] == 1) { a[i][2] = 2*a[i][1] - a[i][0]; x[i][2] = 0; col[2]--; }
                    cnt --; row[i]--;  flag = false;
                }
            }
            for(int i=0; i<3 && flag; i++){
                if(col[i] == 1){
                    if(x[0][i] == 1) { a[0][i] = 2*a[1][i] - a[2][i]; x[0][i] = 0; row[0]--; }
                    if(x[1][i] == 1) { a[1][i] = (a[0][i] + a[2][i])/2; x[1][i] = 0; row[1]--; }
                    if(x[2][i] == 1) { a[2][i] = 2*a[1][i] - a[0][i]; x[2][i] = 0; row[2]--; }
                    cnt --; col[i]--;   flag = false;
                }
            }
            if(x[1][1] == 1 && flag) { a[1][1] = 0; row[1]--; col[1]--; cnt--; x[1][1]=0; flag = false; }
            if(x[1][0] == 1 && flag) { a[1][0] = 0; row[1]--; col[0]--; cnt--; x[1][0]=0; flag = false; }
            if(x[1][2] == 1 && flag) { a[1][2] = 0; row[1]--; col[2]--; cnt--; x[1][2]=0; flag = false; }
            if(x[0][1] == 1 && flag) { a[0][1] = 0; row[0]--; col[1]--; cnt--; x[0][1]=0; flag = false; }
            if(x[2][1] == 1 && flag) { a[2][1] = 0; row[2]--; col[1]--; cnt--; x[2][1]=0; flag = false; }
            if(x[0][0] == 1 && flag) { a[0][0] = 0; row[0]--; col[0]--; cnt--; x[0][0]=0; flag = false; }
        }
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }
    }



    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong() throws IOException {
        return Long.parseLong(next());
    }
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }
    static char readCharacter() throws IOException {
        return next().charAt(0);
    }
    static String readLine() throws IOException {
        return br.readLine().trim();
    }

}
