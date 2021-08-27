import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * CCC '13 S4 - Who is Taller?
 * Question URL: Graph Theory
 * 300/300 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc13s4
 * @author Tommy Pang
 */
public class CCC13S4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        List<Integer> adj [] = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            adj[x].add(y);
        }
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        boolean [] vis = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(p); vis[p] = true;
        while (!queue.isEmpty()){
            int cur = queue.poll();
            for (int nxt : adj[cur]) {
                if (!vis[nxt]) {
                    queue.add(nxt);
                    vis[nxt] = true;
                }
            }
        }
        if (vis[q]) {
            System.out.println("yes");
        }
        else {
            vis = new boolean[N+1];
            queue = new LinkedList<>();
            queue.add(q); vis[q] = true;
            while (!queue.isEmpty()){
                int cur = queue.poll();
                for (int nxt : adj[cur]) {
                    if (!vis[nxt]) {
                        queue.add(nxt);
                        vis[nxt] = true;
                    }
                }
            }
            if (vis[p]) System.out.println("no");
            else System.out.println("unknown");
        }
    }
}
