import java.io.*;
import java.util.*;
/**
 * CCC '12 S4 - A Coin Game
 * Question type: Graph Theory
 * 50/50 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc12s4
 * @author Tommy Pang
 */
public class CCC12S4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7, n;
    static Map<String, String> vis;
    public static void main(String[] args) throws IOException {
        n = readInt();
        do {
            vis = new HashMap<>();
            List<Integer> [] table = new List[n];
            for (int i = 0; i < n; i++) {
                table[i] = new ArrayList<>();
                table[i].add(readInt());
            }
            int ans = BFS(table);
            System.out.println(ans==-1 ? "IMPOSSIBLE" : ans);
            n = readInt();
        }
        while (n!=0);
    }
    public static int BFS(List<Integer> [] list) {
        Queue<List<Integer> []> queue = new LinkedList<>();
        Queue<Integer> dis = new LinkedList<>();
        dis.add(0);
        queue.add(list);
        while (!queue.isEmpty()) {
            List<Integer> [] cur = queue.poll();
            int d = dis.poll();
            if (finished(cur)) return d;

            for (int i = 0; i < n-1; i++) {
                if (cur[i].size()==0) continue;
                List<Integer> [] nxt = clone(cur);
                if (nxt[i].get(0)<(nxt[i+1].size()==0?Integer.MAX_VALUE:nxt[i+1].get(0))) {
                    nxt[i+1].add(0, nxt[i].remove(0));
                    if (!visited(nxt)) {
                        queue.add(nxt);
                        dis.add(d+1);
                    }
                }
            }

            for (int i = n-1; i > 0; i--) {
                if (cur[i].size()==0) continue;
                List<Integer> [] nxt = clone(cur);
                if (nxt[i].get(0)<(nxt[i-1].size()==0?Integer.MAX_VALUE:nxt[i-1].get(0))) {
                    nxt[i-1].add(0, nxt[i].remove(0));
                    if (!visited(nxt)) {
                        queue.add(nxt);
                        dis.add(d+1);
                    }
                }
            }
        }
        return -1;
    }
    public static boolean visited(List<Integer> [] table) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            List<Integer> col = table[i];
            for (int nxt : col) {
                sb.append(nxt);
            }
            if (i!=n-1) sb.append("-");
        }
        if (!vis.containsKey(sb.toString())) {
            vis.put(sb.toString(), sb.toString());
            return false;
        }
        else return true;
    }
    public static boolean finished(List<Integer> [] table) {
        for (int i = 0; i < n; i++) {
            if (table[i].size()!=1) return false;
            else if (table[i].get(0)!=i+1) return false;
        }
        return true;
    }
    public static List<Integer> [] clone(List<Integer> [] table) {
        List<Integer> [] ret = new List[table.length];
        for (int i = 0; i < table.length; i++) {
            ret[i] = new ArrayList<>(table[i]);
        }
        return ret;
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong() throws IOException {
        return Long.parseLong(next());
    }
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
}
