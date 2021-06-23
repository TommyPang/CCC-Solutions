import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * CCC '11 S5 - Switch
 * Question type: Graph Theory
 * 100/100 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc11s5
 * @author Tommy Pang
 */
public class CCC11S5 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int mask = 0;
        for (int i = 1; i <= N; i++) {
            mask<<=1;
            mask |= Integer.parseInt(br.readLine());
        }
        boolean [] vis = new boolean[1<<N];
        Queue<Integer> queue = new LinkedList<>();
        vis[mask] = true;
        int dis = 0;
        queue.add(mask);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur_mask = queue.poll();
                if (cur_mask==0){
                    System.out.println(dis);
                    return;
                }
                for (int j = 0; j < N; j++) {
                    if ((cur_mask & 1 << j) == 0) {
                        int new_mask = cur_mask | (1 << j);
                        new_mask = solve(new_mask, N);
                        if (!vis[new_mask]) {
                            queue.add(new_mask);
                            vis[new_mask] = true;
                        }
                    }
                }
            }
            dis += 1;
        }
    }
    static int solve(int mask, int n){
        int cnt = 0;
        for (int i = 0; i <= n; i++) {
            if ((mask & 1<<i) == (1<<i)){
                cnt+=1;
                continue;
            }
            else if (cnt>=4){
                int new_mask = ((1<<cnt)-1) << (i-cnt);
                mask^=new_mask;
                return mask;
            }
            cnt=0;
        }
        return mask;
    }
}
