import sys

if __name__ == "__main__":
    case_num = 1
    for line in sys.stdin.readlines():
        nums = line.strip().split(" ")[1:]
        for i in range(len(nums)):
            nums[i] = int(nums[i])
        print("Case {}: {} {} {}".format(case_num, min(nums), max(nums), max(nums) - min(nums)))
        case_num += 1
