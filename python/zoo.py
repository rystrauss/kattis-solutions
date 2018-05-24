import sys


if __name__ == "__main__":
    list_num = 1
    n = int(sys.stdin.readline())
    while n != 0:
        zoo = {}
        for i in range(n):
            animal = sys.stdin.readline().split(" ")[-1].lower().strip()
            if animal in zoo:
                zoo[animal] += 1
            else:
                zoo[animal] = 1
        print("List " + str(list_num) + ":")
        for key, value in sorted(zoo.items()):
            print(key + " | " + str(value))
        list_num += 1
        n = int(sys.stdin.readline())