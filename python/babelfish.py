import sys

if __name__ == "__main__":
    d = {}
    while True:
        s = sys.stdin.readline().strip()
        if s == "":
            break
        temp = s.split(" ")
        d[temp[1]] = temp[0]
    for s in sys.stdin.readlines():
        print(d[s.strip()] if s.strip() in d else "eh")
