package LC;
import java.util.*;
public class LC0140_DFS_WordBreakII {
    public static void main(String[] args){
        LC0140_DFS_WordBreakII obj = new LC0140_DFS_WordBreakII();
        String s = "catsanddog";
        List<String> dict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        List<String> sol = obj.wordBreak(s, dict);
        System.out.println(sol);
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<String>();
        //cc
        if(s == null || s.length() == 0 || wordDict == null) return res;
        Set<String> dict = new HashSet<String>(wordDict);
        Boolean[] mem = new Boolean[s.length()];
        StringBuilder sb = new StringBuilder();
        dfsHelper(s, dict, 0, mem, res, sb);
        return res;
    }

    private void dfsHelper(String s, Set<String> dict, int index, Boolean[] mem, List<String> res, StringBuilder sb){
        //success base case
        if(index == s.length()) {
            res.add(sb.toString());
            return;
        }

        //if(mem[index] != false) return;
        //fail base case: none
        for(int i = index; i < s.length(); i++){
            String cur = s.substring(index, i + 1);
            if(dict.contains(cur)){
                int sbLen = sb.length();
                mem[i] = true;
                sb.append(cur);
                dfsHelper(s, dict, i + 1, mem, res, sb);
                sb.setLength(sbLen);
                mem[i] = null;
            }else{
                mem[i] = false;
                continue;
            }

        }


    }
}
