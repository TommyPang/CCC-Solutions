import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
/**
 * CCC '06 S2 - Attack of the CipherTexts
 * Question type: Implementation
 * 5/5 on DMOJ
 * @author Tommy Pang
 */
public class CCC06S2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Map<String, String> map = new HashMap<>();
    public static void main(String[] args) throws IOException{
        String plaintext  = br.readLine();
        String ciphertext = br.readLine();
        String outputText = br.readLine();
        for (int i = 0; i < plaintext.length(); i++) {
            String plainChar = String.valueOf(plaintext.charAt(i));
            String cipherChar = String.valueOf(ciphertext.charAt(i));
            if (!map.containsKey(cipherChar)){
                map.put(cipherChar, plainChar);
            }
        }
        String ans = "";
        for (int i = 0; i < outputText.length(); i++) {
            ans += map.getOrDefault(String.valueOf(outputText.charAt(i)), ".");
        }
        System.out.println(ans);
    }
}
