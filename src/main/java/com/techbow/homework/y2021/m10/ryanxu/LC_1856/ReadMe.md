### 解题思路：
brute force思路：找到每一个subarray，在每个subarray中找到minVal，然后计算min-Product。
时间复杂度为O(n^3)，本题n为10^7，所以会TLE。  
可以换个思路，如果我们先固定最小值，然后只需要找到以这个值为最小值的和最大的subarray即可，即找到
当前选定最小值的prevSmaller element和nextSmaller element。然后只需要知道这个subarray的和即可。
我们可以通过presum的方法提前计算得到。这三步的时间复杂度都为O(n)，所以整体的时间复杂度为O(n)。