/*        这道题给了一棵二叉树，让我们判断是否是一棵完全二叉树 Complete Binary Tree，
        通过题目中的解释可知，完全二叉树除了最后一行之外，所有位置都是满员的，而且最后一行的结点都是尽可能靠左的，
        注意跟完满二叉树 Full Bianry Tree 区分开来。最简单直接的方法就是按层序遍历二叉树，当遇到空结点时，
        后面若还出现非空结点，则一定不是完全二叉树。具体到写法就是先把根结点放入到队列中，然后进行循环，
        条件是队首结点不为空。在循环中取出队首结点，然后将其左右子结点加入队列中，这里不必判断子结点是否为空，
        为空照样加入队列，因为一旦取出空结点，循环就会停止。然后再用个循环将队首所有的空结点都移除，
        这样若是完全二叉树的话，队列中所有还剩的结点都应该是空结点，且都会被移除，若队列中存在非空结点，
        说明不是完全二叉树，最后只要判断队列是否为空即可*/
        /**
         * Definition for a binary tree node.
         * public class TreeNode {
         *     int val;
         *     TreeNode left;
         *     TreeNode right;
         *     TreeNode() {}
         *     TreeNode(int val) { this.val = val; }
         *     TreeNode(int val, TreeNode left, TreeNode right) {
         *         this.val = val;
         *         this.left = left;
         *         this.right = right;
         *     }
         * }
         */
        class Solution {
            public boolean isCompleteTree(TreeNode root) {

                Queue<TreeNode> queue = new LinkedList<>();
                queue.add(root);
                boolean treeOver = false;

                while(!queue.isEmpty()){
                    TreeNode current = queue.poll();
                    if(current.left != null && !treeOver){
                        queue.add(current.left);
                    }else if(current.left != null && treeOver){
                        return false;
                    }else{
                        treeOver = true;
                    }
                    if(current.right != null && !treeOver){
                        queue.add(current.right);
                    }else if(current.right != null && treeOver){
                        return false;
                    }else{
                        treeOver = true;
                    }
                }
                return true;
            }
        }