### 解题思路：
本题有两个API，所以需要询问哪个API call的多，从题目补充条件中可以看出最多call 10^4 次getRandom()，所以应该尽可能提高
getRandom()的效率，可以存储所有input element，然后用get idx的方式获取，这样时间复杂度为O(1)，见v2解法；如果getRandom()
 call的次数少，那么使用reservoir sampling的方法，可以以O(1)空间复杂度，来完成这个任务。  

本题follow up，如果只扫描一次，空间复杂度为1，要求随机取m个元素。  
我们不妨使用一个size为m的容器，采用reservoir sampling的思路，首先判断scan第k个元素时，是否会进行更新；如果更新，那么在
size为m的容器中随机选择一个数来与第k个元素进行替换即可。