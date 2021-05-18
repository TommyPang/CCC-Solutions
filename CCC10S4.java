import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CCC10S4 {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean [][] removed = new boolean[1001][1001];
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int E = Integer.parseInt(st.nextToken());

        }
    }
    public static class edge implements Comparable<edge>{
        int a, b, cost;
        edge(int start, int end, int c){
            a = start; b = end; cost = c;
        }

        @Override
        public int compareTo(edge o) {
            return 0;
        }
    }
}
