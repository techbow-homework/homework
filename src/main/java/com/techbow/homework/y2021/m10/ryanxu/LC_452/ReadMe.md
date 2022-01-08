### 解题思路：
每个气球的区间可以看为一个Interval，为了让射一次箭可以穿过更多的Interval可以先按照end进行排序（在排序的时候注意input
大小，防止改写compareTo函数时溢出），从小到大完成排序后，我们将所有start小于等于第一个元素的interval进行逻辑上的合并，
如下图：  
![sample](https://github.com/Ryannx/git-photo/blob/48d77ff8ee2ef2d23145ab3416f57dd57de83db3/LC_452.jpg)  

在处理第一个Interval时，并不会处理最后一个Interval，但是最终按照顺序处理，答案依然正确。