import sys

if __name__ == '__main__':
    sys.stdin.readline()
    for line in sys.stdin.readlines():
        data = line.strip().split(' ')[:-1]
        lower_bound = 0
        for i in range(len(data) - 1):
            temp = int(data[i + 1]) - int(data[i]) * 2
            if temp > 0:
                lower_bound += temp
        print(lower_bound)
