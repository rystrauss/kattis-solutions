import sys
from collections import deque


def main():
    test_cases = int(sys.stdin.readline())
    for _ in range(test_cases):
        program = sys.stdin.readline().strip()
        n = int(sys.stdin.readline())
        if n == 0:
            sys.stdin.readline()
            nums = deque([])
        else:
            nums = deque(sys.stdin.readline().strip()[1:-1].split(','))
        flipped = False
        error = False
        for c in program:
            if c == 'R':
                flipped = not flipped
            else:
                if len(nums) == 0:
                    error = True
                    break
                if flipped:
                    nums.pop()
                else:
                    nums.popleft()
        if error:
            print('error')
            continue
        if flipped:
            nums = reversed(nums)
        print('[' + ','.join(nums) + ']')


if __name__ == '__main__':
    main()
