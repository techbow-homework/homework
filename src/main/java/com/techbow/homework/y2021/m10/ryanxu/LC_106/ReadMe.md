### 解题思路：
本题首先要了解三种遍历的性质，postorder的最后一个val为root的val，preorder的第一个val为root的val，
根据root的val，在inorder中找到对应的val的idx，在这个idx的左边就是所有左子树的val，右边就是右子树的val，
根据这个性质，更新dfs的范围即可得到答案。