import sys


def main():
    n = int(sys.stdin.readline())
    while n != 0:
        names = []
        for _ in range(n):
            names.append(sys.stdin.readline().strip())
        names.sort(key=lambda x: x[:2])
        print('\n'.join(names))
        print()
        n = int(sys.stdin.readline())


if __name__ == '__main__':
    main()
