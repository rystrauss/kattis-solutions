import sys

ORDER = {
    'upper': 3,
    'middle': 2,
    'lower': 1,
}


def main():
    test_cases = int(sys.stdin.readline())
    for _ in range(test_cases):
        n = int(sys.stdin.readline())
        people = []
        for _ in range(n):
            line = sys.stdin.readline().split(':')
            name = line[0]
            rank = line[1].strip().split()[0].split('-')
            people.append((name, [ORDER[c] for c in rank]))
        for i in range(n):
            key = people[i][1][::-1]
            while len(key) < 10:
                key.append(ORDER['middle'])
            people[i] = (people[i][0], key)
        people.sort(key=lambda x: x[0])
        people.sort(key=lambda x: x[1], reverse=True)
        print('\n'.join(c[0] for c in people))
        print('==============================')


if __name__ == '__main__':
    main()
