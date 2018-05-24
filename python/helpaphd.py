import sys


if __name__ == "__main__":
    sys.stdin.readline()
    for line in sys.stdin.readlines():
        if line.strip() == "P=NP":
            print("skipped")
        else:
            print(eval(line.strip()))
