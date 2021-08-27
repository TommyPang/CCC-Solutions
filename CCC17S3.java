import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * CCC '17 S3 - Nailed It!
 * Question type: Simple Math
 * 15/15 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc17s3
 * @author Rivers47 on GitHub
 */
public class CCC17S3 {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, fence_length, height_cnt;
    static int[] woods = new int[2001], res_length = new int[4001];
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            woods[Integer.parseInt(st.nextToken())] += 1;
        }
        cnt();
        search();
        System.out.println(fence_length + " " + height_cnt);
    }
    static void cnt(){
        for (int i = 1; i <= 2000; i++) {
            if (woods[i]!=0){
                if (woods[i]>1){
                    res_length[i*2]+=woods[i]/2;
                }
                for (int j = i+1; j <= 2000; j++) {
                    if (woods[j]!=0) res_length[i+j] += Math.min(woods[i], woods[j]);
                }
            }
        }
    }
    static void search(){
        fence_length = 1; height_cnt = 0;
        for (int i = 1; i <= 4000; i++) {
            if (res_length[i]>fence_length){
                fence_length = res_length[i];
                height_cnt = 1;
            }
            else if (res_length[i] == fence_length){
                height_cnt+=1;
            }
        }
    }
}
/*
TLE 5/15 on CCC
public class CCC17S3 {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, fence_length, board_height;
    static int[] woods;
    static boolean [] vis;
    static ArrayList<Integer> heights = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        woods = new int[N+1]; vis = new boolean[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            woods[i] = (Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(woods);
        fence_length = 1;
        board_height = 1;
        int ans = 0;
        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (!vis[i] && !vis[j]) {
                    vis[i] = true; vis[j] = true;
                    check(woods[i] + woods[j]);
                    if (ans<fence_length) {
                        heights.clear();
                        board_height = 1;
                        heights.add(woods[i] + woods[j]);
                    }
                    else if (ans==fence_length && !heights.contains(woods[i] + woods[j])) {
                        board_height+=1; heights.add(woods[i] + woods[j]);
                    }
                    ans = Math.max(ans, fence_length);
                    fence_length = 1;
                    vis = new boolean[N+1];
                }
            }
        }
        System.out.println(ans + " "+ board_height);
    }
    static void check(int t){
        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (woods[i] + woods[j] == t && !vis[i] && !vis[j]) {
                    fence_length+=1;
                    vis[i] = true; vis[j] = true;
                }
            }
        }
    }
}

 */
