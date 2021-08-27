import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * CCC '21 S4 - Daily Commute
 * Question type: Graph Theory
 * 2/15 on DMOJ, TLE on Batch 3-5
 * Question URL: https://dmoj.ca/problem/ccc21s4
 * @author Tommy Pang
 */
public class CCC21S4 {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer>[] walkWay;
    static int N, W, D;
    static int ans = 0;
    static int[] route;
    static boolean[] vis;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        route = new int[N + 1];
        walkWay = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            walkWay[i] = new ArrayList<>();
        }
        for (int i = 0; i < W; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            walkWay[a].add(b);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int v = Integer.parseInt(st.nextToken());
            route[i] = v;
            map.put(v, i);
        }
        //System.out.println();
        for (int i = 0; i < D; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            int tempA = route[a], tempB = route[b];
            route[b] = tempA;
            route[a] = tempB;
            ans = Integer.MAX_VALUE;
            vis = new boolean[N + 1];
            vis[1] = true;
            recursive(1, 0, 1);
            System.out.println(ans);
        }
    }

    static void recursive(int cur, int time, int bus_time) {
        if (cur == N) {
            ans = Math.min(ans, time);
            return;
        }
        for (int i = 0; i <= 1; i++) {
            if (i == 0) {
                if (bus_time <= N && route[bus_time] == cur) {
                    if (bus_time + 1 <= N) {
                        recursive(route[bus_time + 1], time + 1, bus_time + 1);
                    }
                } else {
                    if (map.get(cur) > bus_time) recursive(cur, time + 1, bus_time + 1);
                    else {
                        for (int k = 0; k < walkWay[cur].size(); k++) {
                            if (!vis[walkWay[cur].get(k)]) {
                                vis[walkWay[cur].get(k)] = true;
                                recursive(walkWay[cur].get(k), time + 1, bus_time + 1);
                                vis[walkWay[cur].get(k)] = false;
                            }
                        }
                    }
                }
            }
            if (i == 1) {
                for (int j = 0; j < walkWay[cur].size(); j++) {
                    if (!vis[walkWay[cur].get(j)]) {
                        vis[walkWay[cur].get(j)] = true;
                        recursive(walkWay[cur].get(j), time + 1, bus_time + 1);
                        vis[walkWay[cur].get(j)] = false;
                    }
                }
            }
        }
    }
}