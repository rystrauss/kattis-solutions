import sys

if __name__ == "__main__":
    for line in sys.stdin.readlines():
        temp = line.strip().split(" ")
        int1 = int(temp[0])
        int2 = int(temp[1])
        print(abs(int1 - int2))
