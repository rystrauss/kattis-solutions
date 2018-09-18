import sys

if __name__ == '__main__':
    units = ["thou", "th", "inch", "in", "foot", "ft", "yard", "yd", "chain", "ch", "furlong", "fur",
             "mile", "mi", "league", "lea"]
    factors = [1, 1000, 12, 3, 22, 10, 8, 3]
    data = sys.stdin.readline().split()
    start = units.index(data[1]) // 2
    end = units.index(data[3]) // 2
    num = int(data[0])
    for i in range(abs(start - end)):
        if start < end:
            num /= factors[start + i + 1]
        else:
            num *= factors[start - i]
    print(num)
