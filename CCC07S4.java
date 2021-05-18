import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/**
 * CCC '07 S4 - Waterpark
 * Question type: Dynamic Programming, Graph Theory
 * 5/5 on DMOJ
 * @author Tommy Pang
 */
public class CCC07S4 {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer> [] adj;
    static int [] nums;
    static int N;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N+1];
        nums = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            adj[i] = new ArrayList<>();
        }
        while (true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a==0 && b==0) break;
            adj[a].add(b);
        }
        find_path(1);
        System.out.println(nums[1]);
    }
    static void find_path(int i){
        for (int nxt : adj[i]) {
            if (nxt==N) nums[i]+=1;
            else if (nums[nxt]!=0) nums[i]+=nums[nxt];
            else {
                find_path(nxt);
                nums[i]+=nums[nxt];
            }
        }
    }
}
