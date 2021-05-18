import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * CCC '09 S4 - Shop and Ship
 * Question type: Graph Theory
 * 5/5 on DMOJ
 * @author Tommy Pang
 */
public class CCC09S4_NaiveWay {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //Naive(N^2) way
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine()), t = Integer.parseInt(br.readLine());
        int [][]  adj = new int [n+1][n+1];
        for (int i=0; i<=n; i++) Arrays.fill(adj[i], Integer.MAX_VALUE/2);
        for (int i = 1; i <=t; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken());
            adj[u][v] =  adj[v][u] =  w;
        }
        int k = Integer.parseInt(br.readLine()), store [] = new int [k];
        int[] cost = new int [k];
        for (int i = 0; i < k;i++) {
            st = new StringTokenizer(br.readLine());
            store[i] = Integer.parseInt(st.nextToken()); cost[i] =  Integer.parseInt(st.nextToken());
        }
        int dest = Integer.parseInt(br.readLine()), dis []= new int [n+1]; boolean vis[] =  new boolean[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE/2); dis[dest] = 0;
        for (int i = 1; i <=n; i++) {
            int min = Integer.MAX_VALUE, u = -1;
            for (int a = 1; a <=n; a++) {
                if(!vis[a]&&dis[a] <min) {
                    min = dis[a];
                    u = a;
                }
            }
            if (u == -1) break;
            vis[u] = true;
            for (int v = 1; v<=n; v++) {
                if(dis[v] > dis[u] + adj[u][v]) dis [v] = dis[u] + adj[u][v];
            }
        }
        int sol = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            sol = Math.min(sol, dis[store[i]]+cost[i]);
        }
        System.out.println(sol);
    }

}
