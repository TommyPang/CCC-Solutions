import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * CCC '09 S4 - Shop and Ship
 * Question type: Graph Theory
 * 3/5 on DMOJ, case 4, 5 tle
 * @author Tommy Pang
 */
public class CCC09S4_PriorityQueue {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<edge>[] adj;
    static int [] prices, dis;
    static boolean [] vis;
    //Priority Queue way
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N+1]; prices = new int[N+1]; dis = new int[N+1];
        vis = new boolean[N+1];
        Arrays.fill(prices, -1); Arrays.fill(dis, Integer.MAX_VALUE);
        for (int i = 0; i <= N; i++) adj[i] = new ArrayList<>();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
            adj[a].add(new edge(b, c)); adj[b].add(new edge(a, c));
        }
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            prices[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        int D = Integer.parseInt(br.readLine());
        Dijkstra(D);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            if (vis[i] && prices[i] != -1){
                ans = Math.min(ans, prices[i] + dis[i]);
            }
        }
        System.out.println(ans);
    }
    static void Dijkstra(int i){
        PriorityQueue<edge> queue = new PriorityQueue<>();
        queue.add(new edge(i, 0)); dis[i] = 0;
        while (!queue.isEmpty()){
            edge e = queue.poll();
            int b = e.b, cost = e.c;
            vis[b] = true;
            if (cost>dis[e.b]) continue;
            for (edge nxt : adj[b]) {
                if (dis[nxt.b] > dis[b] + nxt.c){
                    dis[nxt.b] = dis[b] + nxt.c;
                    queue.add(new edge(nxt.b, dis[nxt.b]));
                }
            }
        }
    }
    public static class edge implements Comparable<edge>{
        int b, c;
        edge(int end, int cost){
            b = end; c = cost;
        }

        @Override
        public int compareTo(edge e) {
            return Integer.compare(c, e.c);
        }

    }
}
