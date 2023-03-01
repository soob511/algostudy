def solution(elements):
    numSet = set()
    l = len(elements)
    elements.extend(elements[:l-2])
    elements.insert(0,0)
    for i in range(1,len(elements)):
        elements[i] += elements[i-1]

    for cnt in range(1,l):
        for i in range(l):
            numSet.add(elements[i+cnt]-elements[i])

    return len(numSet)+1
