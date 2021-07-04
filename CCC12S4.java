import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * CCC '12 S4 - A Coin Game
 * Question type: Graph Theory
 * 30/50 on DMOJ, case 4, 5 tle
 * Question URL: https://dmoj.ca/problem/ccc12s4
 * @author Tommy Pang
 */
public class CCC12S4 {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer> [] states;
    static List<List<Integer> []> vis;
    static int N;
    public static void main(String[] args) throws IOException {
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N==0) return;
            st = new StringTokenizer(br.readLine());
            states = new ArrayList[N + 1];
            vis = new ArrayList<>();
            for (int i = 0; i < N + 1; i++) {
                states[i] = new ArrayList<>();
            }
            for (int i = 1; i <= N; i++) {
                int v = Integer.parseInt(st.nextToken());
                states[i].add(v);
            }
            BFS();
        }
    }
    static void BFS(){
        Queue<List<Integer> []> queue = new LinkedList<>();
        Queue<Integer> steps = new LinkedList<>();
        queue.add(create_list(states)); steps.add(0);
        vis.add(states);
        while (!queue.isEmpty()){
            List<Integer> [] cur = queue.poll();
            int step_num = steps.poll();
            if (finished(create_list(cur))) {
                System.out.println(step_num);
                return;
            }
            for (int i = 1; i <= N; i++) {
                if (i-1!=0 && cur[i-1].size()==0 && !(cur[i].size()==0)){
                    cur[i-1] = new ArrayList<>();
                    int v = cur[i].get(0);
                    cur[i-1].add(0, v);
                    cur[i].remove(0);
                    if (!visited(cur)){
                        queue.add(create_list(cur)); vis.add(create_list(cur));
                        steps.add(step_num+1);
                    }
                    cur[i-1].remove(0);
                    if (cur[i].size()==0) cur[i] = new ArrayList<>();
                    cur[i].add(0, v);
                }
                if (i+1<=N && cur[i+1].size()==0 && !(cur[i].size()==0)){
                    cur[i+1] = new ArrayList<>();
                    int v = cur[i].get(0);
                    cur[i+1].add(0, v);
                    cur[i].remove(0);
                    if (!visited(cur)){
                        queue.add(create_list(cur)); vis.add(create_list(cur));
                        steps.add(step_num+1);
                    }
                    cur[i+1].remove(0);
                    if (cur[i].size()==0) cur[i] = new ArrayList<>();
                    cur[i].add(0, v);
                }
                if (i-1!=0 && !(cur[i-1].size()==0) && !(cur[i].size()==0) && cur[i-1].get(0)>cur[i].get(0)){
                    int v = cur[i].get(0);
                    cur[i-1].add(0, v);
                    cur[i].remove(0);
                    if (!visited(cur)){
                        queue.add(create_list(cur)); vis.add(create_list(cur));
                        steps.add(step_num+1);
                    }
                    if (cur[i].size()==0) cur[i] = new ArrayList<>();
                    cur[i].add(0, v);
                    cur[i-1].remove(0);
                }
                if (i+1<=N && !(cur[i+1].size()==0) && !(cur[i].size()==0) && cur[i+1].get(0)>cur[i].get(0)){
                    int v = cur[i].get(0);
                    cur[i+1].add(0, v);
                    cur[i].remove(0);
                    if (!visited(cur)){
                        queue.add(create_list(cur)); vis.add(create_list(cur));
                        steps.add(step_num+1);
                    }
                    if (cur[i].size()==0) cur[i] = new ArrayList<>();
                    cur[i].add(0, v);
                    cur[i+1].remove(0);
                }
            }

        }
        System.out.println("IMPOSSIBLE");
    }
    static boolean visited(List<Integer> [] cur){
        for (List<Integer> [] nxt : vis) {
            boolean same = true;
            for (int i = 1; i <= N; i++) {
                if (nxt[i].size()!=cur[i].size()) same = false;
                else {
                    for (int j = 0; j < nxt[i].size(); j++) {
                        if (!nxt[i].get(j).equals(cur[i].get(j))) same = false;
                    }
                }
            }
            if (same) return true;
        }
        return false;

    }
    static boolean finished(List<Integer> [] cur){
        for (int i = 1; i <= N; i++) {
            if (cur[i].size()==0) return false;
            if (!(cur[i].get(0)==i)) return false;
        }
        return true;
    }
    static List<Integer> [] create_list(List<Integer> [] cur){
        List<Integer> [] temp = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            temp[i] = new ArrayList<>();
        }
        for (int i = 1; i < N+1; i++) {
            if (!(cur[i].size()==0)){
                for (int j = 0; j < cur[i].size(); j++) {
                    temp[i].add(cur[i].get(j));
                }
            }
        }
        return temp;
    }
}