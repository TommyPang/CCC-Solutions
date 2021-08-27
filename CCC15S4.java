import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * CCC '15 S4 - Convex Hull
 * Question type: Graph Theory
 * 15/15 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc15s4
 * @author Tommy Pang
 */
public class CCC15S4 {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int K, N, M;
    static List<edge> [] adj;
    static int [][] dis = new int[2002][202];
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken()); N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken()), h = Integer.parseInt(st.nextToken());
            adj[a].add(new edge(b, t, h));
            adj[b].add(new edge(a, t, h));
        }
        for (int i = 0; i < 2002; i++) {
            for (int j = 0; j < 202; j++) {
                dis[i][j] = Integer.MAX_VALUE;
            }
        }
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
        PriorityQueue<edge> queue = new PriorityQueue<>();
        queue.add(new edge(A, 0, 0));
        dis[A][0] = 0;
        while (!queue.isEmpty()){
            edge e = queue.poll();
            if (e.t>dis[e.b][e.h]) continue;
            for (edge nxt : adj[e.b]) {
                if (nxt.h+e.h>=K) continue;
                if (dis[nxt.b][nxt.h+e.h]>e.t+nxt.t){
                    dis[nxt.b][nxt.h+e.h] = e.t+nxt.t;
                    queue.add(new edge(nxt.b, dis[nxt.b][nxt.h+ e.h], nxt.h+e.h));
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int k=0; k<K; k++) ans = Math.min(ans, dis[B][k]);
        if (ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }

    public static class edge implements Comparable<edge>{
        int b, t, h;
        edge(int end, int time, int height){
            b = end; t = time; h = height;
        }

        @Override
        public int compareTo(edge o) {
            return Integer.compare(t, o.t);
        }

    }


}
