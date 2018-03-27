import math
import sys

if __name__ == '__main__':
    with open('input.txt', 'r') as file:
        lines = file.readlines()
        lines = list(map(lambda x: x.strip(), lines))
        messages = zip(*[iter(lines)] * 2)
    for n, message in messages:
        message = message.upper().replace(' ', '')
        n = int(n)
        groups = list()
        group_size = len(message) // n + 1
        num_groups = int(math.ceil(len(message) / group_size))
        for i in range(num_groups):
            groups.append(list())
        for i, c in enumerate(message):
            groups[i // group_size].append(c)
        encryption = ''
        count = 0
        while count < len(message):
            encryption += groups[count % num_groups].pop(0)
            count += 1
        print(encryption)
