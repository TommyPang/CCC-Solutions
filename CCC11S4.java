import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * CCC '11 S4 - Blood Distribution
 * Question type: Greedy Algorithms
 * 50/50 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc11s4
 * @author Tommy Pang
 */
public class CCC11S4 {
    static StringTokenizer st1, st2;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int [] blood_negative = new int[4], blood_positive = new int[4];
    static int [] requirements_negative = new int[4], requirements_positive = new int[4];
    public static void main(String[] args) throws IOException {
        st1 = new StringTokenizer(br.readLine());
        st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i+=1) {
            blood_negative[i] = Integer.parseInt(st1.nextToken());
            blood_positive[i] = Integer.parseInt(st1.nextToken());
            requirements_negative[i] = Integer.parseInt(st2.nextToken());
            requirements_positive[i] = Integer.parseInt(st2.nextToken());
        }
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            if (blood_negative[i]>=requirements_negative[i]){
                ans+=requirements_negative[i];
                blood_negative[i]-=requirements_negative[i];
                requirements_negative[i] = 0;
            }
            else {
                for (int j = i; j >= 0; j--) {
                    if (i==2 && j==1) continue;
                    if (requirements_negative[i] == 0) break;
                    if (blood_negative[j]<requirements_negative[i]){
                        ans+=blood_negative[j];
                        requirements_negative[i]-=blood_negative[j];
                        blood_negative[j] = 0;
                    }
                    else {
                        ans+=requirements_negative[i];
                        blood_negative[j] -= requirements_negative[i];
                        requirements_negative[i] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            if (blood_positive[i]>=requirements_positive[i]){
                ans+=requirements_positive[i];
                blood_positive[i]-=requirements_positive[i];
                requirements_positive[i] = 0;
            }
            else {
                for (int j = i; j >= 0; j--) {
                    if (i==2 && j==1) continue;
                    if (requirements_positive[i] == 0) break;
                    if (blood_positive[j]<requirements_positive[i]){
                        ans+=blood_positive[j];
                        requirements_positive[i]-=blood_positive[j];
                        blood_positive[j] = 0;
                    }
                    else {
                        ans+=requirements_positive[i];
                        blood_positive[j]-=requirements_positive[i];
                        requirements_positive[i]=0;
                    }

                    if (requirements_positive[i]>0) {
                        if (blood_negative[j] < requirements_positive[i]) {
                            ans += blood_negative[j];
                            requirements_positive[i] -= blood_negative[j];
                            blood_negative[j] = 0;
                        }
                        else {
                            ans += requirements_positive[i];
                            blood_negative[j] -= requirements_positive[i];
                            requirements_positive[i] = 0;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
