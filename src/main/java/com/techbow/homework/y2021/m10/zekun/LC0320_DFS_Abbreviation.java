package LC;
import java.util.*;
public class LC0320_DFS_Abbreviation {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        if(word == null || word.length() == 0) return res;
        dfs(res, new StringBuilder(), word, 0, 0);
        return res;
    }
    private void dfs(List<String> res, StringBuilder path, String word, int index, int previousCnt){
        //basecase
        //success cases
        int strLen = word.length();

        if(index == strLen){
            if(previousCnt > 0){
                int pathLen = path.length();
                path.append(previousCnt);
                res.add(path.toString());
                path.setLength(pathLen);
            }else{
                res.add(path.toString());
            }

            return;
        }
        // no fail cases
        // check visited, no need for this question because index keep increasing no decreasing

        // fen cha: 1) keep 2)change to number
        // digit
        dfs(res, path, word, index + 1, previousCnt + 1);

        //keep original char
        int pathLen = path.length();
        if(previousCnt > 0){
            path.append(previousCnt);

        }
        path.append(word.charAt(index));
        dfs(res, path, word, index + 1, 0);
        path.setLength(pathLen);


    }
}
