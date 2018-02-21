import sys


if __name__ == "__main__":
    sys.stdin.readline()
    for line in sys.stdin.readlines():
        if "simon says" in line:
            print(line[11:])
        else:
            print()
