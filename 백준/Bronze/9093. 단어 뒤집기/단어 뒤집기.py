def solve(word):
    word = list(word)
    for i in range(len(word)//2):
        temp = word[i]
        word[i] = word[-1-i]
        word[-1-i] = temp
    word = ''.join(word)
    return word
    
    
numOfSent = int(input())
ans = []
for i in range(numOfSent):
    bucket = input().split()
    for j in range(len(bucket)):
        bucket[j] = solve(bucket[j])
    sentence = ' '.join(bucket)
    ans.append(sentence)

list(map(print, ans))
