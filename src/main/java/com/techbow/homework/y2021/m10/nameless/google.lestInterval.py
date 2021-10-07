import collections
class Solution():
    def leastInterval(self,tasks,n):
        freq = collections.Counter(tasks)
        sortedFreqValues = sorted(freq.values())
        maxFreq = sortedFreqValues.pop()
        idle = (maxFreq-1)*n
        while sortedFreqValues:
            f = sortedFreqValues.pop()
            idle -= min(f, maxFreq-1)
        # !tips: idle>=0
        idle = max(idle, 0)
        return len(tasks)+idle



a = Solution()
print (a.leastInterval(["A","A","A","B","B","B"],2)) #8
print (a.leastInterval(["A","A","A","B","B","B"],0)) # 6
print (a.leastInterval(["A","A","A","A","A","A","B","C","D","E","F","G"],2)) # 16