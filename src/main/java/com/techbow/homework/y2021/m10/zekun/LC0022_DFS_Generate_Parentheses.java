package LC;
import java.util.*;
public class LC0022_DFS_Generate_Parentheses {
    public static void main(String[] args){

    }
    public List<String> generateParenthesis(int n) {
        //cc
        List<String> res = new ArrayList<>();
        if(n <= 0) return res;

        DFS(n, 0, 0, 0, new StringBuilder(), res);
        return res;
    }

    private void DFS(int n, int index, int left, int right, StringBuilder path, List<String> res){
        //basecase
        if(index == 2 * n && left == right){
            String s = path.toString();
            res.add(s);
        }

        int len = path.length();

        if(left < n){
            path.append("(");
            DFS(n, index + 1, left + 1, right, path, res);
            path.setLength(len);
        }

        if(left > right){
            path.append(")");
            DFS(n, index + 1, left, right + 1, path, res);
            path.setLength(len);
        }
    }
}
