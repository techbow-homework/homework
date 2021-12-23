### 解题思路：
如果用brute force方法，时间复杂度为O(mn)，mn分别为nums1和nums2的长度。如果用单调栈提前预处理
nums2，将所有元素的next greater element提前找到，并存入Map中，这个时间复杂度为O(n)，再处理
nums1的query，时间复杂度为O(m)+O(n)。  
本题要找next greater element，如果我们用单调递增栈来处理，例如：1,2,3,4...这样并不能找到
next greater element，如果用单调递减栈，例如：5,4,3,2,4;最后一个元素为4，我们需要将4放到正确
的位置，所以3和2需要弹栈，在弹栈的同时记录3和2的next greater element就是4。