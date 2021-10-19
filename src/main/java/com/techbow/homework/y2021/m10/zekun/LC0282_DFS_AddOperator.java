package LC;
import java.util.*;
public class LC0282_DFS_AddOperator {
    public static void main(String[] args){

    }
    public List<String> addOperators(String num, int target) {
        List<String> res = new LinkedList<>();
        //cc
        if(num == null || num.length() == 0) return res;
        StringBuilder path = new StringBuilder();
        int index = 0;
        int sum = 0;
        int lastValue = 0;
        dfs(num, path, res, target, index, sum, lastValue);
        return res;
    }

    private void dfs(String num, StringBuilder path, List<String> res, int target, int index, int sum, int lastValue){
        int numlen = num.length();
        //base case
        //success
        if(index == numlen){
            if(sum == target){
                res.add(path.toString());
            }
            return;//fail case also included
        }

        //pin shu
        int val = 0;
        int pathLen = path.length();
        for(int i = index; i < numlen; i++){
            val = val * 10 + (num.charAt(i) - '0');
            if(index == 0){
                path.append(val);
                dfs(num, path, res, target, i + 1, val, val);
                path.setLength(pathLen);
                continue;
            }
            // + val
            path.append("+" + val);
            dfs(num, path, res, target, i + 1, sum + val, val);
            path.setLength(pathLen);

            //-val
            path.append("-" + val);
            dfs(num, path, res, target, i + 1, sum - val, -val);
            path.setLength(pathLen);

            //*val
            path.append("*" + val);
            dfs(num, path, res, target, i + 1, (sum - lastValue + lastValue * val), lastValue * val);
            path.setLength(pathLen);
            if(val == 0) break;
        }
    }
}
