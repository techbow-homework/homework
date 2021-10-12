'''
 有个图，有个virus 和 antiVirus分别在某个node,每次move向周围的node感染，virus先走
 如果这个点被virus感染了 antiVirus就不能感染，反之一样
 return antiVirus最终状态占领的node数
'''
import collections
class Solution():
    def getAntiNumber(self, edges, virus, anti):
        graph = collections.defaultdict(set)
        for u,v in edges:
            graph[u].add(v)
            graph[v].add(u)
        queue = collections.deque()
        queue.append(virus)
        queue.append(anti)
        virusNum = 1
        antiNum = 1
        nxtVirusNum = 0
        nxtAntiNum = 0
        visited = set()
        visited.add(virus)
        visited.add(anti)
        res = 1
        while queue:
            while virusNum:
                virusNum-=1
                cur = queue.popleft()
                for nxt in graph[cur]:
                    if nxt not in visited:
                        visited.add(nxt)
                        queue.append(nxt)
                        nxtVirusNum+=1
            virusNum = nxtVirusNum
            nxtVirusNum=0
            while antiNum:
                antiNum-=1
                cur = queue.popleft()
                for nxt in graph[cur]:
                    if nxt not in visited:
                        visited.add(nxt)
                        queue.append(nxt)
                        nxtAntiNum+=1
            antiNum = nxtAntiNum
            nxtAntiNum= 0
            res+=antiNum
        return res


a = Solution()
print (a.getAntiNumber([[0,1],[0,3],[1,2],[1,4],[2,5],[3,4],[3,6],[4,5],[4,7],[5,8],[6,7],[7,8]],0,8))
'''
  V--V--V
  |  |  |
  V--V--A
  |  |  |
  V--A--A
tc: O(E+V*2)=> O(E+V) E-> length of edges
sc: O(E)

'''

