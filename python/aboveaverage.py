import sys


def above_average(nums):
    total = 0
    for n in nums:
        total += int(n)
    average = total/len(nums)
    count = 0;
    for n in nums:
        if int(n) > average:
            count += 1
    out = count/len(nums) * 100
    out = "{0:.3f}".format(round(out,3))
    return str(out) + "%"


if __name__ == "__main__":
    sys.stdin.readline()
    for line in sys.stdin.readlines():
        temp = line.strip().split(" ")
        print(above_average(temp[1:]))
