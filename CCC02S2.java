import java.util.*;
import java.io.*;
/**
 * CCC '02 S2 - Fraction Action
 * Question type: Simple Math
 * 9/9 on DMOJ
 * @author  Tommy Pang
 */
public class CCC02S2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int numerator = Integer.parseInt(br.readLine());
        int denominator = Integer.parseInt(br.readLine());
        if (numerator == 0) {
            System.out.println(0);
            return;
        }
        if (numerator%denominator == 0) {
            System.out.println(numerator/denominator);
            return;
        }
        if (numerator == denominator){
            System.out.println(1);
        }
        if (numerator > denominator) {
            int integer = numerator/denominator;
            int fra_numerator = numerator - denominator*integer;
            int gcd = gcdByEuclidsAlgorithm(fra_numerator, denominator);
            if (gcd == 1){
                System.out.println(integer + " " + fra_numerator + "/" + denominator);
            }
            else {
                System.out.println(integer + " " + fra_numerator/gcd + "/" + denominator/gcd);
            }
        }
        if (numerator < denominator) {
            int gcd = gcdByEuclidsAlgorithm(numerator, denominator);
            System.out.println(numerator/gcd + "/" + denominator/gcd);
        }
    }
    static int gcdByEuclidsAlgorithm(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }
}
