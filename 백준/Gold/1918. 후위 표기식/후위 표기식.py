import sys 

t=sys.stdin.readline().strip()

stack=[]
for i in t:
    if i=="(":
        stack.append(i)
    elif i=="*" or i=="/":
        while stack and (stack[-1]=="*" or stack[-1]=="/"):
            print(stack.pop() , end='')    
        stack.append(i)
    elif i=="+" or i=="-":
        while stack and stack[-1]!="(":
            print(stack.pop() , end='')
        stack.append(i)
        
    elif i==")":
        while  stack and stack[-1]!="(":
            print(stack.pop(),end='')
        stack.pop()
    else:
        print(i, end ='')


while stack:
    print(stack.pop() , end='')

