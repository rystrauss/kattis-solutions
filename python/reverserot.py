import sys

ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_."


def main():
    for line in sys.stdin.readlines()[:-1]:
        line = line.strip().split()
        n = int(line[0])
        message = line[1][::-1]
        encrypted = []
        for i in range(len(message)):
            encrypted.append(ALPHABET[(ALPHABET.index(message[i]) + n) % len(ALPHABET)])
        print("".join(encrypted))


if __name__ == '__main__':
    main()
