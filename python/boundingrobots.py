import sys

print('My name is {}'.format(__name__))

X = 0
Y = 1

if __name__ == '__main__':
    w, l = (int(i) for i in sys.stdin.readline().split())
    while not (w == 0 and l == 0):
        n = int(sys.stdin.readline())
        real = [0, 0]
        thinks = [0, 0]
        for i in range(n):
            direction, distance = (sys.stdin.readline().split())
            distance = int(distance)

            if direction == "u":
                thinks[Y] += distance
                real[Y] += distance
            elif direction == "r":
                thinks[X] += distance
                real[X] += distance
            elif direction == "d":
                thinks[Y] -= distance
                real[Y] -= distance
            else:
                thinks[X] -= distance
                real[X] -= distance
            if real[X] >= w:
                real[X] = w - 1
            if real[Y] >= l:
                real[Y] = l - 1
            if real[X] < 0:
                real[X] = 0
            if real[Y] < 0:
                real[Y] = 0

        print("Robot thinks {} {}".format(thinks[X], thinks[Y]))
        print("Actually at {} {}".format(real[X], real[Y]))
        print()

        w, l = (int(i) for i in sys.stdin.readline().split())
