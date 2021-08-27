import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * CCC '16 S3 - Phonomenal Reviews
 * Question URL: Graph Theory
 * 13/15 on DMOJ, Batch #7 TLE
 * Question URL: https://dmoj.ca/problem/ccc16s3
 * @author Tommy Pang
 */
public class CCC16S3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean [] notUseful;
    static int [] in;
    static List<Integer> restaurant = new ArrayList<>();
    static List<Integer>[] adj;
    static int N, M;
    static Queue<Integer> queue = new LinkedList<>();
    static int [] dis;
    static boolean [] vis;
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dis = new int[N]; vis = new boolean[N];
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N];
        in = new int[N];
        notUseful = new boolean[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList();
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            restaurant.add(Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adj[start].add(end); adj[end].add(start);
            in[start]+=1; in[end]+=1;
        }
        cutEdge();
        int cutted = 0;
        int point = 0;
        for (int i = 0; i < N; i++) {
            if (notUseful[i]) cutted+=1;
            else point = i;
        }
        int E = N - cutted - 1;
        int diameter = FindDiameter(point);
        System.out.println(2*E - diameter);
    }
    static void cutEdge(){
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (in[i] == 1 && !restaurant.contains(i)){
                notUseful[i] = true;
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            int cur = queue.poll();
            for (int i = 0; i < N; i++) {
                if (adj[i].contains(cur)){
                    in[i]-=1;
                    if (in[i]==1 && !restaurant.contains(i)) {
                        queue.add(i);
                        notUseful[i] = true;
                    }
                }
            }
        }
    }
    static int FindDiameter(int i){
        BFS(i);
        int max = 0, idx = -1;
        for (int j = 0; j < N; j++) {
            if (max<dis[j]) {
                max = dis[j];
                idx = j;
            }
        }
        Arrays.fill(dis, 0);
        Arrays.fill(vis, false);
        BFS(idx); vis[idx] = true;
        max = 0;
        for (int j = 0; j < N; j++) {
            if (max<dis[j]) {
                max = dis[j];
            }
        }
        return max;
    }
    static void BFS(int i){
        queue.add(i); vis[i] = true; dis[i] = 0;
        while (!queue.isEmpty()){
            int cur = queue.poll();
            for (int nxt : adj[cur]) {
                if (!vis[nxt] && !notUseful[nxt]){
                    queue.add(nxt); vis[nxt] = true;
                    dis[nxt] = dis[cur] + 1;
                }
            }
        }
    }
}
