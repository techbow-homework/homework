 /*option 1
        输入数组中的 graph[i]，表示顶点i所有相邻的顶点，比如对于例子2来说，顶点0和顶点1，3相连，
        顶点1和顶点0，2相连，顶点2和结点1，3相连，顶点3和顶点0，2相连。
        这道题让我们验证给定的图是否是二分图，所谓二分图，就是可以将图中的所有顶点分成两个不相交的集合，使得同一个集合的顶点不相连。
        为了验证是否有这样的两个不相交的集合存在，我们采用一种很机智的染色法，大体上的思路是要将相连的两个顶点染成不同的颜色，
        一旦在染的过程中发现有两连的两个顶点已经被染成相同的颜色，说明不是二分图。这里我们使用两种颜色，
        分别用1和 -1 来表示，初始时每个顶点用0表示未染色，然后遍历每一个顶点，
        如果该顶点未被访问过，则调用递归函数，
        如果返回 false，那么说明不是二分图，则直接返回 false。
        如果循环退出后没有返回 false，则返回 true。
        在递归函数中，如果当前顶点已经染色，如果该顶点的颜色和将要染的颜色相同，则返回 true，否则返回 false。
        如果没被染色，则将当前顶点染色，然后再遍历与该顶点相连的所有的顶点，调用递归函数，
        如果返回 false 了，则当前递归函数的返回 false，循环结束返回 true
        */
/*
 option 2 iteration
         遍历整个顶点，如果未被染色，则先染色为1，然后使用 BFS 进行遍历，将当前顶点放入队列 queue 中，
         然后 while 循环 queue 不为空，取出队首元素，遍历其所有相邻的顶点，如果相邻顶点未被染色，
         则染成和当前顶点相反的颜色，然后把相邻顶点加入 queue 中，否则如果当前顶点和相邻顶点颜色相同，
         直接返回 false，循环退出后返回 true
         */
 //BFS
 class Solution {
     public boolean isBipartite(int[][] graph) {
         int[] color = new int[graph.length];
         Arrays.fill(color, -1);//未染色为-1
         for (int i = 0; i < graph.length; i++) {
             if (color[i] == -1 && !bfs(graph, color, i)) {
                 return false;
             }
         }
         return true;
     }

     boolean bfs(int[][] graph, int[] color, int node) {
         Queue<Integer> queue = new LinkedList<Integer>();
         color[node] = 0;
         queue.add(node);
         while (!queue.isEmpty()) {
             int n = queue.poll();
             for (int i = 0; i < graph[n].length; i++) {
                 if (color[graph[n][i]] == -1) {
                     color[graph[n][i]] = color[n] ^ 1;
                     queue.add(graph[n][i]);
                 }
                 else {
                     if (color[graph[n][i]] == color[n]) {
                         return false;
                     }
                 }
             }
         }
         return true;
     }
 }