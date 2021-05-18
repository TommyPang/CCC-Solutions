import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
/**
 * CCC '06 S3 - Tin Can Telephone
 * Question type: Geometry
 * 4/4 on DMOJ
 * @author Tommy Pang
 */
public class CCC06S3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int cnt = 0, x, y, slope, y_int;
    static boolean horizontal, vertical;
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int jx = Integer.parseInt(st.nextToken());
        int jy = Integer.parseInt(st.nextToken());
        int rx = Integer.parseInt(st.nextToken());
        int ry = Integer.parseInt(st.nextToken());
        if (ry-jy == 0) {
            horizontal = true;
            y = ry;
        }
        else if (rx-jx == 0) {
            vertical = true;
            x = rx;
        }
        else {
            slope = (jy-ry)/(jx-rx);
            y_int = jy - slope*jx;
        }
        int cases = Integer.parseInt(br.readLine());
        for (int i = 0; i < cases; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            Map<Integer, Integer> max_y = new HashMap<>(), min_y = new HashMap<>();
            int x_max = -1, x_min = 100000, y_max = -1, y_min = 100000;
            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (a>x_max){
                    x_max = a;
                }
                else if (a<x_min){
                    x_min = a;
                }
                if (b>y_max){
                    y_max = b;
                }
                else if (b<y_min){
                    y_min = b;
                }
                if (!max_y.containsKey(a)) max_y.put(a, b);
                else {
                    if (b>max_y.get(a)) {
                        max_y.remove(a); max_y.put(a, b);
                    }
                }
                if (!min_y.containsKey(a)) min_y.put(a, b);
                else {
                    if (b<max_y.get(a)){
                        min_y.remove(a); min_y.put(a, b);
                    }
                }
            }
            if (horizontal){
                if (y>=y_min && y<=y_max){
                    cnt+=1;
                }
            }
            else if (vertical){
                if (x>=x_min && x<=x_max){
                    cnt+=1;
                }
            }
            else {
                for (int j = -1000; j <= 1000; j++) {
                    int ans = slope*j+y_int;
                    if (min_y.containsKey(j) && max_y.containsKey(j)) {
                        if (ans >= min_y.get(j) && ans <= max_y.get(j)) {
                            cnt += 1;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
