import sys


def num_cards(n: int):
    return n*(3*n+1)//2


if __name__ == "__main__":
    n = int(sys.stdin.readline().strip())
    while True:
        if num_cards(n) % 4 == 0:
            print(n)
            break
        n += 1
