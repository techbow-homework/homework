### 解题思路：
考察是否联通，UnionFind是有效的手段，最终问每个pair是否联通，如果是brute force方法需要check
每一种组合，时间复杂度是O(n^2 * 检查公约数cost)，如果采用 埃式筛 的思路，我们可以把满足条件的
所有点先进行union，然后check queries重的每一个pair，时间复杂度为O(nlogn)。