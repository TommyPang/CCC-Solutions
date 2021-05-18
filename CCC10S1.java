import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * CCC '10 S1 - Computer Purchase
 * Question type: Simple Math
 * 9/9 on DMOJ
 * @author Tommy Pang
 */
public class CCC10S1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer> first = new ArrayList<>(), second = new ArrayList<>();
    static Map<Integer, String> name = new HashMap<>();
    static Map<String, Integer> price = new HashMap<>();
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        if (N==1) {
            st = new StringTokenizer(br.readLine());
            System.out.println(st.nextToken());
            return;
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int R = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            name.put(i, s);
            price.put(s, 2*R + 3*S + D);
        }
        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(price.get(name.get(i)), max);
        }
        for (int i = 1; i <= N; i++) {
            if (price.get(name.get(i))==max) first.add(i);
        }
        int max2 = 0;
        for (int i = 1; i <= N; i++) {
            if (price.get(name.get(i))==max) continue;
            max2 = Math.max(max2, price.get(name.get(i)));
        }
        for (int i = 1; i <= N; i++) {
            if (price.get(name.get(i))==max2) second.add(i);
        }
        if (first.size()==1) {
            System.out.println(name.get(first.get(0)));
            if (second.size() == 1) {
                System.out.println(name.get(second.get(0)));
            }
            else {
                String ans = "";
                int c = 1000000;
                for (Integer integer : second) {
                    if (name.get(integer).charAt(0) - 'A' < c) {
                        ans = name.get(integer);
                        c = name.get(integer).charAt(0) - 'A';
                    }
                }
                System.out.println(ans);
            }
        }
        else {
            String ans1 = "";
            int c = 1000000;
            for (Integer integer : first) {
                if (name.get(integer).charAt(0) - 'A' < c) {
                    ans1 = name.get(integer);
                    c = name.get(integer).charAt(0) - 'A';
                }
            }
            System.out.println(ans1);
            c = 1000000;
            String ans2 = "";
            for (int nxt : first) {
                if (!name.get(nxt).equals(ans1) && name.get(nxt).charAt(0) - 'A' < c) {
                    ans2 = name.get(nxt); c = name.get(nxt).charAt(0) - 'A';
                }
            }
            System.out.println(ans2);
        }

    }
}
