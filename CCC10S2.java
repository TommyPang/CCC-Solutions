import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * CCC '10 S2 - Huffman Encoding
 * Question type: String Algorithms
 * 6/6 on DMOJ
 * @author Tommy Pang
 */
public class CCC10S2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Map<String, String> map = new HashMap<>();
    static int[] binary_length;
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        binary_length = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String letter = st.nextToken(), binary = st.nextToken();
            binary_length[i] = binary.length();
            map.put(binary, letter);
        }
        Arrays.sort(binary_length);
        String code = br.readLine();
        int i = 0;
        StringBuilder ans = new StringBuilder();
        while (true){
            try {
                for (int nxt : binary_length) {
                    String sub = code.substring(i, i+nxt);
                    if (map.containsKey(sub)) {
                        ans.append(map.get(sub));
                        i += nxt;
                        break;
                    }
                }

            }
            catch (StringIndexOutOfBoundsException e){
                System.out.println(ans);
                return;
            }
        }
    }

}
