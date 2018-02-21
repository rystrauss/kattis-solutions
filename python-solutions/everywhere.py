import sys

if __name__ == "__main__":
    testCases = int(sys.stdin.readline().strip())
    for i in range(testCases):
        numCities = int(sys.stdin.readline().strip())
        temp = set()
        for j in range(numCities):
            temp.add(sys.stdin.readline().strip())
        print(len(temp))
