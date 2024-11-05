lis1,lis2 = [],[]

m,n,p = map(int,input().split())

for i in range(m):

     nums = list(map(int,input().split()))

     lis1.append(nums)

for i in range(n):

     nums = list(map(int,input().split()))

     lis2.append(nums)

res = []

for a in range(m):

     res.append([])

     for b in range(p):

         lis4 = []

         lis3 = lis1[a]

         for c in range(n):

            lis4.append(lis2[c][b])

         res_num = sum(map(lambda x,y:x*y,lis3,lis4))

         res[a].append(res_num)
print(m,p)
for i in res:

     for o in i:

         print(o,end=' ')

     print()
