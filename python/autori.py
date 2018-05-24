import sys

if __name__ == "__main__":
    temp = sys.stdin.readline()
    output = ""
    for c in temp:
        if c.isupper():
            output += c
    print(output)
