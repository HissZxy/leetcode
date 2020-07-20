

class Solution:
    def getMinString(self,str1,str2):
        if str2 == '':
            return str1
        else:
            result = str()
            lis1 = list()
            for i in str2:
                for j in range(len(list(str1))):
                    if i==str1[j] and j not in lis1:
                        lis1.append(j)
                        break
                    elif i!=str1[j] and j==len(list(str1))-1:
                        lis1=[]
                        break
            if lis1 != []:
                lis1.sort()
                result = ''.join(str1[lis1[0]:lis1[-1]+1])
            return result