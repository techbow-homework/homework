'''
 cost 2: remove central letter
 cost 1: remove first or last letter
 return min cost to remvoe all letter b
'''
class Solution():
 def removeBfromA(self, s):
  if not s: return 0
  cost,dpl,dpr =0,[float('inf')]*len(s),[float('inf')]*len(s)
  dpl[0] = 0 if s[0]=='a' else 1
  dpr[-1] = 0 if s[-1]=='a' else 1
  for i in range(1,len(s)):
   dpl[i] = min(dpl[i-1]+2,i+1) if s[i]=='b' else dpl[i-1]
  for j in range(len(s)-2,-1,-1):
   dpr[j] = min(dpr[j+1]+2, len(s)-j) if s[j]=='b' else dpr[j+1]
  return min([dpl[i]+dpr[i+1] for i in range(1,len(s)-1)]+[dpl[-1]]+[dpr[0]])


a = Solution()
print (a.removeBfromA('abbbbba')) #6
print (a.removeBfromA('abbaaba')) #5
print (a.removeBfromA('bbb')) #3