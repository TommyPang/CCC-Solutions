import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * CCC '18 S3 - RoboThieves
 * Question type: Graph Theory
 * 10/15 on DMOJ, TLE on Batch 5
 * Question URL: https://dmoj.ca/problem/ccc18s3
 * @author Tommy Pang
 */
public class CCC18S3 {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String [][] layout;
    static boolean [][] cameraArea;
    static List<Integer> destR = new ArrayList<>(), destC = new ArrayList<>(), CamR = new ArrayList<>(), CamC = new ArrayList<>();
    static int startR, startC, r, c;
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        layout = new String[r][c];
        cameraArea = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < c; j++) {
                String s = String.valueOf(line.charAt(j));
                if (s.equals("S")) {
                    startR = i;
                    startC = j;
                }
                else if (s.equals(".")) {
                    destR.add(i);
                    destC.add(j);
                }
                else if (s.equals("C")) {
                    CamR.add(i); CamC.add(j);
                }
                layout[i][j] = s;
            }
        }
        FindCameraArea();
        BFSOutPut();
    }

    static void BFSOutPut(){
        Queue<Integer> qr = new LinkedList<>();
        Queue<Integer> qc = new LinkedList<>();
        boolean [][] vis = new boolean[r][c];
        if (cameraArea[startR][startC]) {
            for (int i = 0; i < destR.size(); i++) {
                System.out.println(-1);
            }
            return;
        }
        int [][] dis = new int[r][c];
        qr.add(startR); qc.add(startC);
        vis[startR][startC] = true;
        dis[startR][startC] = 0;
        while (!qr.isEmpty()) {
            int cr = qr.poll();
            int cc = qc.poll();
            if (layout[cr][cc].equals("U") || layout[cr][cc].equals("D") || layout[cr][cc].equals("L") || layout[cr][cc].equals("R")){
                switch (layout[cr][cc]){
                    case "U":
                        qr.add(cr - 1);
                        qc.add(cc);
                        dis[cr - 1][cc] = dis[cr][cc];
                    case "D":
                        qr.add(cr + 1);
                        qc.add(cc);
                        dis[cr + 1][cc] = dis[cr][cc];
                    case "L":
                        qr.add(cr);
                        qc.add(cc - 1);
                        dis[cr][cc-1] = dis[cr][cc] + 1;
                    case "R":
                        qr.add(cr);
                        qc.add(cc + 1);
                        dis[cr][cc + 1] = dis[cr][cc];
                }
            }
            if (cr+1<r && !vis[cr+1][cc] && !layout[cr+1][cc].equals("W")){
                if (layout[cr+1][cc].equals(".") && !cameraArea[cr+1][cc]) {
                    qr.add(cr + 1);
                    qc.add(cc);
                    vis[cr + 1][cc] = true;
                    dis[cr + 1][cc] = dis[cr][cc] + 1;
                }
                else {
                    switch (layout[cr+1][cc]){
                        case "D":
                            if(!layout[cr+2][cc].equals("W") && !cameraArea[cr+2][cc] && !vis[cr+2][cc]){
                                qr.add(cr+2);
                                qc.add(cc);
                                dis[cr+2][cc] = dis[cr][cc] + 1;
                                vis[cr+2][cc] = true;
                            }
                        case "U":
                        case "L":
                            if(!layout[cr+1][cc-1].equals("W") && !cameraArea[cr+1][cc-1] && !vis[cr+1][cc-1]){
                                qr.add(cr+1);
                                qc.add(cc-1);
                                dis[cr+1][cc-1] = dis[cr][cc] + 1;
                                vis[cr+1][cc-1] = true;
                            }
                        case "R":
                            if(!layout[cr+1][cc+1].equals("W") && !cameraArea[cr+1][cc+1] && !vis[cr+1][cc+1]){
                                qr.add(cr+1);
                                qc.add(cc+1);
                                dis[cr+1][cc+1] = dis[cr][cc] + 1;
                                vis[cr+1][cc+1] = true;
                            }
                    }
                }
            }
            if (cr-1>0 && !vis[cr-1][cc] && !layout[cr-1][cc].equals("W")){
                if (layout[cr-1][cc].equals(".") && !cameraArea[cr-1][cc]) {
                    qr.add(cr - 1);
                    qc.add(cc);
                    vis[cr - 1][cc] = true;
                    dis[cr - 1][cc] = dis[cr][cc] + 1;
                }
                else {
                    switch (layout[cr-1][cc]){
                        case "U":
                            if(!layout[cr-2][cc].equals("W") && !cameraArea[cr-2][cc] && !vis[cr-2][cc]){
                                qr.add(cr-2); qc.add(cc); dis[cr-2][cc] = dis[cr][cc] + 1; vis[cr-2][cc] = true;
                            }
                        case "D":
                        case "L":
                            if(!layout[cr-1][cc-1].equals("W") && !cameraArea[cr-1][cc-1] && !vis[cr-1][cc-1]){
                                qr.add(cr-1); qc.add(cc-1); dis[cr-1][cc-1] = dis[cr][cc] + 1; vis[cr-1][cc-1] = true;
                            }
                        case "R":
                            if(!layout[cr-1][cc+1].equals("W") && !cameraArea[cr-1][cc+1] && !vis[cr-1][cc+1]){
                                qr.add(cr-1); qc.add(cc+1); dis[cr-1][cc+1] = dis[cr][cc] + 1; vis[cr-1][cc+1] = true;
                            }
                    }
                }
            }
            if (cc+1<c && !vis[cr][cc+1] && !layout[cr][cc+1].equals("W")){
                if (layout[cr][cc+1].equals(".") && !cameraArea[cr][cc+1]) {
                    qr.add(cr);
                    qc.add(cc + 1);
                    vis[cr][cc + 1] = true;
                    dis[cr][cc + 1] = dis[cr][cc] + 1;
                }
                else {
                    switch (layout[cr][cc+1]){
                        case "U":
                            if(!layout[cr-1][cc+1].equals("W") && !cameraArea[cr-1][cc+1] && !vis[cr-1][cc+1]){
                                qr.add(cr-1); qc.add(cc+1); dis[cr-1][cc+1] = dis[cr][cc] + 1; vis[cr-1][cc+1] = true;
                            }
                        case "D":
                            if(!layout[cr+1][cc+1].equals("W") && !cameraArea[cr+1][cc+1] && !vis[cr+1][cc+1]){
                                qr.add(cr+1); qc.add(cc+1); dis[cr+1][cc+1] = dis[cr][cc] + 1; vis[cr+1][cc+1] = true;
                            }
                        case "L":
                        case "R":
                            if(!layout[cr][cc+2].equals("W") && !cameraArea[cr][cc+2] && !vis[cr][cc+2]){
                                qr.add(cr); qc.add(cc+2); dis[cr][cc+2] = dis[cr][cc] + 1; vis[cr][cc+2] = true;
                            }
                    }
                }
            }
            if (cc-1>0 && !vis[cr][cc-1] && !layout[cr][cc-1].equals("W")){
                if (layout[cr][cc-1].equals(".") && !cameraArea[cr][cc-1]) {
                    qr.add(cr);
                    qc.add(cc - 1);
                    vis[cr][cc - 1] = true;
                    dis[cr][cc - 1] = dis[cr][cc] + 1;
                }
                else {
                    switch (layout[cr][cc-1]){
                        case "U":
                            if(!layout[cr-1][cc-1].equals("W") && !cameraArea[cr-1][cc-1] && !vis[cr-1][cc-1]){
                                qr.add(cr-1); qc.add(cc-1); dis[cr-1][cc-1] = dis[cr][cc] + 1; vis[cr-1][cc-1] = true;
                            }
                        case "D":
                            if(!layout[cr+1][cc-1].equals("W") && !cameraArea[cr+1][cc-1] && !vis[cr+1][cc-1]){
                                qr.add(cr+1); qc.add(cc-1); dis[cr+1][cc-1] = dis[cr][cc] + 1; vis[cr+1][cc-1] = true;
                            }
                        case "L":
                            if(!layout[cr][cc-2].equals("W") && !cameraArea[cr][cc-2] && !vis[cr][cc-2]){
                                qr.add(cr); qc.add(cc-2); dis[cr][cc-2] = dis[cr][cc] + 1; vis[cr][cc-2] = true;
                            }
                        case "R":
                    }
                }
            }
        }
        for (int i = 0; i < destR.size(); i++) {
            if (!vis[destR.get(i)][destC.get(i)]) System.out.println(-1);
            else System.out.println(dis[destR.get(i)][destC.get(i)]);
        }
    }



    static void FindCameraArea(){
        for (int i = 0; i < CamR.size(); i++) {
            int row = CamR.get(i);
            int col = CamC.get(i);
            cameraArea[row][col] = true;
            for (int j = col; j < c; j++) {
                if (layout[row][j].equals("W")) break;
                if (layout[row][j].equals(".") || layout[row][j].equals("S")){
                    cameraArea[row][j] = true;
                }
            }
            for (int j = col-1; j > 0; j--) {
                if (layout[row][j].equals("W")) break;
                if (layout[row][j].equals(".") || layout[row][j].equals("S")){
                    cameraArea[row][j] = true;
                }
            }
            for (int j = row; j < r; j++) {
                if (layout[j][col].equals("W")) break;
                if (layout[j][col].equals(".") || layout[j][col].equals("S")){
                    cameraArea[j][col] = true;
                }
            }
            for (int j = row-1; j > 0; j--) {
                if (layout[j][col].equals("W")) break;
                if (layout[j][col].equals(".") || layout[j][col].equals("S")){
                    cameraArea[j][col] = true;
                }
            }
        }
    }
}
