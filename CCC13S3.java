import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * CCC '13 S3 - Chances of Winning
 * Question type: Recursion
 * 80/80 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc13s3
 * @author Tommy Pang
 */
public class CCC13S3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int [] final_score = new int[6];
    static List<Integer> [] arr = new ArrayList[6];
    static int T = 0, played = 0, cnt = 0;
    static String [] scores = new String[6];
    public static void main(String[] args) throws IOException{
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < 6; i++) {
            arr[i] = new ArrayList<>();
        }
        arr[0].add(1); arr[0].add(2);
        arr[1].add(1); arr[1].add(3);
        arr[2].add(1); arr[2].add(4);
        arr[3].add(2); arr[3].add(3);
        arr[4].add(2); arr[4].add(4);
        arr[5].add(3); arr[5].add(4);
        for (int i = 0; i < 6; i++) {
            scores[i] = "";
        }
        readScore();
        recurse(played);
        System.out.println(cnt);
    }
    static void readScore() throws IOException {
        played = Integer.parseInt(br.readLine());
        for (int i = 0; i < played; i++) {
            String letter;
            st = new StringTokenizer(br.readLine());
            int teamOne = Integer.parseInt(st.nextToken());
            int teamTwo = Integer.parseInt(st.nextToken());
            int scoreOne = Integer.parseInt(st.nextToken());
            int scoreTwo = Integer.parseInt(st.nextToken());
            if (scoreOne>scoreTwo){
                letter = "W";
            }
            else if (scoreTwo>scoreOne){
                letter = "L";
            }
            else {
                letter = "T";
            }
            for (int j = 0; j < 6; j++) {
                if (arr[j].contains(teamTwo) && arr[j].contains(teamOne)){
                    scores[j] = letter;
                }
            }
        }
    }
    static void recurse(int games){
        if (games==6) {
            if (winning(scores)){
                cnt+=1;
            }
            return;
        }
        int idx = -1;
        for (int i = 0; i < 6; i++) {
            if (scores[i].equals("")) {
                idx = i;
                break;
            }
        }
        scores[idx] = "W";
        recurse(games+1);
        scores[idx] = "L";
        recurse(games+1);
        scores[idx] = "T";
        recurse(games+1);
        scores[idx] = "";
    }
    static boolean winning(String [] s){
        final_score = new int[5];
        boolean no_tie = true;
        int max_idx = -1;
        int max = 0;
        for (int i = 0; i < 6; i++) {
            if (s[i].equals("W")){
                final_score[arr[i].get(0)] += 3;
            }
            else if (s[i].equals("L")){
                final_score[arr[i].get(1)] += 3;
            }
            else {
                final_score[arr[i].get(0)] += 1;
                final_score[arr[i].get(1)] += 1;
            }
        }
        for (int i = 0; i < 5; i++) {
            if (final_score[i]>max){
                max_idx = i;
                max = final_score[i];
            }
        }
        for (int i = 0; i < 5; i++) {
            if (i==max_idx) continue;
            if (final_score[max_idx] == final_score[i]) {
                no_tie = false;
                break;
            }
        }
        return (no_tie&&max_idx==T);
    }
}

