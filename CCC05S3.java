import java.io.*;
import java.util.StringTokenizer;
/**
 * CCC '05 S3 - Quantum Operations
 * Question type: Implementation
 * 100/100 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc05s3
 * @author Tommy Pang
 */
public class CCC05S3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7;
    static int n, r, c;
    static long max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        n = readInt();
        r = readInt(); c = readInt();
        long [][] A = new long[r+1][c+1];
        for (int j = 1; j <= r; j++) {
            for (int k = 1; k <= c; k++) {
                A[j][k] = readLong();
            }
        }
        for (int i = 1; i < n; i++) {
            r = readInt(); c = readInt();
            int [][] B = new int[r+1][c+1];
            for (int j = 1; j <= r; j++) {
                for (int k = 1; k <= c; k++) {
                    B[j][k] = readInt();
                }
            }
            A = tensorProduct(A, B);
        }
        /*
        for (int i = 1; i <= A.length-1; i++) {
            for (int j = 1; j <= A[0].length-1; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }

         */
        solve(A);
    }
    public static long[][] tensorProduct(long [][] A, int [][] B) {
        int m = A.length-1, n = A[0].length-1, p = B.length-1, q = B[0].length-1;
        long [][] res = new long[m*p+1][n*q+1];
        int row_idx = 1, col_idx = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                long cur = A[i][j];
                for (int k = 1; k <= p; k++) {
                    for (int l = 1; l <= q; l++) {
                        res[row_idx][col_idx] = cur * B[k][l];
                        col_idx++;
                    }
                    col_idx = j*q-q+1;
                    row_idx++;
                }
                row_idx = i*p-p+1;
                col_idx += q;
            }
            row_idx += p;
            col_idx = 1;
        }


        return res;
    }
    public static void solve(long [][] A) {
        for (int i = 1; i <= A.length-1; i++) {
            for (int j = 1; j <= A[0].length-1; j++) {
                max = Math.max(A[i][j], max);
                min = Math.min(A[i][j], min);
            }
        }

        System.out.println(max);
        System.out.println(min);
        long [] row = row_sum(A);
        System.out.println(row[0]);
        System.out.println(row[1]);
        row = col_sum(A);
        System.out.println(row[0]);
        System.out.println(row[1]);
    }
    public static long[] row_sum(long [][] A) {
        long max_sum = Long.MIN_VALUE, min_sum = Long.MAX_VALUE;
        for (int i = 1; i <= A.length-1; i++) {
            long S = 0L;
            for (int j = 1; j <= A[0].length-1; j++) {
                S+=A[i][j];
            }
            max_sum = Math.max(S, max_sum);
            min_sum = Math.min(S, min_sum);
        }
        return new long[] {max_sum, min_sum};
    }
    public static long[] col_sum(long [][] A) {
        long max_sum = Long.MIN_VALUE, min_sum = Long.MAX_VALUE;
        for (int i = 1; i <= A[0].length-1; i++) {
            long S = 0L;
            for (int j = 1; j <= A.length-1; j++) {
                S+=A[j][i];
            }
            max_sum = Math.max(S, max_sum);
            min_sum = Math.min(S, min_sum);
        }
        return new long[] {max_sum, min_sum};
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

}
