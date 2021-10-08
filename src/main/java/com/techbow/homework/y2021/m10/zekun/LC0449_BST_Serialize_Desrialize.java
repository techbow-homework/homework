package LC;

import java.util.LinkedList;
import java.util.Queue;

public class LC0449_BST_Serialize_Desrialize {

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {

            StringBuilder ans = new StringBuilder();
            preOrder(root, ans);
            return ans.toString();
        }

        private void preOrder(TreeNode root, StringBuilder ans){
            if(root == null){
                ans.append(",");
                return;
            }
            ans.append(root.val).append(",");
            preOrder(root.left, ans);
            preOrder(root.right, ans);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            //c
            if(data == null || data.length() == 0) {
                TreeNode node = new TreeNode();
                node.val = 0;
                return node;
            }

            Queue<String> que = new LinkedList<String>();
            String[] dataString = data.split(",");
            for(String s : dataString){
                que.offer(s);
            }
            return deserializePreorder(que);
        }

        private TreeNode deserializePreorder(Queue<String> queue){
            String cur = queue.poll();
            if(cur == null || cur.equals("")){
                return null;
            }

            TreeNode node = new TreeNode(Integer.parseInt(cur));
            node.left = deserializePreorder(queue);
            node.right = deserializePreorder(queue);
            return node;
        }
    }


    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
}
