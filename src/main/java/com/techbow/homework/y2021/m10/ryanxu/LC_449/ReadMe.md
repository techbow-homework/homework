### 解题思路：
本题是BST，因此建议选择preorder或者postorder来serialize，因为可以根据BST的特点，即在根据preorder
中每次处理当前结点的val来更新左右子树的上下限，来确定接下来的结点，属于左子树或者右子树。