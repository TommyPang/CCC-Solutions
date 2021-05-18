import java.util.*;
import java.io.*;
/**
 * CCC '08 S3 - Maze
 * Question type: Graph Theory
 * 5/5 on DMOJ
 * @author Tommy Pang
 */
public class CCC08S3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int test_cases = Integer.parseInt(br.readLine());
        for (int i = 0; i<test_cases; i++){
            int r = Integer.parseInt(br.readLine());
            int c = Integer.parseInt(br.readLine());
            String maze[][] = new String [r+1][c+1];
            for(int row = 1; row<=r; row++){
                st = new StringTokenizer(br.readLine());
                String symbols = st.nextToken();
                for(int col = 0; col<c; col++){
                    String f = String.valueOf(symbols.charAt(col));
                    maze[row][col+1] = f;
                }
            }
            boolean visited[][] = new boolean[r+3][c+3];
            Queue<Integer> queue_row = new LinkedList<>();
            Queue<Integer> queue_col = new LinkedList<>();
            visited[1][1] = true;
            queue_row.add(1);
            queue_col.add(1);
            int distance [][] = new int[r+1][c+1];
            distance[1][1] = 1;
            while (!queue_row.isEmpty()){
                int cur_row = queue_row.poll();
                int cur_col = queue_col.poll();
                String cur = maze[cur_row][cur_col];
                if (cur.equals("*")) continue;
                else if (cur.equals("+")){
                    if (cur_row +1 <= r && !visited[cur_row+1][cur_col] && !maze[cur_row+1][cur_col].equals("*")) {queue_row.add(cur_row+1); queue_col.add(cur_col); visited[cur_row+1][cur_col] = true; distance[cur_row+1][cur_col] = distance[cur_row][cur_col] +1;}
                    if (cur_row -1 >= 1 && !visited[cur_row-1][cur_col] && !maze[cur_row-1][cur_col].equals("*")) {queue_row.add(cur_row-1); queue_col.add(cur_col); visited[cur_row-1][cur_col] = true; distance[cur_row-1][cur_col] = distance[cur_row][cur_col] +1;}
                    if (cur_col +1 <= c && !visited[cur_row][cur_col+1] && !maze[cur_row][cur_col+1].equals("*")) {queue_row.add(cur_row); queue_col.add(cur_col+1); visited[cur_row][cur_col+1] = true; distance[cur_row][cur_col+1] = distance[cur_row][cur_col] +1;}
                    if (cur_col -1 >= 1 && !visited[cur_row][cur_col-1] && !maze[cur_row][cur_col-1].equals("*")) {queue_row.add(cur_row); queue_col.add(cur_col-1); visited[cur_row][cur_col-1] = true; distance[cur_row][cur_col-1] = distance[cur_row][cur_col] +1;}
                }
                else if (cur.equals("|")){
                    if (cur_row +1 <= r && !visited[cur_row+1][cur_col] && !maze[cur_row+1][cur_col].equals("*")) {queue_row.add(cur_row+1); queue_col.add(cur_col); visited[cur_row+1][cur_col] = true; distance[cur_row+1][cur_col] = distance[cur_row][cur_col] +1;}
                    if (cur_row -1 >= 1 && !visited[cur_row-1][cur_col] && !maze[cur_row-1][cur_col].equals("*")) {queue_row.add(cur_row-1); queue_col.add(cur_col); visited[cur_row-1][cur_col] = true; distance[cur_row-1][cur_col] = distance[cur_row][cur_col] +1;}
                }
                else if (cur.equals("-")){
                    if (cur_col +1 <= c && !visited[cur_row][cur_col+1] && !maze[cur_row][cur_col+1].equals("*")) {queue_row.add(cur_row); queue_col.add(cur_col+1); visited[cur_row][cur_col+1] = true; distance[cur_row][cur_col+1] = distance[cur_row][cur_col] +1;}
                    if (cur_col -1 >= 1 && !visited[cur_row][cur_col-1] && !maze[cur_row][cur_col-1].equals("*")) {queue_row.add(cur_row); queue_col.add(cur_col-1); visited[cur_row][cur_col-1] = true; distance[cur_row][cur_col-1] = distance[cur_row][cur_col] +1;}
                }
            }
            if (visited[r][c]) System.out.println(distance[r][c]);
            else System.out.println(-1);
        }
    }
}