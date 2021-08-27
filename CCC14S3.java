import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * CCC '14 S3 - The Geneva Confection
 * Question type: Implementation
 * 500/500 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc14s3
 * @author Tommy Pang
 */
public class CCC14S3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            List<Integer> ingredients = new ArrayList<>();
            List<Integer> branch = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                ingredients.add(Integer.parseInt(br.readLine()));
            }
            int idx = 1;
            int in_size = ingredients.size()-1;
            int br_size = -1;
            while (true){
                if (idx==N+1) {
                    System.out.println("Y");
                    break;
                }
                if (in_size==-1){
                    if (branch.get(br_size) != idx){
                        System.out.println("N");
                        break;
                    }
                    else {
                        branch.remove(br_size);
                        idx+=1;
                        br_size-=1;
                        continue;
                    }
                }
                if (ingredients.get(in_size) != idx) {
                    if (br_size!=-1 && branch.get(br_size) == idx){
                        idx+=1;
                        branch.remove(br_size);
                        br_size-=1;
                    }
                    else {
                        branch.add(ingredients.get(in_size));
                        br_size+=1;
                        ingredients.remove(in_size);
                        in_size-=1;
                    }
                }
                else {
                    idx+=1;
                    ingredients.remove(in_size);
                    in_size-=1;
                }


            }
        }
    }
}
