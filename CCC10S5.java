import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/**
 * CCC '10 S5 - Nutrient Tree
 * Question type: Dynamic Programming
 * 8/8 on DMOJ
 * @author Milliken high school -> http://mmhs.ca/ccc/index.htm
 */
public class CCC10S5 {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        int X = Integer.parseInt(br.readLine());
        TreeNode root = createTree(s);
        solve(root, X);
        System.out.println(root.maxNutrients[X]);
    }
    static TreeNode createTree(String s){
        s = s.trim();
        if (!s.startsWith("(")) return new TreeNode(Integer.parseInt(s));
        else {
            s = s.substring(1, s.length()-1).trim();
            int i;
            if (s.startsWith("(")){
                int cnt = 1; i = 1;
                while (cnt>0){
                    if (s.charAt(i)=='(') cnt+=1;
                    else if (s.charAt(i)==')') cnt-=1;
                    i+=1;
                }
            }
            else i = s.indexOf(" ");
            return new TreeNode(createTree(s.substring(0, i)), createTree(s.substring(i+1)));
        }
    }
    static void solve(TreeNode node, int growth){
        if (node.left==null){
            node.maxNutrients = new int[growth+1];
            for (int i = 0; i <= growth; i++) {
                node.maxNutrients[i] = node.value+i;
            }
        }
        else {
            solve(node.left, growth);
            int [] L = new int[growth+1];
            for (int i = 0; i <= growth; i++) {
                int max = 0;
                for (int j = 0; j <= i; j++) {
                    int temp = Math.min((1+j)*(1+j), node.left.maxNutrients[i-j]);
                    if (temp>max) max = temp;
                }
                L[i] = max;
            }
            solve(node.right, growth);
            int [] R = new int[growth+1];
            for (int i = 0; i <= growth; i++) {
                int max = 0;
                for (int j = 0; j <= i; j++) {
                    int temp = Math.min((1+j)*(1+j), node.right.maxNutrients[i-j]);
                    if (temp>max) max = temp;
                }
                R[i] = max;
            }
            node.maxNutrients = new int[growth+1];
            for (int i = 0; i <= growth; i++) {
                int max = 0;
                for (int j = 0; j <= i; j++) {
                    int temp = L[j] + R[i-j];
                    if (temp>max) max = temp;
                }
                node.maxNutrients[i] = max;
            }
        }
    }
    static class TreeNode
    {
        public int[] maxNutrients;
        public int value;
        public TreeNode left, right;

        // for a non-leaf node
        public TreeNode (TreeNode l, TreeNode r)
        {
            value = 0;
            left = l;
            right = r;
        }


        // for a leaf
        public TreeNode (int v)
        {
            value = v;
            left = null;
            right = null;
        }
    }
}
