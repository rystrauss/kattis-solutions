import sys


def main():
    n = int(sys.stdin.readline())
    while n != 0:
        message = sys.stdin.readline().strip().replace(' ', '').upper()
        k = len(message)
        if k < n:
            print(message)
        else:
            encrypted = [''] * k
            i = c = 0
            while c < n and i < k:
                j = c
                while j < k:
                    encrypted[j] = message[i]
                    j += n
                    i += 1
                c += 1
            print(''.join(encrypted))
        n = int(sys.stdin.readline())


if __name__ == '__main__':
    main()
