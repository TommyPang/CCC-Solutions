import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
/**
 * CCC '21 S3 - Lunch Concert
 * Question type: Data Structures
 * 15/15 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc21s3
 * @author Tommy Pang
 */
public class CCC21S3 {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long [] friend_position, speed, hear_dis;
    static int N;
    public static void main(String[] args) throws IOException {
        long hi = 0, lo = 0;
        getInput();
        if (N==1) {
            System.out.println(0);
            return;
        }
        long [] tempArray = friend_position.clone();
        Arrays.sort(tempArray);
        lo = tempArray[0];
        hi = tempArray[tempArray.length-1];
        while (true) {
            long mid = (lo + hi)/2;
            long ans = check(mid);
            long left = check(mid-1);
            long right = check(mid+1);
            if (ans <= left && ans <= right) {
                System.out.println(ans);
                return;
            }
            if (left > right) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

    }

    private static void getInput() throws IOException {
        N = Integer.parseInt(br.readLine());
        friend_position = new long[N+1]; speed = new long[N+1]; hear_dis = new long[N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            long p = Integer.parseInt(st.nextToken()), s = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());
            friend_position[i] = p;
            speed[i] = s;
            hear_dis[i] = d;
        }
    }

    static long check(long position){
        long ret = 0;
        for (int i = 1; i <= N; i++) {
            long time = 0;
            if (position-friend_position[i]==0) continue;
            if (position>friend_position[i]){
                long temp = position-friend_position[i];
                if (temp<=hear_dis[i]) continue;
                else time = (temp-hear_dis[i])*speed[i];
            }
            else if (position<friend_position[i]){
                long temp = friend_position[i]-position;
                if (temp<=hear_dis[i]) continue;
                else time = (friend_position[i]-position-hear_dis[i])*speed[i];
            }
            ret+=time;
        }
        return ret;
    }

}