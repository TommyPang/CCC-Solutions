import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
/**
 * CCC '18 S5 - Maximum Strategic Savings
 * Question type: Graph Theory
 * 2/15 on DMOJ, TLE / WA on Batch 3-5
 * Question URL: https://dmoj.ca/problem/ccc18s5
 * @author Tommy Pang
 */
public class CCC18S5 {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, P, Q;
    static List<edge> list = new ArrayList<>();
    static long total, ans;
    static List<node> [][] adj;
    static int [][] vis;
    static boolean notCyclic = true;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken()); Q = Integer.parseInt(st.nextToken());
        adj = new ArrayList[M+1][M+1]; vis = new int[M+1][M+1];
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            total+=(long)c*(long)N;
            for (int j = 1; j <= N; j++) {
                node begin = new node(j, a);
                node end = new node(j, b);
                if (a==b) break;
                list.add(new edge(begin, end, c));
            }
        }
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int planetA = Integer.parseInt(st.nextToken()), planetB = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            total+=(long)M*(long)c;
            for (int j = 1; j <= M; j++) {
                node begin = new node(planetA, j);
                node end = new node(planetB, j);
                if (planetA==planetB) break;
                list.add(new edge(begin, end, c));
            }
        }
        Collections.sort(list);
        MST();
        System.out.println(total-ans);
    }
    static void MST(){
        long V = 0;
        for (int i = 0; i < M+1; i++) {
            for (int j = 0; j < M+1; j++) {
                adj[i][j] = new ArrayList<>();
            }
        }
        for (edge e : list) {
            vis = new int[M+1][M+1];
            notCyclic = true;
            adj[e.a.planet][e.a.city].add(e.b);
            adj[e.b.planet][e.b.city].add(e.a);
            if (notCyclic(e.a, e.a, e.a)){
                V+=1;
                ans += e.v;
            }
            else {
                adj[e.a.planet][e.a.city].remove(e.b);
                adj[e.b.planet][e.b.city].remove(e.a);
            }
            if (V==(long)N*(long)M-1) break;
        }
    }
    static boolean notCyclic(node cur, node pre, node start){
        if (!notCyclic) return false;
        vis[cur.planet][cur.city] = 1;
        for (node n : adj[cur.planet][cur.city]) {
            if (vis[n.planet][n.city]==1 && n.planet != pre.planet && n.city != pre.city && n.planet == start.planet && n.city == start.city){
                notCyclic = false;
                return false;
            }
            else if (vis[n.planet][n.city]==0) return notCyclic(n, cur, start);
        }
        vis[cur.planet][cur.city] = 2;
        return true;
    }
    static class node{
        int planet; int city;
        node(int p, int c){
            planet = p; city = c;
        }
    }
    static class edge implements Comparable<edge>{
        long v;
        node a, b;
        edge(node begin, node end, int cost){
            a = begin; b = end; v = cost;
        }

        @Override
        public int compareTo(edge o) {
            return Long.compare(v, o.v);
        }

    }
}
