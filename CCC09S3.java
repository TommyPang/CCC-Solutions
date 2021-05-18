import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * CCC '09 S3 - Degrees Of Separation
 * Question type: Graph Theory
 * 4/4 on DMOJ
 * @author Tommy Pang
 */
public class CCC09S3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        List<Integer> [] adj = new ArrayList[51];
        for (int i = 1; i < 51; i++) {
            adj[i] = new ArrayList<>();
        }
        adj[1].add(6); adj[6].add(1); adj[2].add(6); adj[6].add(2);
        adj[3].add(6); adj[6].add(3); adj[7].add(6); adj[6].add(7);
        adj[4].add(6); adj[6].add(4); adj[5].add(6); adj[6].add(5);
        adj[4].add(3); adj[3].add(4); adj[5].add(4); adj[4].add(5);
        adj[5].add(3); adj[3].add(5); adj[3].add(15); adj[15].add(3);
        adj[7].add(8); adj[8].add(7); adj[8].add(9); adj[9].add(8);
        adj[10].add(9); adj[9].add(10); adj[10].add(11); adj[11].add(10);
        adj[11].add(12); adj[12].add(11); adj[13].add(12); adj[12].add(13);
        adj[13].add(15); adj[15].add(13); adj[13].add(14); adj[14].add(13);
        adj[16].add(17); adj[17].add(16); adj[17].add(18); adj[18].add(17);
        adj[16].add(18); adj[18].add(16); adj[12].add(9); adj[9].add(12);
        while (true) {
            String operation = br.readLine();
            switch (operation) {
                case "q":
                    return;
                case "i":
                    int a = Integer.parseInt(br.readLine());
                    int b = Integer.parseInt(br.readLine());
                    if (!adj[a].contains(b)) {
                        adj[a].add(b);
                        adj[b].add(a);
                    }
                    break;
                case "d":
                    a = Integer.parseInt(br.readLine());
                    b = Integer.parseInt(br.readLine());
                    for (int i = 0; i < adj[a].size(); i++) {
                        if (adj[a].get(i) == b) {
                            adj[a].remove(i);
                            break;
                        }
                    }
                    for (int i = 0; i < adj[b].size(); i++) {
                        if (adj[b].get(i) == a) {
                            adj[b].remove(i);
                            break;
                        }
                    }
                    break;
                case "n":
                    int n = Integer.parseInt(br.readLine());
                    System.out.println(adj[n].size());
                    break;
                case "f":
                    int x = Integer.parseInt(br.readLine());
                    List<Integer> ans = new ArrayList<>(), friends = new ArrayList<>();
                    Queue<Integer> queue = new LinkedList<>();
                    friends.add(x);
                    for (int i = 0; i < adj[x].size(); i++) {
                        queue.add(adj[x].get(i));
                        friends.add(adj[x].get(i));
                    }
                    while (!queue.isEmpty()) {
                        int cur = queue.poll();
                        for (int nxt : adj[cur]) {
                            if (!ans.contains(nxt) && !friends.contains(nxt)) ans.add(nxt);
                        }
                    }
                    System.out.println(ans.size());
                    break;
                case "s":
                    a = Integer.parseInt(br.readLine());
                    b = Integer.parseInt(br.readLine());
                    int[] dis = new int[51];
                    boolean[] vis = new boolean[51];
                    vis[a] = true;
                    dis[a] = 0;
                    queue = new LinkedList<>();
                    queue.add(a);
                    while (!queue.isEmpty()) {
                        int cur = queue.poll();
                        for (int nxt : adj[cur]) {
                            if (!vis[nxt]) {
                                queue.add(nxt);
                                vis[nxt] = true;
                                dis[nxt] = dis[cur] + 1;
                            }
                        }
                    }
                    if (!vis[b]) System.out.println("Not connected");
                    else System.out.println(dis[b]);
            }
        }
    }
}
