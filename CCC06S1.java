import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * CCC '06 S1 - Maternity
 * Question type: Implementation
 * 3/3 on DMOJ
 * @author Tommy Pang
 */
public class CCC06S1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String mother, farther;
    public static void main(String[] args) throws IOException {
        mother = br.readLine();
        farther = br.readLine();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            evaluate(mother, farther, s);
        }
    }
    static void evaluate(String a, String b, String s){
        for (int i = 0; i < 5; i++) {
            switch (s.charAt(i)){
                case 'A':
                    if (!a.contains("A") && !b.contains("A")){
                        System.out.println("Not their baby!");
                        return;
                    }
                    break;
                case 'a':
                    if (!check(s, "a")) {
                        System.out.println("Not their baby!");
                        return;
                    }
                    break;
                case 'B':
                    if (!a.contains("B") && !b.contains("B")){
                        System.out.println("Not their baby!");
                        return;
                    }
                    break;
                case 'b':
                    if (!check(s, "b")) {
                        System.out.println("Not their baby!");
                        return;
                    }
                    break;
                case 'C':
                    if (!a.contains("C") && !b.contains("C")){
                        System.out.println("Not their baby!");
                        return;
                    }
                    break;
                case 'c':
                    if (!check(s, "c")) {
                        System.out.println("Not their baby!");
                        return;
                    }
                    break;
                case 'D':
                    if (!a.contains("D") && !b.contains("D")){
                        System.out.println("Not their baby!");
                        return;
                    }
                    break;
                case 'd':
                    if (!check(s, "d")) {
                        System.out.println("Not their baby!");
                        return;
                    }
                    break;
                case 'E':
                    if (!a.contains("E") && !b.contains("E")){
                        System.out.println("Not their baby!");
                        return;
                    }
                    break;
                case 'e':
                    if (!check(s, "e")) {
                        System.out.println("Not their baby!");
                        return;
                    }
                    break;
            }
        }
        System.out.println("Possible baby.");
    }
    static boolean check(String s, String letter){
        return mother.contains(letter) && farther.contains(letter);
    }
}