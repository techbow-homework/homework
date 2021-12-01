### 解题思路
已知input是sorted distinct lowercase English letter，output是没有重复的并且也是有序的。
所以在遍历时，我们可以从当前curStr的最后一位开始update，例如：characters = abcdef, len = 3;
初始startStr = abc, endStr = def,也就是说starStr的最后一位的最大值只能是f,从c到f的所有状态都是
符合要求的答案。当c更新到f时，就可以考虑更新倒数第二位了，逻辑跟更新最后一位相同。  

所以我们首先需要确定更新curStr中的哪一位，然后在character中找到相对应的位置，最后进行更行。