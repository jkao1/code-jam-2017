import random

def main():
    f = open('random.in','w')
    d = "100\n"
    for i in range(0,100):
        n = int(random.random()*10000000+1)
        d += str(n) + "\n"
    f.write(d[:-1])

main();
