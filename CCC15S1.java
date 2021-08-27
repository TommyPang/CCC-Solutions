import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/**
 * CCC '15 S1 - Zero That Out
 * Question URL: Implementation
 * 15/15 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc15s1
 * @author Tommy Pang
 */
public class CCC15S1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num==0) {
                list.remove(list.size()-1);
                continue;
            }
            list.add(num);
        }
        int total = 0;
        for (int i = 0; i < list.size(); i++) {
            total+=list.get(i);
        }
        System.out.println(total);
    }
}
