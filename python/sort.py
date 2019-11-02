import sys


def main():
    sys.stdin.readline()
    nums = [int(x) for x in sys.stdin.readline().split()]
    freq = dict()
    for e in nums:
        freq[e] = freq.get(e, 0) + 1
    order = dict()
    for e in set(nums):
        order[e] = -nums.index(e)
    nums.sort(key=lambda x: (freq[x], order[x]), reverse=True)
    print(' '.join([str(e) for e in nums]))


if __name__ == '__main__':
    main()
