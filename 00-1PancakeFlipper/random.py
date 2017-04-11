import random
def main():
    f = open('random.in','w')
    d = "100\n"
    for i in range(0,100):
        d += writeTestCase() + '\n'
    f.write(d[:-1])
    f.close()
    
    
def writeTestCase():
    o = ""
    for j in range(0,1000):
        if random.random() < .5:
            o += '+'
        else:
            o += '-'
    o += ' ' + str(int(random.random()*20 + 1))
    return o


main()
