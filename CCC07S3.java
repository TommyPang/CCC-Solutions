import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * CCC '07 S3 - Friends
 * Question type: Graph Theory
 * 4/4 on DMOJ
 * @author Tommy Pang
 */
public class CCC07S3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int [] friends = new int[10000], distance;
    static boolean [] vis;
    static int ans = 0;
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends[a] = b;
        }
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 0) return;
            ans = 0;
            BFS(a);
            if (!vis[b]) {
                System.out.println("No");
                continue;
            }
            ans = distance[b]-1;
            BFS(b);
            if (!vis[a]) System.out.println("No");
            else {
                System.out.println("Yes "+ ans);
            }
        }
    }
    static void BFS(int a){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        vis = new boolean[10000];
        distance = new int[10000];
        vis[a] = true;
        distance[a] = 0;
        while (!queue.isEmpty()){
            int cur = queue.poll();
            if (!vis[friends[cur]]){
                queue.add(friends[cur]);
                distance[friends[cur]] = distance[cur]+1;
                vis[friends[cur]] = true;
            }
        }
    }
}
