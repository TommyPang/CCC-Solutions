import java.util.*;
import java.io.*;
/**
 * CCC '01 S1 - Keeping Score
 * Question type: Implementation
 * 4/4 on DMOJ
 * @author  Tommy Pang
 */
public class CCC01S1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Map<String, Integer> map = new HashMap<>();
    static List<String> C = new ArrayList<>(), D = new ArrayList<>(), H = new ArrayList<>(), S = new ArrayList<>();
    static int c = 0, d = 0, h = 0, s = 0, total = 0, cnt = 0;
    public static void main(String[] args) throws IOException {
        map.put("A", 4); map.put("K", 3); map.put("Q", 2); map.put("J", 1);
        String line = br.readLine();
        total=0;
        while (true){
            for (int i = 1; i < line.length(); i++) {
                if (String.valueOf(line.charAt(i)).equals("D")) {
                    break;
                }
                cnt+=1; total+=1;
                C.add(String.valueOf(line.charAt(i)));
                if (map.containsKey(String.valueOf(line.charAt(i)))) c+=map.get(String.valueOf(line.charAt(i)));
            }
            break;
        }
        c+=compare(cnt);
        cnt=0;
        while (true){
            for (int i = total+1; i < line.length(); i++) {
                if (String.valueOf(line.charAt(i)).equals("H")) {
                    break;
                }
                if(!String.valueOf(line.charAt(i)).equals("D")) {
                    D.add(String.valueOf(line.charAt(i)));
                    cnt+=1;
                }
                if (map.containsKey(String.valueOf(line.charAt(i)))) d+=map.get(String.valueOf(line.charAt(i)));
                total+=1;
            }
            break;
        }
        d+=compare(cnt);
        cnt=0;

        while (true){
            for (int i = total+1; i < line.length(); i++) {
                if (String.valueOf(line.charAt(i)).equals("S")) {
                    break;
                }
                if(!String.valueOf(line.charAt(i)).equals("H")) {
                    H.add(String.valueOf(line.charAt(i)));
                    cnt+=1;
                }
                if (map.containsKey(String.valueOf(line.charAt(i)))) h+=map.get(String.valueOf(line.charAt(i)));
                total+=1;
            }
            break;
        }
        h+=compare(cnt);
        cnt=0;
        while (true){
            for (int i = total+1; i < line.length(); i++) {
                if (String.valueOf(line.charAt(i)).equals("S"));
                else {
                    S.add(String.valueOf(line.charAt(i)));
                    cnt += 1;
                    if (map.containsKey(String.valueOf(line.charAt(i)))) s += map.get(String.valueOf(line.charAt(i)));
                    total += 1;
                }
            }
            break;
        }
        s+=compare(cnt);
        cnt=0;
        System.out.println("Cards Dealt              Points");
        System.out.print("Clubs ");
        for (String nxt : C) {if(!(nxt==null)) System.out.print(nxt + " "); }
        System.out.print("         "+c+"\n");
        System.out.print("Diamonds ");
        for (String nxt : D) {if(!(nxt==null)) System.out.print(nxt + " "); }
        System.out.print("         "+d+"\n");
        System.out.print("Hearts ");
        for (String nxt : H) {if(!(nxt==null)) System.out.print(nxt + " "); }
        System.out.print("         "+h+"\n");
        System.out.print("Spades ");
        for (String nxt : S) {if(!(nxt==null)) System.out.print(nxt + " "); }
        System.out.print("         "+s+"\n");
        total = c+d+h+s;
        System.out.println("                           Total " +total);
    }

    static int compare(int cnt){
        switch (cnt){
            case 0:
                return 3;
            case 1:
                return 2;
            case 2:
                return 1;
        }
        return 0;
    }
}
