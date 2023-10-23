import sys
def stack(word, stack=[]):
    order=word[0]
    if(order=="push"):
        stack.append(word[1])
    elif(order=="pop"):
        if(len(stack)!=0):
            
            print(stack.pop())
        else:
            print(-1)
    elif(order=="size"):
        print(len(stack))
    elif(order=="empty"):
        if(len(stack)==0):
            print(1)
        else:
            print(0)
    elif(order=="top"):
        if(len(stack)==0):
            print(-1)
        else:
            print(stack[-1])





        



t=int(sys.stdin.readline())
for i in range(t):
    word=sys.stdin.readline().split()
    stack(word)


