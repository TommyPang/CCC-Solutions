import java.util.*;
import java.io.*;
/**
 * CCC '01 S3 - Strategic Bombing
 * Question type: Graph Theory
 * 5/5 on DMOJ
 * @author  Tommy Pang
 */
public class CCC01S3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<String>[] adj = new ArrayList[28];
    static int cnt = 0;
    static Map<String, Integer> map = new HashMap<>();
    static boolean [] visited = new boolean[30];
    static List<String> [] roads = new ArrayList[200];
    static int total = 0;
    public static void main(String[] args) throws IOException {
        map.put("A", 1);map.put("B", 2);map.put("C", 3);map.put("D", 4);map.put("E", 5);map.put("F", 6);map.put("G", 7);
        map.put("H", 8);map.put("I", 9);map.put("J", 10);map.put("K", 11);map.put("L", 12);map.put("M", 13);map.put("N", 14);
        map.put("O", 15);map.put("P", 16);map.put("Q", 17);map.put("R", 18);map.put("S", 19);map.put("T", 20);map.put("U", 21);
        map.put("V", 22);map.put("W", 23);map.put("X", 24);map.put("Y", 25);map.put("Z", 26);
        for (int i = 0; i <= 27; i++) {adj[i] = new ArrayList<>(); }
        for (int i = 0; i <= 199; i++) {roads[i] = new ArrayList<>(); }
        while(true){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            if (line.equals("**")) break;
            String a = String.valueOf(line.charAt(0));
            String b = String.valueOf(line.charAt(1));
            adj[map.get(a)].add(b); adj[map.get(b)].add(a);
            roads[cnt].add(a); roads[cnt].add(b);
            cnt+=1;
        }
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < cnt; i++) {
            queue.add("A"); visited[1] = true;
            while (!queue.isEmpty()){
                String cur = queue.poll();
                for (String nxt : adj[map.get(cur)]) {
                    if (roads[i].contains(cur) && roads[i].contains(nxt));
                    else {
                        if (!visited[map.get(nxt)]) {
                            queue.add(nxt);
                            visited[map.get(nxt)] = true;
                        }
                    }
                }
            }
            if (!visited[map.get("B")]) {
                for (String v : roads[i]) {
                    System.out.print(v);
                }
                System.out.println();
                total+=1;
            }
            Arrays.fill(visited, false);
        }
        System.out.print("There are " + total+" disconnecting roads.\n");
    }
}
