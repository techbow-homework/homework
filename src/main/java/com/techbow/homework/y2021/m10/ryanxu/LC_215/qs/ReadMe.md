### 解题思路：
跟quick sort的思路一样，平均时间复杂度为O(n)，最坏为O(n^2)；为了找到第k大的数，我们需要首先选择一个pivot，然后将array中
小于pivot的数放在左边，大与pivot的数放在右边，
> S S O O X X X L L  
> 　 　i　　t　 j

s表示小于pivot元素，o表示相等，x表示待处理，l表示大于pivot元素；如果t小于pivot,swap i 和 t，同时t++ i++,相等则t++，
小于则swap t j并且j--；最终，大于 等于 小于pivot的元素被分为三堆；
> S S O O O O O L L  
> 　 　i　　　　 j

当分类完成，可以看k落在哪个区域，如果end - j >= k，那么在[j+1, end]中继续递归；如果k在o的区域中，那么pivot即为所求，
即end - i + 1 >= k；如果k在s区域，那么我们需要在[start, i - 1]范围中递归求，k - (end - i + 1)大元素。